package com.example.peliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.peliculas.ui.theme.PeliculasTheme
import okhttp3.MediaType
import androidx.compose.foundation.layout.Column as Column

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
                   MediaList()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun MediaList() {
    LazyColumn{
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
            modifier= Modifier.size(92.dp).align(Alignment.Center),
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
