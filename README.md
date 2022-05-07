# KotlinMovie
# Kotlin
#Kotlin Viewpager
#Data Binding
#Kotlin Mvvm
#Kotlin Paging
#Kotlin Coroutine

Custom Build.gradle   Creation.. 

//-------------------------------MULTIPPLE MODULE CREATION && COMMON  CODE FOR MORE THAN ONE MODULE MEANS TESTING APP AND PRODUCTION APP..------------------
	1) ->Creat the Android Project
				(Module name is App)

	2) ->Creat the New Module:
				File-new-New Module-Phone&Tablet-Give the Name of the application/library name(Like profuction) -Ok-Select Empty Activity..

	3)->Creat the Library:
	 		File-new-New Module-Andriod Library-Give the Name of the Module(like CommonLibrary)-Ok-Select Empty Activity..

	4)->open the java resource in  Library:
				click on the CommonLibrary of Library Module  - click on Java resource FOlder- Creat the Activity in Library..

	5) ->  After Creat the Activity:
				open the Manifest folder in Library Module(CommonLibrary Module)- Remove the Code in Application Tag..

				->  After Manifest show  like this :
					 <manifest xmlns:android="http://schemas.android.com/apk/res/android"
					package="com.example.commonlibrary">

					<application>

					</application>

					 </manifest>
					 
	6) -> After  Import the Library project  in   Your Modules:
				Select the App module(your First Module name)  -Right click-"Open Module Settings" - "Select Dependecies" -  After Select the -" Declared  Dependecies(Module Dependecy)" - After -Select CommonLibrary( your Library name) - Ok	-Apply -Ok

				then Open the  Build.gradle.App  file (Your first module build.gradle) - after check it " implementation project(path: ':CommonLibrary')"  is Came or Not..
				if the implementation project{ like " implementation project(path: ':CommonLibrary') " } came ,   take the one copy of the  implementation project  and then put the other Module Build.gradle.production(your other module Build.gradle)

				 -> Next Creat the WRAPPER CLASS  IN LIBRARY MODULE :
				 
				 -- Click on the java resource Folder - Creat the one Class Give the Name as WrapperApplication then write the code like as below code (Kotlin)
				  
				 open class WrapperApplication :Application(){
					lateinit var  wrapperApplication: WrapperApplication
					override fun onCreate() {
						super.onCreate()
						wrapperApplication=this;
					}
				}

    7) ---> then we  Write the Coomon Code for All modules :

		before writing the Code in  Library module , we first  Inherite the Library module into YOur Modules  

			A) *****open the App module java Resource - MainActivity 
		 
		 Before:
			 class MainActivity : AppCompatActivity() {
				 override fun onCreate(savedInstanceState: Bundle?) {
					super.onCreate(savedInstanceState)
					setContentView(R.layout.activity_main)
				}
			}

		 After :
		 
			 class MainActivity : WrapperApplication() {
			   /* override fun onCreate(savedInstanceState: Bundle?) {
					super.onCreate(savedInstanceState)
					setContentView(R.layout.activity_main)
				}*/
			 }
		 
		   same like as another Module Activity 
		 
		 
			B) **** After open the  Manifest in yourmodule:
		 
				1) add the app_name( app name is your module activity name like as android:name=".MainActivity") in first line in Application tag
				2) add the App name ( app name is your Library module Activity name like as    android:name="com.example.commonlibrary.CommoActivity" ) in   Activity tag of your Module .. 
					like below 

					  BEFORE :
					 
						<application
							
							android:allowBackup="true"
							android:icon="@mipmap/ic_launcher"
							android:label="@string/app_name"
							android:roundIcon="@mipmap/ic_launcher_round"
							android:supportsRtl="true"
							android:theme="@style/Theme.GradelLibraryModule">
							<activity
								android:name=".MainActivity"
								android:exported="true">
								<intent-filter>
									<action android:name="android.intent.action.MAIN" />

									<category android:name="android.intent.category.LAUNCHER" />
								</intent-filter>
							</activity>
						</application>
						
						AFTER :
						
						 <application
							android:name=".MainActivity"
							android:allowBackup="true"
							android:icon="@mipmap/ic_launcher"
							android:label="@string/app_name"
							android:roundIcon="@mipmap/ic_launcher_round"
							android:supportsRtl="true"
							android:theme="@style/Theme.GradelLibraryModule">
							<activity
								android:name="com.example.commonlibrary.CommoActivity"
								android:exported="true">
								<intent-filter>
									<action android:name="android.intent.action.MAIN" />

									<category android:name="android.intent.category.LAUNCHER" />
								</intent-filter>
							</activity>
						</application>
					 
		 
			c)*** Open the  Manifest  file in Library module
					   
					Convert  android:exported="false" into  android:exported="true"
					   
					 before:

						<application>
							<activity
								android:name=".CommoActivity"
								android:exported="false" />
						</application>

					After:
					   <application>
							<activity
								android:name=".CommoActivity"
								android:exported="true"/>
						</application>
//--------------------------------------------------------------------------------------------------------------------------------------------

After write the Common Function in your  App library module , you Should send your Code  to github 


open the  Your project in Github - >Click on "Tags"  After Click on "RELEASES" -Creat a new release -> Click on Choose Tag- ENTER The Version num Like V1.0.0 -Click Creat new tag then Add some Description -> Select the "This is  a pre- release"- Click on "PUBLISJ RELEASE"- YOUR version num in git hub is created..

After take copy of  the Clone[link] of your Project in github..

//------------------------------------------------------------------------------------------------------------------
Next 

open the Jitpack.io ->
Paste the  Clone of Your Github version  in Look up field

then shows the version and status of you  then click the Get it after 

YOUR  Library is Created 

like as

 1) Add it in your root build.gradle at the end of repositories:
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
2) Step 2. Add the dependency
	dependencies {
	        implementation 'com.github.DhanushM3397:GradelLibraryModule:V1.0.0'
	}
//-------------------------------------------------------------------------------------------------------------------------------------------

Next
Take your gradle  to other project 
  *) First you go to  setting.gradle of your other project 
   paste your  maven gradle 
   
   maven { url 'https://jitpack.io' }
   
   *) open your library module(If u have) or Module :
   
    paste your  build.gradle 
	  implementation 'com.github.DhanushM3397:GradelLibraryModule:V1.0.0'
	 
	 
 //------------------------------------------------------------------------------------------------------------------------------------------
 next
 
 open your Activity in your other project 
   import the function from gradle
  
  like 
   val commonActivity= commonActivity()// its is Activity or class  of Build.Gradel of your custom library
            commonActivity.movetonext()// its is method of Build.gradle 
