package com.addepar.testproject.di

import com.addepar.testproject.data.MyServer
import com.addepar.testproject.data.RepositoryImp
import com.addepar.testproject.domain.ImageRepository
import com.addepar.testproject.domain.ImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideServer():MyServer{
        return MyServer()
    }

    @Provides
    @Singleton
    fun provideRepository():ImageRepository{
        return RepositoryImp()
    }

    @Provides
    @Singleton
    fun provideUseCase(myServer: MyServer,imageRepository: ImageRepository):ImageUseCase{
        return ImageUseCase(myServer,imageRepository)
    }
}