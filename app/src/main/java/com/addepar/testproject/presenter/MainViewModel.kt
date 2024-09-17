package com.addepar.testproject.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.addepar.testproject.data.model.ImageDataResponse
import com.addepar.testproject.domain.ImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val imageUseCase: ImageUseCase): ViewModel() {

   private val _imageUrlRes = MutableStateFlow<List<ImageDataResponse>?>(emptyList())
    val imageUrlRes:StateFlow<List<ImageDataResponse>?> get() = _imageUrlRes


    init {
        getImageDataFromServer()
    }

    private fun getImageDataFromServer(){
        viewModelScope.launch {
            imageUseCase.getImageDataFromServer().collect{
                _imageUrlRes.value = it
            }
        }
    }
}