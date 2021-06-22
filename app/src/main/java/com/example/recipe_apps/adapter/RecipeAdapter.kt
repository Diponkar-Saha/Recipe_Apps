package com.example.recipe_apps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipe_apps.databinding.RecipeLayoutAdapterBinding
import com.example.recipe_apps.fragments.HomeFragmentDirections
import com.example.recipe_apps.models.RecipeX

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding : RecipeLayoutAdapterBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<RecipeX>(){
        override fun areItemsTheSame(oldItem: RecipeX, newItem: RecipeX): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: RecipeX, newItem: RecipeX): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var recipe:List<RecipeX>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(RecipeLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currRecipe=recipe[position]
        holder.binding.apply {
            imageView.load(currRecipe.imageUrl){
                crossfade(true)
                crossfade(1000)
            }
            tvTitleRecipe.text=currRecipe.title
        }
        holder.itemView.setOnClickListener { mView->
            val direction = HomeFragmentDirections
                .actionHomeFragmentToDetailsFragment(currRecipe)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount()=recipe.size
}