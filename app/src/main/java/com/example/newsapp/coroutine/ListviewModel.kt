package com.example.newsapp.coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.api.RetrofitClient
import com.example.newsapp.modelClass.episode_information.RootOFEpisodes
import com.example.newsapp.modelClass.Tv_shows
import kotlinx.coroutines.*

open class ListviewModel : ViewModel() {
    private val newsInfoService = RetrofitClient().getNewsInformation()
    var job: Job? = null


    val mutableLiveData = MutableLiveData<List<Tv_shows>>()
    val mutableEpisodeLiveData=MutableLiveData<RootOFEpisodes>()



    private val usersLoadError = MutableLiveData<String?>()
    private val loading = MutableLiveData<Boolean>()

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun refresh() {
        fetchNewsInfo()
    }


    private fun fetchNewsInfo() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = newsInfoService.getNewsInfo(1)

                withContext(Dispatchers.Main + exceptionHandler) {
                    if (response?.isSuccessful!!) {
                        mutableLiveData.value = response.body()?.tv_shows
                        usersLoadError.value = null
                        loading.value = false
                    } else {
                        onError("Error : ${response.message()} ")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun EpisodesInformation(value: String){
        fetchEpisodeInformation(value)
    }
    private fun fetchEpisodeInformation(value: String) {
        loading.value= true
        job = CoroutineScope(Dispatchers.IO).launch {
           try{
               val episodeResponse=newsInfoService.getEpisodeInfo(value)
               withContext(Dispatchers.Main+exceptionHandler){

                   if (episodeResponse.isSuccessful){

                       mutableEpisodeLiveData.value=episodeResponse.body()

                       usersLoadError.value = null
                       loading.value = false
                   }else {
                       onError("Error : ${episodeResponse.message()} ")
                   } }

           }catch (e:java.lang.Exception){
               e.printStackTrace()
           }

        }

    }

    private fun onError(message: String) {
        usersLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}