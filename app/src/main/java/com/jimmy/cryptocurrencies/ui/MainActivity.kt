package com.jimmy.cryptocurrencies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.ui.componet.LoadingDialog

class MainActivity : AppCompatActivity() {

    private val dialogLoading by lazy { LoadingDialog() }
    private var isLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLoading() {
        if(!isLoading) {
            dialogLoading.start(supportFragmentManager, LoadingDialog.TAG)
            isLoading = true
        }
    }

    fun finishLoading() {
        if(isLoading) {
            dialogLoading.finish()
            isLoading = false
        }
    }
}