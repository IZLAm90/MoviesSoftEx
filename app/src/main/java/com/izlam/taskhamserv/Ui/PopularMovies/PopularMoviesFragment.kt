package com.izlam.taskhamserv.Ui.PopularMovies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdapterPop
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.FragmentPopularMoviesBinding
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    lateinit var binding:FragmentPopularMoviesBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var movies_rv : RecyclerView
    private val adapter = AdapterPop()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
        getDataFromServer()
    }

    fun setUpRv(){
        movies_rv=binding.displayrecycler
        movies_rv.setHasFixedSize(false)
        movies_rv.layoutManager= GridLayoutManager(requireContext(),2)
        movies_rv.adapter=adapter
     //   viewModel.fetchAllMovies((Math.random()*10).toInt())
    }
    fun getDataFromServer(){
        viewModel.movieResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading ->{
                    Timber.d("onCreate:Loading Loading")
                }
                is NetworkResult.Success ->{
                    Timber.d("onCreate:Success ${it.data.results}")
                    if (it.data.page==0){
                        adapter.setDataFirstTime(it.data.results)
                    }
                   else{
                       if (it.data.page<=20)
                       viewModel.fetchAllMovies(it.data.page+1)
                       adapter.UpdateData(it.data.results)
                    }
                }
                is NetworkResult.Failure ->{
                    Timber.d("onCreate:Failure ${it.errorMessage}")
                }
            }
        }
    }
}