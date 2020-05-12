package com.finalProject.plantoplate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finalProject.plantoplate.Data.MealSelection
import com.finalProject.plantoplate.Data.Profile

class AppViewModel: ViewModel()
{
    var listener: Listener? = null
    interface Listener
    {
        fun saveProfile()
    }


//    var meals = MutableLiveData<MealSelection>()
    var meal = MealSelection(0, "")
    var profiles = MutableLiveData<Profile>()

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

    fun createProfile(profile: Profile)
    {
        profiles.value = profile
    }

    fun saveProfile()
    {
        Log.e("TAG", "Made it to saving the profile")
        listener?.saveProfile()

    }

//    fun selected(meal: MealSelection)
//    {
//        meals.value = meal
//    }

    fun getMealInfo(): MealSelection
    {
        return meal
    }

}