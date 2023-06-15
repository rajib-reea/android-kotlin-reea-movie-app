/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reeadigital.movieApp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.reeadigital.movieApp.base.CustomColor
import com.reeadigital.movieApp.ui.screens.movie.MovieViewModel
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.ui.RatingBar

@Composable
fun ResultScreen(movieViewModel: MovieViewModel, detailID: String, modifier: Modifier = Modifier) {
    val movie: MovieDetailDTO? by  movieViewModel.movieFlow.collectAsState(initial = null)
    val anyStateWeCanConsider=0
    LaunchedEffect(key1 = anyStateWeCanConsider) {
        val detailID="tt3896198"
        //WE CAN NOT RUN FROM HERE. THEREFORE WE RUN IT FROM VIEWMODEL INIT().
        // movieViewModel.fetchMovieDetailById(detailID)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(CustomColor.background)
            .fillMaxSize(),
    ) {

//        AppBarWithArrow(movie?.title, pressOnBack)
//
       MovieDetailHeader(movieViewModel)
//
//        MovieDetailVideos(viewModel)
//
//        MovieDetailSummary(viewModel)
//
//        MovieDetailReviews(viewModel)
//
//        Spacer(modifier = Modifier.height(24.dp))
    }
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier.fillMaxSize()
//    ) {
//        Text(detailID)
//    }
}


@Composable
private fun MovieDetailHeader(
    movieViewModel: MovieViewModel
) {
    val movie: MovieDetailDTO? by movieViewModel.movieFlow.collectAsState(initial = null)

    Column {

       // var palette by remember { mutableStateOf<Palette?>(null) }
        AsyncImage(
            model = movie?.Poster,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
               .height(280.dp)
                .padding(horizontal = 8.dp)
        )
//        NetworkImage(
//            networkUrl = Api.getBackdropPath(movie?.backdrop_path),
//            circularReveal = CircularReveal(duration = 300),
//            shimmerParams = null,
//            bitmapPalette = BitmapPalette {
//                palette = it
//            },
//            modifier = Modifier
//                .height(280.dp)
//        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = movie?.Title ?: "",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Release Date: ${movie?.Released}",
            style = MaterialTheme.typography.body1,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

//        RatingBar(
//            rating=0f,
//            //rating = (movie?.IMDB_Votes?.toFloat() ?: 0f) / 2f,
//            color = Color((Color?.Green?.alpha ?: 0) as Int),
//            modifier = Modifier
//                .height(15.dp)
//                .align(Alignment.CenterHorizontally)
//        )
    }
}