package com.reeadigital.movieApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.reeadigital.movieApp.base.operator.GlobalResponseOperator
import com.skydoves.sandwich.SandwichInitializer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SandwichInitializer.sandwichOperators+= GlobalResponseOperator<Any>(this)
    }
}