package com.finalProject.plantoplate

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel()
{
    var numberOfMeals: String? = null
    private set

    var typeOfMeal: String? = null
    private set

    fun setMealInfo(no: String, type: String)
    {
        numberOfMeals = no
        typeOfMeal = type
        Log.e("TAG", "Selection: $numberOfMeals and $typeOfMeal")
    }

}