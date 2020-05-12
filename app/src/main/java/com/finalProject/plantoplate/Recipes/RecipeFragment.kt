package com.finalProject.plantoplate.Recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalProject.plantoplate.R

class RecipeFragment : Fragment()
{
    interface RecipeListener
    {

    }
    var rListener: RecipeListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_recipe_detail, container, false)

        return view
    }
}