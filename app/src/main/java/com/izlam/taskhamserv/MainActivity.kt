package com.izlam.taskhamserv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.MainViewModelFactory
import com.izlam.taskhamserv.Adapters.CategoryAdapter
import com.izlam.taskhamserv.Models.ModelCategory
import com.izlam.taskhamserv.Repositorys.Repository
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var viewModel: MainViewModel
    lateinit var binding:ActivityMainBinding
    var list:ArrayList<ModelCategory> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        getCategory()
        binding.move.setOnClickListener {
            startActivity(Intent(this,Livestreams::class.java))
        }
    }

    fun setRecycler(list: ArrayList<ModelCategory>){
        var myAdapter=CategoryAdapter(list)
        binding.recyclerCategory.adapter=myAdapter
        binding.recyclerCategory.layoutManager= LinearLayoutManager(this)
        binding.recyclerCategory.setHasFixedSize(true)
    }

    fun getCategory(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost("get_live_categories")
        viewModel.myResponse.observe(this, Observer {responce ->
            if (responce.isSuccessful){
                list=responce.body()!!
                setRecycler(list)
                Log.d("testing1",responce.body().toString())
            }
            else
                Log.d("testing2",responce.code().toString())
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}