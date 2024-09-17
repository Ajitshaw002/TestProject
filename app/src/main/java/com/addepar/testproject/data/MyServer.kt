package com.addepar.testproject.data

import com.addepar.testproject.data.model.ImageDataResponse

class MyServer {

    fun getImageDataFromApi():List<ImageDataResponse>{
        val list = ArrayList<ImageDataResponse>()
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-1.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/ima-2.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-3.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-4.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-5.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-6.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-7.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-8.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-9.jpg"))
        list.add(ImageDataResponse("https://yavuzceliker.github.io/sample-images/image-10.jpg"))

        return  list
    }
}
