package com.addepar.testproject.domain

import com.addepar.testproject.data.MyServer
import com.addepar.testproject.data.model.ImageDataResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageUseCase @Inject constructor(private val myServer: MyServer,private val imageRepository: ImageRepository) {

    suspend fun getImageDataFromServer(): Flow<List<ImageDataResponse>>{
        return imageRepository.getImageDataFromApi(myServer)
    }
}