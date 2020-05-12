package com.finalProject.plantoplate

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.finalProject.plantoplate.Plans.PlansFragment
import com.finalProject.plantoplate.Profile.NewProfileDialog
import com.finalProject.plantoplate.Profile.ProfileFragment
import com.finalProject.plantoplate.Profile.SignInDialogFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{
    private lateinit var appModel: AppViewModel
    private var profFrag: ProfileFragment? = null

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
            plan_btn.visibility = View.GONE
            share_btn.visibility = View.GONE
            my_recipes_btn.visibility = View.GONE
            my_profile_btn.visibility = View.GONE

            welcome_message.text = ""

            var profileFragment = supportFragmentManager.findFragmentById(R.id.fragment) as? ProfileFragment
            if (profileFragment == null)
            { profileFragment =
                ProfileFragment()
            }

            if (!profileFragment.isAdded)
            {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment, profileFragment)
                    .commit()
            }
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
            { plansFragment = PlansFragment()
            }

            if (!plansFragment.isAdded)
            {
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

        var fragment = supportFragmentManager.findFragmentById(R.id.fragment) as? ProfileFragment
        if (fragment == null)
            fragment = ProfileFragment()

        profFrag = fragment
        profFrag?.listener = object : ProfileFragment.ProfileListener
        {
            override fun launchNewProfileFrag()
            {
                val newProfFrag = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null)
                { newProfFrag.remove(prev) }

                newProfFrag.addToBackStack(null)
                val diagFrag =
                    NewProfileDialog()
                diagFrag.setTargetFragment(profFrag, Activity.RESULT_OK)
                diagFrag.show(newProfFrag, "dialog")
            }

            override fun launchSignInFrag()
            {
                val signInFrag = supportFragmentManager.beginTransaction()
                val prev = supportFragmentManager.findFragmentByTag("dialog")
                if (prev != null)
                { signInFrag.remove(prev) }

                signInFrag.addToBackStack(null)
                val diagFrag =
                    SignInDialogFragment()
                diagFrag.setTargetFragment(profFrag, Activity.RESULT_OK)
                diagFrag.show(signInFrag, "dialog")
            }
        }
    }
}
