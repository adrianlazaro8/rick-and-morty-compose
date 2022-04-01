package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adrianlazaro8.rickmorty.usecases.GetAllLocations
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule

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

}