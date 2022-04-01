package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.usecases.GetAllLocations
import io.mockk.MockKAnnotations
import io.mockk.coEvery
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

class LocationsViewModelTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var getAllLocations: GetAllLocations

    private lateinit var vm: LocationsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
        vm = LocationsViewModel(getAllLocations)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When getAllLocations is invoked, then data should be returned into state`() = runTest {
        coEvery { getAllLocations.invoke() } returns successEither

        vm.getAllLocations()

        Assert.assertEquals(sucessResult, vm.state)
    }
}

val successEither: Either<Error, PaginatedResult<List<Location>>?> = Either.Right(null)
val sucessResult = LocationsViewModel.UiState(false, successEither)
