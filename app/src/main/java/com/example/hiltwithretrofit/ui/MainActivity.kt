package com.example.hiltwithretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltwithretrofit.R
import com.example.hiltwithretrofit.databinding.ActivityMainBinding
import com.example.hiltwithretrofit.others.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = EmployeeAdapter()
        binding.rvEmployees.layoutManager = LinearLayoutManager(this)
        binding.rvEmployees.adapter = adapter

        mainViewModel.res.observe(this, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    binding. progress.visibility = View.GONE
                    binding.rvEmployees.visibility = View.VISIBLE
                    it.data.let {res->
                        res?.results.let { it1 -> adapter.submitList(it1!!) }

                        /* if (res?.status == "success"){
                             res.data?.let { it1 -> adapter.submitList(it1) }
                         }else{
                             Snackbar.make(binding.rootView, "Status = false",Snackbar.LENGTH_SHORT).show()
                         }*/
                    }
                }
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.rvEmployees.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    binding.rvEmployees.visibility = View.VISIBLE
                    Snackbar.make(binding.rootView, "Something went wrong",Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }
}