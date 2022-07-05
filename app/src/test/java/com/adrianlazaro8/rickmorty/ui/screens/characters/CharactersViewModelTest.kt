package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import com.adrianlazaro8.rickmorty.usecases.GetPaginatedCharacters
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharactersViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var getAllCharacters: GetAllCharacters

    @RelaxedMockK
    lateinit var getPaginatedCharacter: GetPaginatedCharacters

    private lateinit var vm: CharactersViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
        vm = CharactersViewModel(getAllCharacters, getPaginatedCharacter)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When getAllCharacters is invoked, then data should be returned into state`() = runTest {
        coEvery { getAllCharacters.invoke() } returns successEither

        vm.getAllCharacters()

        Assert.assertEquals(sucessResult, vm.state)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When getAllCharacters is invoked, then use case should be invoked`() = runTest {
        coEvery { getAllCharacters.invoke() } returns successEither

        vm.getAllCharacters()

        coVerify { getAllCharacters.invoke() }
    }
}

val successEither: Either<Error, PaginatedResult<List<Character>>?> = Either.Right(null)
val sucessResult = CharactersViewModel.UiState(false, successEither)