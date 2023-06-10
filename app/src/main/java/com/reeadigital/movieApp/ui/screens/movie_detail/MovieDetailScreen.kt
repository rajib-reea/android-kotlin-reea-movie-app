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
package com.reeadigital.movieapp.ui.screens.movie_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reeadigital.movieapp.R
import com.reeadigital.movieapp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieapp.data.repository.UIState
import com.reeadigital.movieapp.ui.theme.ReeaMovieTheme

@Composable
fun MovieDetailScreen(
    movieDetailUIState: UIState<MovieDetailDTO>,
    modifier: Modifier = Modifier
) {
    when (movieDetailUIState) {
        is UIState.Loading -> LoadingScreen(modifier)
        is UIState.Success -> ResultScreen(movieDetailUIState.data.toString(), modifier)
        is UIState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun MovieListScreen(
    movieDetailUIState: MutableState<UIState<MovieDetailDTO>?>,
    modifier: Modifier = Modifier
) {
    movieDetailUIState.value?.let { it ->
        if (it is UIState.Loading) {
            LoadingScreen(modifier)
        }else if(it is UIState.Success<MovieDetailDTO>){
            ResultScreen(it.data.toString(), modifier)
        }else if(it is UIState.Error){
            ErrorScreen(modifier)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.loading_failed))
    }
}

@Composable
fun ResultScreen(movieDetailUIString: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(movieDetailUIString)
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    ReeaMovieTheme() {
        ResultScreen(stringResource(R.string.placeholder_result))
    }
}
