package com.jimmy.cryptocurrencies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jimmy.cryptocurrencies.databinding.ActivityMainBinding
import com.jimmy.cryptocurrencies.ui.componet.LoadingDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dialogLoading by lazy { LoadingDialog() }
    private var isLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root.rootView)
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