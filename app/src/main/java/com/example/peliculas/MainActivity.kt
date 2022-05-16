package com.example.peliculas

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.peliculas.ui.theme.PeliculasTheme
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
                   ButtonText()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaItem() {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxHeight()
                .background(color = Color.Red)

        ) {

        }
        Box(contentAlignment= Alignment.Center,
            modifier= Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text("title 1")
        }

    }
    LazyColumn(content = )
}

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(text= stringResource(id = R.string.hello_world), modifier = modifier)
    }

    @Preview(showBackground = true, widthDp = 200, heightDp = 100)
    @Composable
    fun ButtonText() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello Antonio",
                modifier = Modifier
                    .clickable {  /*TODO*/ }
                    .background(Color.Cyan)
                    .border(width = 2.dp, color = Color.Blue)
                    .padding(horizontal = 16.dp, vertical = 8.dp)

            )
        }
    }
