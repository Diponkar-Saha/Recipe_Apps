package com.example.recipe_apps.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.recipe_apps.R
import com.example.recipe_apps.databinding.FragmentDetailsBinding
import com.example.recipe_apps.models.RecipeX


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding : FragmentDetailsBinding?=null
    private val binding get()= _binding!!

    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var recipe: RecipeX


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipe = args.recipe
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            tvIngredientsDetails.text =recipe.publisher
            tvTitleRecipeDetails.text =recipe.title
            ivDetails.load(recipe.imageUrl){
                crossfade(true)
                crossfade(1000)
            }

            btnOpenWebView.setOnClickListener {mView->
                val direction = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(recipe)
                mView.findNavController().navigate(direction)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}