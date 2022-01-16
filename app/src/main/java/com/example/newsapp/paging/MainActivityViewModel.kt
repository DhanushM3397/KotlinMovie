package com.example.newsapp.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.newsapp.api.RetrofitClient
import com.example.newsapp.modelClass.JsonRootclass
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel : ViewModel() {

    val retroService = RetrofitClient().getNewsInformation()

   /* fun getListData(): Flow<PagingData<JsonRootclass>> {
        return Pager (config = PagingConfig(pageSize = 20, maxSize = 200))


    }*/

    fun getListData(): Flow<PagingData<JsonRootclass>> {
        return Pager (config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = {CharacterPagingSource(retroService)}).flow.cachedIn(viewModelScope)
    }

}