package com.jimmy.cryptocurrencies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jimmy.cryptocurrencies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.jimmy.cryptocurrencies.ui.componet.ErrorDialog
import com.jimmy.cryptocurrencies.ui.componet.LoadingDialog
import com.jimmy.cryptocurrencies.utils.ConnectionReceiver

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dialogLoading by lazy { LoadingDialog() }
    private val errorLoading by lazy { ErrorDialog() }
    private var isLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root.rootView)
        ConnectionReceiver(this).observe(this) { isConnected ->
            binding.messageNetwork.content.isVisible = isConnected.not()
        }
    }

    fun showErrorDialog(
        textTitle: String? = null,
        textBody: String? = null,
        textNegativeButton: String? = null,
        textPositiveButton: String? = null,
        onPositiveCation: ((ErrorDialog) -> Unit)? = null
    ) {
        val params = Bundle()
        textTitle?.let { params.putString(ErrorDialog.PARAM_TITLE, textTitle) }
        textTitle?.let { params.putString(ErrorDialog.PARAM_BODY, textBody) }
        textTitle?.let { params.putString(ErrorDialog.PARAM_TEXT_NEGATIVE_BTN, textNegativeButton) }
        textTitle?.let { params.putString(ErrorDialog.PARAM_TEXT_POSITIVE_BTN, textPositiveButton) }
        errorLoading.show(supportFragmentManager, ErrorDialog.TAG)
        errorLoading.onPositiveButton = onPositiveCation
        errorLoading.arguments = params
    }

    fun startLoading() {
        if (!isLoading) {
            dialogLoading.start(supportFragmentManager, LoadingDialog.TAG)
            isLoading = true
        }
    }

    fun finishLoading() {
        if (isLoading) {
            dialogLoading.finish()
            isLoading = false
        }
    }
}
