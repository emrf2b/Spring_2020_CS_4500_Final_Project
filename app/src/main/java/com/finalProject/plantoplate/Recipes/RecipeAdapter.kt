package com.finalProject.plantoplate.Recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.finalProject.plantoplate.Data.Recipe
import com.finalProject.plantoplate.R
import com.squareup.picasso.Picasso


class RecipeAdapter(private val context: Context, private val dataSource: ArrayList<Recipe>) : RecyclerView.Adapter<RecipeViewHolder>()
{

    private var lists: List<Recipe> = emptyList()
    private lateinit var thumbnailImageView: ImageView
    private val picasso = Picasso.get()


    override fun getItemCount(): Int = dataSource.size
    fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder
    {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recipe_grid_view, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int)
    {
        val list = dataSource[position]
        thumbnailImageView = holder.thumbnailImageView
        picasso.load(list.imageUrl)
            .error(R.mipmap.ic_launcher_round)
            .into(thumbnailImageView)

        holder.priceTextView.text = list.price

    }
}
