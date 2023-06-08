package com.reeadigital.movieApp

import android.app.Application
import com.reeadigital.movieApp.base.operator.GlobalResponseOperator
import com.skydoves.sandwich.SandwichInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SandwichInitializer.sandwichOperators+=GlobalResponseOperator<Any>(this)
    }
}