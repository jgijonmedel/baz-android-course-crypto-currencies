package com.jimmy.cryptocurrencies.ui.componet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.databinding.DialogLoadingBinding

class LoadingDialog : DialogFragment(R.layout.dialog_loading) {

    private lateinit var binding: DialogLoadingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogLoadingBinding.bind(view)
        initUI()
    }

    private fun initUI() {
        isCancelable = false
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun start(manager: FragmentManager, tag: String) {
        this.show(manager, tag)
    }

    fun finish() {
        dialog?.let {
            this.dismiss()
        }
    }

    companion object {
        const val TAG = "loader"
    }
}
