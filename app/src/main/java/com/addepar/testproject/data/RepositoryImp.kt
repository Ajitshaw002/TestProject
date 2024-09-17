package com.addepar.testproject.data

import com.addepar.testproject.data.model.ImageDataResponse
import com.addepar.testproject.domain.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryImp:ImageRepository {
    override suspend fun getImageDataFromApi(myServer: MyServer): Flow<List<ImageDataResponse>> {
        return flow {
            emit(myServer.getImageDataFromApi())
        }.flowOn(Dispatchers.IO)
    }
}