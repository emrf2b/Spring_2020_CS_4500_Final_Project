package com.finalProject.plantoplate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel()
{
    var numberOfMeals: Int? = null
    private set

    var typeOfMeal: String? = null
    private set

    fun setMealInfo(no: Int, type: String)
    {
        numberOfMeals = no
        typeOfMeal = type
    }

}