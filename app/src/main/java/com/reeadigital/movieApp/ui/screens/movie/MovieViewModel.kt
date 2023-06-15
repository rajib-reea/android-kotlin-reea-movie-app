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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reeadigital.movieApp.base.UIState
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDTO
import com.reeadigital.movieApp.data.datasource.remote.movie.dto.MovieDetailDTO
import com.reeadigital.movieApp.domain.MovieUseCase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class MovieViewModel  @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {
   var movieListUIState: UIState<List<MovieDTO>?> by mutableStateOf(UIState.Loading)
    private set
    var movieDetailUIState: UIState<MovieDetailDTO> by mutableStateOf(UIState.Loading)
    var movieDetailTextUIState: UIState<String> by mutableStateOf(UIState.Loading)
   private set

    private val movieIdSharedFlow: MutableSharedFlow<String> = MutableSharedFlow(replay = 1)
    val movieFlow = movieIdSharedFlow.flatMapLatest {
        movieUseCase.getMovieDetail(it)
    }


 init {
           // getMovieList()
           //getMovieDetail()
            fetchMovieDetailById("tt3896198")
 }
fun fetchMovieDetailById(id: String) =viewModelScope.launch {
        movieDetailTextUIState=try{
             movieIdSharedFlow.tryEmit(id)
            UIState.Success(id)
        }catch (e:IOException){
            UIState.Error(e)
        }
    }
    private fun getMovieDetail() = viewModelScope.launch {
        movieDetailUIState= try {
            val movieDetailFlow=movieUseCase.getMovieDetail("tt3896198")
           val md= movieDetailFlow.toList()
            val movieDetail= md[0]
            UIState.Success(movieDetail)
        }catch(e: IOException){
            UIState.Error(e)
        }
    }



    private fun getMovieList() =
        viewModelScope.launch {
            movieListUIState= try {
                val movieListFlow= movieUseCase.getMovieList("open")
               val ml= movieListFlow.toList()
                val movieList= ml[0]
                UIState.Success(movieList)
            }catch(e: IOException){
                UIState.Error(e)
            }
        }
}

