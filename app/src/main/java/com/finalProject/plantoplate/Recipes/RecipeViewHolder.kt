package com.finalProject.plantoplate.Recipes

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recipe_grid_view.view.*

class RecipeViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var priceTextView: TextView = itemView.recipe_price
    var checkBox: CheckBox = itemView.recipe_check_box
    var thumbnailImageView: ImageView = itemView.recipe_img
}