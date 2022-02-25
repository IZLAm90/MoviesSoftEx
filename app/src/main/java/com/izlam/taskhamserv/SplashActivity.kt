package com.izlam.taskhamserv


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var intent = Intent(this, MainActivity::class.java)
        var fab: FloatingActionButton = findViewById(R.id.move0)
        fab.setOnClickListener { startActivity(intent) }
    }

}