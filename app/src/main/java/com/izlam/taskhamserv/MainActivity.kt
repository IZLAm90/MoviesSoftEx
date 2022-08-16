package com.izlam.taskhamserv

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.ActivityMainBinding
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.popularMoviesFragment)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

//    fun setRecycler(list: ArrayList<ModelCategory>){
//        var myAdapter=CategoryAdapter(list)
//        binding.recyclerCategory.adapter=myAdapter
//        binding.recyclerCategory.layoutManager= LinearLayoutManager(this)
//        binding.recyclerCategory.setHasFixedSize(true)
//    }

    override fun onBackPressed() {
        //    super.onBackPressed()

    }
}