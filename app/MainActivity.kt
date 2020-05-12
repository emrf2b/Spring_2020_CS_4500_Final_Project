package com.finalProject.plantoplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_plans.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var listView: ListView

        my_recipes_btn.setOnClickListener()
        {
            ptp_logo_background.visibility = View.GONE
            plan_to_plate_logo.visibility = View.GONE
            welcome_message.visibility = View.GONE
            blue_background.visibility = View.GONE
            red_background.visibility = View.GONE
            plan_btn.visibility = View.GONE
            share_btn.visibility = View.GONE
            my_recipes_btn.visibility = View.GONE
            my_profile_btn.visibility = View.GONE

            listView = findViewById<ListView>(R.id.recipe_list_view)

            val recipeList = Recipe.getRecipesFromFile("recipes.json", this)

            val adapter = RecipeAdapter(this, recipeList)
            listView.adapter = adapter

            val context = this
            listView.setOnItemClickListener { _, _, position, _ ->
                val selectedRecipe = recipeList[position]

                val detailIntent = RecipeDetailActivity.newIntent(context, selectedRecipe)

                startActivity(detailIntent)}


        }

        my_profile_btn.setOnClickListener()
        {

//            plan_btn.visibility = View.GONE
//            share_btn.visibility = View.GONE
//            my_recipes_btn.visibility = View.GONE
//            my_profile_btn.visibility = View.GONE

            welcome_message.text = ""

            Toast.makeText(applicationContext, "This goes to the profile", Toast.LENGTH_SHORT ).show()
        }

        share_btn.setOnClickListener()
        {

//            plan_btn.visibility = View.GONE
//            share_btn.visibility = View.GONE
//            my_recipes_btn.visibility = View.GONE
//            my_profile_btn.visibility = View.GONE

            welcome_message.text = ""

            Toast.makeText(applicationContext, "This shares the stuffs", Toast.LENGTH_SHORT ).show()
        }

        plan_btn.setOnClickListener()
        {

            plan_btn.visibility = View.GONE
            share_btn.visibility = View.GONE
            my_recipes_btn.visibility = View.GONE
            my_profile_btn.visibility = View.GONE

            welcome_message.text = ""

            var plansFragment = supportFragmentManager.findFragmentById(R.id.fragment) as? PlansFragment
            if (plansFragment == null)
            { plansFragment = PlansFragment() }

            if (!plansFragment.isAdded) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment, plansFragment)
                    .commit()
            }
        }
    }
}
