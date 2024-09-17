package com.addepar.testproject.domain

import com.addepar.testproject.data.MyServer
import com.addepar.testproject.data.model.ImageDataResponse
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    suspend fun getImageDataFromApi(myServer: MyServer): Flow<List<ImageDataResponse>>
}