package com.example.peliculas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@Composable
fun DetailScreen(mediaId:Int) {
    val mediaItem= remember{ getMedia().first(){it.id==mediaId} }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text =mediaItem.title)}) }
    ) {
        Thumb(item = mediaItem)
    }
}