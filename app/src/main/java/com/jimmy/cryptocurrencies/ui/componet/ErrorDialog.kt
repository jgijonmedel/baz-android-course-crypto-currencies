package com.jimmy.cryptocurrencies.ui.componet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.databinding.DialogErrorMessageBinding

class ErrorDialog : DialogFragment(R.layout.dialog_error_message) {

    private lateinit var binding: DialogErrorMessageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogErrorMessageBinding.bind(view)
        initUI()
        setData()
    }

    var onPositiveButton: ((ErrorDialog) -> Unit)? = null

    private fun initUI() {
        isCancelable = false
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun setData() {
        val titleDef = getString(R.string.error_title_default)
        val bodyDef = getString(R.string.error_body_default_load_data)

        binding.tvTitle.text = arguments?.getString(PARAM_TITLE) ?: titleDef
        binding.tvBody.text = arguments?.getString(PARAM_BODY) ?: bodyDef

        arguments?.getString(PARAM_TEXT_NEGATIVE_BTN)?.let {
            binding.btnNegative.text = it
        }
        arguments?.getString(PARAM_TEXT_POSITIVE_BTN)?.let {
            binding.btnPositive.text = it
        }
        binding.btnNegative.setOnClickListener { this@ErrorDialog.dismiss() }
        binding.btnPositive.setOnClickListener {
            onPositiveButton?.invoke(this@ErrorDialog) ?: this@ErrorDialog.dismiss()
        }
    }

    companion object {
        const val TAG = "Error"
        const val PARAM_TITLE = "title"
        const val PARAM_BODY = "body"
        const val PARAM_TEXT_NEGATIVE_BTN = "text_negative_button"
        const val PARAM_TEXT_POSITIVE_BTN = "text_positive_button"
    }
}
