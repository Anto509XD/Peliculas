package com.example.peliculas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.peliculas.ui.theme.PeliculasTheme
import okhttp3.MediaType
import androidx.compose.foundation.layout.Column as Column

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PeliculasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val (value, onValueChange) = rememberSaveable{ mutableStateOf("")}
                   StateSample(
                       value= value,
                       onValueChange= onValueChange
                   )
                }
            }
        }
    }
}


@Composable
fun StateSample(value:String, onValueChange:(String)->Unit) {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = {onValueChange(it)},
            modifier=Modifier.fillMaxWidth()
        )
        Text(
                text = value,
            modifier= Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(14.dp)
        )
        Button(
            onClick= {onValueChange("")},
            modifier= Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ){
            Text(text= "Clear")
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(10.dp),
        cells = GridCells.Adaptive(150.dp)
    ){
        items(getMedia()){item->
            MediaListItem(item)
        }
    }
}


@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem) {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxHeight()
        ) {
            Image(
                painter= rememberImagePainter(
                    data= item.thumb
                ),
                contentDescription = null,
            modifier= Modifier.fillMaxSize(),
            contentScale= ContentScale.Crop
            )
            if (item.type == MediaItem.Type.VIDEO){
            Icon(
                Icons.Default.PlayCircleOutline,
            contentDescription = null,
            modifier= Modifier
                .size(92.dp)
                .align(Alignment.Center),
                tint = Color.White
            )
            }
        }
        Box(contentAlignment= Alignment.Center,
            modifier= Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text(
                text=item.title,
                style = MaterialTheme.typography.h6)
        }

    }
}


@Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(text= "Hello $name!",
        modifier = modifier)
    }

    //@Preview(showBackground = true, widthDp = 200, heightDp = 100)
    @Composable
    fun ButtonText() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text= "Hola mundo",
                style = MaterialTheme.typography.h4.copy(
                    shadow = Shadow(
                        offset = Offset(5f, 5f),
                        blurRadius = 5f,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                )
            )
        }
    }
