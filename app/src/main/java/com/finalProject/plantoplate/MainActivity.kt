package com.finalProject.plantoplate

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{

    private lateinit var appModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var listView: ListView
        appModel = ViewModelProvider(this).get(AppViewModel::class.java)
        val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.ptp_profile_key), Context.MODE_PRIVATE )

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

//            listView = findViewById<ListView>(R.id.recipe_list_view)
//
//            val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
//
//            val adapter = RecipeAdapter(this, recipeList)
//            listView.adapter = adapter
//
//            val context = this
//            listView.setOnItemClickListener { _, _, position, _ ->
//                val selectedRecipe = recipeList[position]
//
//                val detailIntent = RecipeDetailActivity.newIntent(context, selectedRecipe)
//
//                startActivity(detailIntent)}
//
//
        }

        my_profile_btn.setOnClickListener()
        {

//            plan_btn.visibility = View.GONE
//            share_btn.visibility = View.GONE
//            my_recipes_btn.visibility = View.GONE
//            my_profile_btn.visibility = View.GONE

            welcome_message.text = ""

            var profileFragment = supportFragmentManager.findFragmentById(R.id.fragment) as? ProfileFragment
            if (profileFragment == null)
            { profileFragment = ProfileFragment() }

            if (!profileFragment.isAdded) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment, profileFragment)
                    .commit()
            }


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

        appModel.listener = object: AppViewModel.Listener
        {
            override fun saveProfile()
            {
                Log.e("TAG", "Inside the save profile function")
                val editor = sharedPref.edit()

                val gson = Gson()
                val json = gson.toJson(appModel.profiles)

                editor.putString("Profile", json)
                    .apply()
            }

        }
    }


}
