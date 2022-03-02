package com.adrianlazaro8.rickmorty.ui.screens.characters

import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*

import org.junit.Before

class CharactersViewModelTest {

    @MockK
    lateinit var getAllCharacters: GetAllCharacters

    @Before
    fun setUp() {
        val vm = CharactersViewModel(getAllCharacters)
    }
}