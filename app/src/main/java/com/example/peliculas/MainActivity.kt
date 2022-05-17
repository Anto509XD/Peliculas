package com.example.peliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.peliculas.ui.theme.PeliculasTheme
import androidx.compose.foundation.layout.Column as Column

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main"){
                composable("main"){
                    MainScreen(navController)
                }
                composable(route = "detail/{mediaId}",
                    arguments = listOf(
                        navArgument("mediaId"){type= NavType.IntType}
                    )){backStackEntry->
                    val id=backStackEntry.arguments?.getInt("mediaId")
                    requireNotNull(id)
                    DetailScreen(id)
                }
            }

        }}
}

@Composable
private fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Transparent,  title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = null
                        )
                    }
                },
                )
        })
    { padding ->
        MediaList(Modifier.padding(padding),navController)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier=Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoilApi
@Composable
fun MediaList(modifier: Modifier = Modifier, navController: NavHostController) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        cells = GridCells.Adaptive(150.dp)
        ,modifier=modifier
    ){
        items(getMedia()){item ->

            MediaListItem(item, Modifier.padding(6.dp),navController)
        }
    }
}

//@Preview
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier, navController: NavHostController) {
    Card(
        modifier = modifier
            .clickable { navController.navigate("detail/${item.id}") },
        elevation = 12.dp,
        ) {
        Column(
        ) {
            Thumb(item)
            Title(item)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun Thumb(item: MediaItem) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(3, 3, 0, 0)), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(data = item.thumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        if (item.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier.size(92.dp),
                tint = Color.White,)
        }
    }
}
@Composable
private fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(15.dp)
    )
    {
        Text(text = item.title)
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeliculasTheme {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Greeting("Android", modifier = Modifier
                .background(Color.LightGray)
                .weight(3f))
            Greeting("Antonio", modifier = Modifier
                .background(Color.Cyan)
                .weight(1f))
        }
    }
}