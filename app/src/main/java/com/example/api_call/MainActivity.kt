package com.example.api_call

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.api_call.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = mViewModel

        mViewModel.getDataFromServer()

        mViewModel.newsList.observe(this,{
            if(it.isNotEmpty()){
                binding.recyclerViewId.adapter = RecyclerAdapter(it)
            }
        })

    }
}