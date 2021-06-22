package com.example.recipe_apps.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipe_apps.R
import com.example.recipe_apps.adapter.RecipeAdapter
import com.example.recipe_apps.databinding.FragmentHomeBinding
import com.example.recipe_apps.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding:FragmentHomeBinding?=null
    private val binding get()= _binding!!

    private val viewModel:RecipeViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    private fun setUpRv() {

        recipeAdapter = RecipeAdapter()

        binding.rvRecipe.apply {
            layoutManager = GridLayoutManager(activity,2)
            setHasFixedSize(true)
            adapter =recipeAdapter

        }

        viewModel.recipeResponse.observe(requireActivity(),{response->
            recipeAdapter.recipe = response.recipes

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}