package com.finalProject.plantoplate.Recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.finalProject.plantoplate.Data.Recipe
import com.finalProject.plantoplate.R

class RecipeFragment : Fragment()
{
    interface RecipeListener
    {

    }
    var rListener: RecipeListener? = null

    private lateinit var optionSelected: String
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.recipe_grid_view, container, false)

//        val sortBySpinner = view.findViewById<Spinner>(R.id.sort_by)
//        val sortByOptions = resources.getStringArray(R.array.sort_by)
//
//        val recipeList = activity?.applicationContext?.let { Recipe.getRecipesFromFile("recipes.json", it) }
//        val adapter = activity?.applicationContext?.let {
//            if (recipeList != null) { RecipeAdapter(it, recipeList) }
//        }
//
//        recyclerView.adapter = adapter
//
//        recyclerView.setOnItemClickListener { _, _, position, _ ->
//            val selectedRecipe = recipeList?.get(position)
//        }

//        if (sortBySpinner != null)
//        {
//            val noAdapter =
//                activity?.let {
//                    ArrayAdapter(it, android.R.layout.simple_spinner_item, sortByOptions)
//                }
//            sortBySpinner.adapter = noAdapter
//        }
//
//        if (sortBySpinner != null)
//        {
//            sortBySpinner.onItemSelectedListener = object :
//                AdapterView.OnItemSelectedListener
//            {
//                override fun onItemSelected(
//                    parent: AdapterView<*>,
//                    view: View, position: Int, id: Long
//                )
//                {
//                    optionSelected = sortByOptions[position]
//                    Log.e("TAG", "Number selected $optionSelected")
//                    Toast.makeText(activity, "You selected $optionSelected", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>)
//                {
//                    //Empty
//                }
//            }
//        }

        return view
    }
}