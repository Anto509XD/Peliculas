package com.example.peliculas

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.peliculas.R.string
import com.example.peliculas.ui.theme.PeliculasTheme
import java.util.stream.Stream.builder
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
                   MediaItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaItem() {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxHeight()


        ) {
            Image(
                painter= rememberImagePainter( data="http://via.placeholder.com/640x360",
                builder= {
                        transformations(CircleCropTransformation())
                    crossfade(true)
                }
                ),
                contentDescription = null)
        }
        Box(contentAlignment= Alignment.Center,
            modifier= Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text(
                text="title 1",
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
