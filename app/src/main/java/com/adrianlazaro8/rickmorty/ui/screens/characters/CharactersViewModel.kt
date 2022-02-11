package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

}