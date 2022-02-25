package com.izlam.taskhamserv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.MainViewModelFactory
import com.izlam.taskhamserv.Adapters.LiveStreamAdapter
import com.izlam.taskhamserv.Models.live_streamsModel
import com.izlam.taskhamserv.Repositorys.Repository
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.ActivityLivestreamsBinding

class Livestreams : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityLivestreamsBinding
    var list :ArrayList<live_streamsModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLivestreamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCategory()

    }

    fun setrecycler(list:ArrayList<live_streamsModel>){

        var myAdapter=LiveStreamAdapter(list,this)
        binding.recyclerLivestream.adapter=myAdapter
        binding.recyclerLivestream.layoutManager= LinearLayoutManager(this)
        binding.recyclerLivestream.setHasFixedSize(true)

    }


    fun getCategory(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.get()
        viewModel.responcelive.observe(this, Observer {responce ->
            if (responce.isSuccessful){
                list= responce.body()!!
                Log.d("testing3",list.toString())
                setrecycler(list)
            }
            else
                Log.d("testing4",responce.code().toString())
        })

    }

}