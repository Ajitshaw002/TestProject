package com.addepar.testproject.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.addepar.testproject.R
import com.addepar.testproject.data.MyServer
import com.addepar.testproject.data.RepositoryImp
import com.addepar.testproject.data.model.ImageDataResponse
import com.addepar.testproject.domain.ImageUseCase
import com.addepar.testproject.ui.theme.TestProjectTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel:MainViewModel by viewModels()



        setContent {
            TestProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val urlResponse by viewModel.imageUrlRes.collectAsState(initial = null)
                    LoadImage(urlResponse)

                }
            }
        }
    }
}

@Composable
fun LoadImage(url:List<ImageDataResponse>?) {
    url?.let {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ){
            items(it){
                ItemsData(it)
            }
        }
    }

}

@Composable
fun ItemsData(url:ImageDataResponse){

    SubcomposeAsyncImage(
        modifier = Modifier
            .width(250.dp)
            .height(170.dp),
        model = url.imgUrl,
        contentDescription = "stringResource(R.string.description)"
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading ) {
            CircularProgressIndicator(modifier = Modifier
                .width(30.dp)
                .height(30.dp))
        } else if(state is AsyncImagePainter.State.Error){
            Text(text = "Some problem occur :(", color = Color.Red)
        }else {
            SubcomposeAsyncImageContent()
        }
    }

}
