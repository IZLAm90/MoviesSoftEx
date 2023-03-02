package com.izlam.taskhamserv.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izlam.taskhamserv.databinding.ActivityMotionLayoutBinding

class MotionLayoutActivity : AppCompatActivity() {
    lateinit var binding:ActivityMotionLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMotionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}