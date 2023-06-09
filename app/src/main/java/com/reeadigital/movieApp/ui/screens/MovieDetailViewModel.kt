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
package com.reeadigital.movieapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reeadigital.movieapp.data.datasource.remote.MovieApi
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {
    var movieDetailUIState: String by mutableStateOf("")
        private set
    init {
        getMovieDetail()
    }
    private fun getMovieDetail() {
        viewModelScope.launch {
            val listResult = MovieApi.retrofitService.getMovieDetail("tt3896198", "97edfc1b")
            movieDetailUIState = listResult
        }
    }
}
