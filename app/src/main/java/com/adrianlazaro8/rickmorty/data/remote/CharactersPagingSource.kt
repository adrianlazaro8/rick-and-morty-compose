package com.adrianlazaro8.rickmorty.data.remote

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import arrow.core.getOrElse
import com.adrianlazaro8.rickmorty.data.toDomainCharacterList
import com.adrianlazaro8.rickmorty.domain.Character
import retrofit2.HttpException
import java.io.IOException

class CharactersPagingSource(
    private val remoteDataSource: RemoteDataSource
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val currentPageNumber = params.key ?: 1

        return try {
            val response = remoteDataSource.getAllCharacters(currentPageNumber)
            val paginationResponse = if (response.isRight()) {
                response.getOrElse { null }
            } else {
                null
            }

            var nextPageNumber: Int? = null
            if (paginationResponse?.info?.next != null) {
                val uri = Uri.parse(paginationResponse.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            var previousPageNumber: Int? = null
            if (paginationResponse?.info?.prev != null) {
                val uri = Uri.parse(paginationResponse.info.prev)
                val nextPageQuery = uri.getQueryParameter("page")
                previousPageNumber = nextPageQuery?.toInt()
            }

            val dataResponse = paginationResponse?.results?.toDomainCharacterList() ?: listOf()

            LoadResult.Page(
                data = dataResponse,
                prevKey = previousPageNumber,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}