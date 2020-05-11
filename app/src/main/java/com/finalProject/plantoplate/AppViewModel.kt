package com.finalProject.plantoplate

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel()
{
//    var meals = MutableLiveData<MealSelection>()
    var meal = MealSelection(0, "")

//    var numberOfMeals: String? = null
//    private set
//
//    var typeOfMeal: String? = null
//    private set

    fun setMealInfo(no: String, type: String)
    {
//        numberOfMeals = no
//        typeOfMeal = type
//        meals.value?.number = no.toInt()
//        meals.value?.type = type
        meal.type = type
        meal.number = no.toInt()
//        Log.e("TAG", "Selection: ${meals.value?.number} and ${meals.value?.type}")
        Log.e("TAG", "Selection: ${meal.number} and ${meal.type}")
    }

//    fun selected(meal: MealSelection)
//    {
//        meals.value = meal
//    }

}