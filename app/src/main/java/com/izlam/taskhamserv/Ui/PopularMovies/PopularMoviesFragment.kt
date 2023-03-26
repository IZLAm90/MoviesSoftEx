package com.izlam.taskhamserv.Ui.PopularMovies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdabterCategories
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdapterPop
import com.izlam.taskhamserv.ViewModels.MainViewModel
import com.izlam.taskhamserv.databinding.FragmentPopularMoviesBinding
import com.izlam.taskhamserv.localData.Dao
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    lateinit var binding:FragmentPopularMoviesBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var movies_rv : RecyclerView
    private lateinit var cate_rv : RecyclerView
    private val adapter = AdapterPop()
    private val adapterCat = AdabterCategories()

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerFrameLayout.startShimmer()


        setUpRv()
        setUpRvCate()
        getDataFromServer()
        getMoviesCategories()
    }

    fun setUpRv(){
        movies_rv=binding.displayrecycler
        movies_rv.setHasFixedSize(false)
        movies_rv.layoutManager= GridLayoutManager(requireContext(),2)
        movies_rv.adapter=adapter
        adapter.onClickListener = { _,movie ->
            val bundle = bundleOf("movie" to movie.id)
            findNavController().navigate(R.id.action_popularMoviesFragment_to_singleMovieFragment,bundle)
        }
    }

    fun setUpRvCate(){
        cate_rv=binding.rvGenres
        cate_rv.setHasFixedSize(true)
        cate_rv.adapter=adapterCat
        adapterCat.onClickListener = {position,model ->
            viewModel.getFilter(model.id)
            viewModel.filterList.observe(viewLifecycleOwner){
                adapter.clearData()
                adapter.filterSearch(it)
            }


        }
    }
    fun getDataFromServer(){
        viewModel.movieResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading ->{
                    Timber.d("onCreate:Loading Loading")
                }

                is NetworkResult.Success ->{
                    Timber.d("onCreate:Success ${it.data.results}")
                    binding.shimmerFrameLayout.stopShimmer()
                    binding.shimmerFrameLayout.visibility=View.GONE
                    binding.displayrecycler.visibility=View.VISIBLE
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

    fun getMoviesCategories(){
        viewModel.moviesList.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading ->{
                    Timber.d("onCreate:Loading Loading")
                    Log.d("islam", "getMoviesCategories: Loading ")
                }
                is NetworkResult.Success ->{
                    Timber.d("onCreate:Success ${it.data.gener}")
                    adapterCat.setDataFirstTime(it.data.gener)
                    Log.d("islam", "getMoviesCategories: ${it.data.gener}")
                }
                is NetworkResult.Failure ->{
                    Timber.d("onCreate:Failure ${it.errorMessage}")
                    Log.d("islam", "getMoviesCategories: ${it.errorMessage}")

                }
            }
        }
    }
}