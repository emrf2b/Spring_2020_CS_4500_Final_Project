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
        fun saveProfile(profile: Profile)
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
        meal.type = type
        meal.number = no.toInt()
        Log.e("TAG", "Selection: ${meal.number} and ${meal.type}")
    }

    fun createProfile(profile: Profile)
    {
        profiles.value = profile
    }

    fun createNewProfile(fN: String, lN: String, e: String, uN: String, pW: String)
    {
        val profile = Profile(fN, lN, e, uN, pW)
        saveProfile(profile)
    }

    private fun saveProfile(profile: Profile)
    {
        Log.e("TAG", "Made it to saving the profile")
        listener?.saveProfile(profile)

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

