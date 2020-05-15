package com.finalProject.plantoplate.Recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.finalProject.plantoplate.Data.Recipe
import com.finalProject.plantoplate.R
import com.squareup.picasso.Picasso


class RecipeAdapter(private val context: Context, private val dataSource: ArrayList<Recipe>) : BaseAdapter()
{

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

//    companion object
//    {
//        private val LABEL_COLORS = hashMapOf(
//            "Low-Carb" to R.color.colorLowCarb,
//            "Low-Fat" to R.color.colorLowFat,
//            "Low-Sodium" to R.color.colorLowSodium,
//            "Medium-Carb" to R.color.colorMediumCarb,
//            "Vegetarian" to R.color.colorVegetarian,
//            "Balanced" to R.color.colorBalanced
//        )
//    }

    override fun getCount(): Int = dataSource.size
    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        // 1
        if (convertView == null)
        {

            // 2
            view = inflater.inflate(R.layout.recipe_grid_view, parent, false)

            // 3
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.recipe_img) as ImageView
//            holder.titleTextView = view.findViewById(R.id.recipe_list_title) as TextView
//            holder.subtitleTextView = view.findViewById(R.id.recipe_list_subtitle) as TextView
//            holder.detailTextView = view.findViewById(R.id.recipe_list_detail) as TextView
            holder.priceTextView = view.findViewById(R.id.recipe_price) as TextView
            holder.checkBox = view.findViewById(R.id.recipe_check_box) as CheckBox

            // 4
            view.tag = holder
        }
        else
        {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
//        val titleTextView = holder.titleTextView
//        val subtitleTextView = holder.subtitleTextView
//        val detailTextView = holder.detailTextView
        val thumbnailImageView = holder.thumbnailImageView
        val priceTextView = holder.priceTextView
        val checkBox = holder.checkBox

        val recipe = getItem(position) as Recipe

//        titleTextView.text = recipe.title
//        subtitleTextView.text = recipe.description
//        detailTextView.text = recipe.label
        priceTextView.text = recipe.Price.toString()
        checkBox.isChecked = recipe.CheckBox


        Picasso.get().load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

//        val titleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
//        titleTextView.typeface = titleTypeFace
//
//        val subtitleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
//        subtitleTextView.typeface = subtitleTypeFace
//
//        val detailTypeFace = ResourcesCompat.getFont(context, R.font.quicksand_bold)
//        detailTextView.typeface = detailTypeFace
//
//        detailTextView.setTextColor(
//            ContextCompat.getColor(context, LABEL_COLORS[recipe.label] ?: R.color.colorPrimary))

        return view
    }

    private class ViewHolder
    {
//        lateinit var titleTextView: TextView
//        lateinit var subtitleTextView: TextView
//        lateinit var detailTextView: TextView
        lateinit var priceTextView: TextView
        lateinit var checkBox: CheckBox
        lateinit var thumbnailImageView: ImageView
    }
}
