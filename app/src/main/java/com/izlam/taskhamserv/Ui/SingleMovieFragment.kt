package com.izlam.taskhamserv.Ui

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.databinding.FragmentSingleMovieBinding
import java.sql.ResultSet

class SingleMovieFragment : Fragment() {
lateinit var binding:FragmentSingleMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSingleMovieBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (it !=null){
                val movie = it["movie"] as String
                binding.titleName.text=movie
            }
        }
    }

}