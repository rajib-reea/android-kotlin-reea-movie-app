package com.reeadigital.movieApp

import android.app.Application
import com.reeadigital.movieApp.data.datasource.local.MovieDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {
    val database: MovieDatabase by lazy { MovieDatabase.getDatabase(this)}
}