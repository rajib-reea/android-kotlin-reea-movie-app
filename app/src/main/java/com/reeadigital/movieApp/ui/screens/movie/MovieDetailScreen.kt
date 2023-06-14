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
package com.reeadigital.movieApp.ui.screens.movie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.reeadigital.movieApp.base.UIState
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.ui.screens.LoadingScreen
import com.reeadigital.movieApp.ui.screens.ResultScreen

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