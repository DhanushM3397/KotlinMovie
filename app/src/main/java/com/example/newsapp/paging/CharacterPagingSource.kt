package com.example.newsapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.api.newsApi
import com.example.newsapp.modelClass.JsonRootclass

class CharacterPagingSource(val apiService: newsApi) : PagingSource<Int, JsonRootclass>() {

    override fun getRefreshKey(state: PagingState<Int, JsonRootclass>): Int? {
        return state.anchorPosition
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, JsonRootclass> {

        val pageNumber = params.key ?: FIRST_PAGE_INDEX
        return try {
            val response = apiService.getNewsInfo(pageNumber)
            val pagedResponse = response?.body()
            val data = pagedResponse

            val responseData = mutableListOf<JsonRootclass>()
            if (data != null) {
                responseData.add(data)
            }
            LoadResult.Page(
                data = responseData,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (pageNumber < responseData[0].pages!!)
                    responseData[0].page?.plus(1) else null)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}