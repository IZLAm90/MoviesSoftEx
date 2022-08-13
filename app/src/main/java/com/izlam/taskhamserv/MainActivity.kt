package com.izlam.taskhamserv

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.ActivityMainBinding
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val viewModel: MainViewModel by viewModels()
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.movieResponse.observe(this){
            when(it){
                is NetworkResult.Loading ->{
                    Log.d("islam", "onCreate: Loading  ")
                }
                is NetworkResult.Success ->{
                    Log.d("islam", "onCreate: ${it.data}  ")
                }
                is NetworkResult.Failure ->{
                    Log.d("islam", "onCreate: failuer ${it.errorMessage} ")
                }
            }
        }


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