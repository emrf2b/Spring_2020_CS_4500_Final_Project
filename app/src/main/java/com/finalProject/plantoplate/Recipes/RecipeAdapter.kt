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
//    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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

//    fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val view: View
//        val holder: RecipeViewHolder
//
//        // 1
//        if (convertView == null)
//        {
//
//            // 2
//            view = inflater.inflate(R.layout.recipe_grid_view, parent, false)
//
//            // 3
//            holder = RecipeViewHolder()
//            holder.thumbnailImageView = view.findViewById(R.id.recipe_img) as ImageView
////            holder.titleTextView = view.findViewById(R.id.recipe_list_title) as TextView
////            holder.subtitleTextView = view.findViewById(R.id.recipe_list_subtitle) as TextView
////            holder.detailTextView = view.findViewById(R.id.recipe_list_detail) as TextView
//            holder.priceTextView = view.findViewById(R.id.recipe_price) as TextView
//            holder.checkBox = view.findViewById(R.id.recipe_check_box) as CheckBox
//
//            // 4
//            view.tag = holder
//        }
//        else
//        {
//            // 5
//            view = convertView
//            holder = convertView.tag as RecipeViewHolder
//        }
//
//        // 6
////        val titleTextView = holder.titleTextView
////        val subtitleTextView = holder.subtitleTextView
////        val detailTextView = holder.detailTextView
//        val thumbnailImageView = holder.thumbnailImageView
//        val priceTextView = holder.priceTextView
//        val checkBox = holder.checkBox
//
//        val recipe = getItem(position) as Recipe
//
////        titleTextView.text = recipe.title
////        subtitleTextView.text = recipe.description
////        detailTextView.text = recipe.label
//        priceTextView.text = recipe.Price.toString()
//        checkBox.isChecked = recipe.CheckBox
//
//
//        Picasso.get().load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)
//
////        val titleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
////        titleTextView.typeface = titleTypeFace
////
////        val subtitleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
////        subtitleTextView.typeface = subtitleTypeFace
////
////        val detailTypeFace = ResourcesCompat.getFont(context, R.font.quicksand_bold)
////        detailTextView.typeface = detailTypeFace
////
////        detailTextView.setTextColor(
////            ContextCompat.getColor(context, LABEL_COLORS[recipe.label] ?: R.color.colorPrimary))
//
//        return view
//    }

//    private class ViewHolder
//    {
////        lateinit var titleTextView: TextView
////        lateinit var subtitleTextView: TextView
////        lateinit var detailTextView: TextView
//        lateinit var priceTextView: TextView
//        lateinit var checkBox: CheckBox
//        lateinit var thumbnailImageView: ImageView
//    }

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
            .placeholder(R.mipmap.ic_launcher_round)
            .into(thumbnailImageView)

        holder.priceTextView.text = list.price

    }
}
