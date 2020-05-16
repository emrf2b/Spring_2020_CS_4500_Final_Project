package com.finalProject.plantoplate.Recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.finalProject.plantoplate.Data.Recipe
import com.finalProject.plantoplate.R

class RecipeDetailActivity : AppCompatActivity()
{


//    private lateinit var webView: WebView
    private lateinit var recyclerview: RecyclerView
    private lateinit var optionSelected: String

//    companion object
//    {
//        const val EXTRA_TITLE = "title"
//        const val EXTRA_URL = "url"
//
//        fun newIntent(context: Context, recipe: Recipe): Intent
//        {
//            val detailIntent = Intent(context, RecipeDetailActivity::class.java)
//
//            detailIntent.putExtra(EXTRA_TITLE, recipe.title)
//            detailIntent.putExtra(EXTRA_URL, recipe.instructionUrl)
//
//            return detailIntent
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_recycler__view)
//        val view = inflater.inflate(R.layout.recipe_grid_view, container, false)

        val noSelected = intent.getStringExtra("noSelected")
        val typeSelected = intent.getStringExtra("typeSelected")

        val sortBySpinner = findViewById<Spinner>(R.id.recipe_list_options)
        val sortByOptions = resources.getStringArray(R.array.sort_by)

        recyclerview = findViewById(R.id.recycler_recipe_view)
        recyclerview.layoutManager = GridLayoutManager(this, 3)

        val recipeList = Recipe.getRecipesFromFile(application)
        val adapter =  RecipeAdapter(this, recipeList)

        recyclerview.adapter = adapter

        if (sortBySpinner != null)
        {
            val noAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sortByOptions)

            sortBySpinner.adapter = noAdapter
        }

        if (sortBySpinner != null)
        {
            sortBySpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                )
                {
                    optionSelected = sortByOptions[position]
                    Log.e("TAG", "Number selected $optionSelected")
                    Toast.makeText(this@RecipeDetailActivity, "You selected $noSelected and $typeSelected", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>)
                {
                    //Empty
                }
            }
        }
    }
}
