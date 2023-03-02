package com.izlam.taskhamserv.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.databinding.ActivityCollapsedBinding

class CollapsedActivity : AppCompatActivity() {
    lateinit var binding: ActivityCollapsedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCollapsedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option,menu)
        return true
    }
}