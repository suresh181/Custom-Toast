package com.example.customtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.customtoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGen.setOnClickListener {
            showToast(Constant.TOAST_TYPE_GENERAL,"General Toast")
        }
        binding.btnSuccess.setOnClickListener {
            showToast(Constant.TOAST_TYPE_SUCCESS,"Success Toast")
        }
        binding.btnError.setOnClickListener {
            showToast(Constant.TOAST_TYPE_ERROR,"Error Toast")
        }
        binding.btnWarning.setOnClickListener {
            showToast(Constant.TOAST_TYPE_WARNING,"Warning Toast")
        }
//
    }

    private fun showToast(toastType: Int,message: CharSequence) {
        val toastView = layoutInflater.inflate(
            R.layout.layout_toast,
            findViewById(R.id.layout_linear)
        )
        val toastContainer = toastView.findViewById<LinearLayout>(R.id.layout_linear)
        val imageIcon = toastView.findViewById<ImageView>(R.id.iv_icon)
        val textMessage = toastView.findViewById<TextView>(R.id.tv_msg)
        when(toastType){
            Constant.TOAST_TYPE_SUCCESS ->{
                toastContainer.setBackgroundResource(R.drawable.toast_success_bg)
                imageIcon.setImageResource(R.drawable.ic_success)
                textMessage.text = message
            }
            Constant.TOAST_TYPE_WARNING ->{
                toastContainer.setBackgroundResource(R.drawable.toast_warning_bg)
                imageIcon.setImageResource(R.drawable.ic_warning)
                textMessage.text = message
            }
            Constant.TOAST_TYPE_ERROR ->{
                toastContainer.setBackgroundResource(R.drawable.toast_error_bg)
                imageIcon.setImageResource(R.drawable.ic_error)
                textMessage.text = message
            }
        }
        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

}