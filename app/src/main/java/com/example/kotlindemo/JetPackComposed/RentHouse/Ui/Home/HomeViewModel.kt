package com.example.kotlindemo.JetPackComposed.RentHouse.Ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.UserResponce
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Repository.userRepo
import com.example.kotlindemo.Retrofit.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepo : userRepo
): ViewModel(){

    private val _state = MutableStateFlow(emptyList<UserResponce>())
    val state: StateFlow<List<UserResponce>>
        get() = _state

    /**
     * Get the values from the API
     */

    init {
        viewModelScope.launch {
            val user = userRepo.getuser()
            _state.value = user
        }
    }
}