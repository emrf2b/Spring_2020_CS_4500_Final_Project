package com.finalProject.plantoplate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_plans.view.*


class PlansFragment : Fragment()
{
    private lateinit var appModel: AppViewModel
    private lateinit var noSelected: String
    private lateinit var typeSelected: String


    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        activity?.apply {
            appModel = ViewModelProvider(this).get(AppViewModel::class.java) }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("TAG", "Hit the frag")
        val view = inflater.inflate(R.layout.fragment_plans, container, false)

        val numbers = resources.getStringArray(R.array.meal_no)
        //Log.e("TAG", "${numbers}")
        val types = resources.getStringArray(R.array.meal_type)
        //Log.e("TAG", "${types}")
        val noSpinner = view.findViewById<Spinner>(R.id.meal_number_spinner)
        val typeSpinner = view.findViewById<Spinner>(R.id.meal_type_spinner)

        view.home_btn.setOnClickListener()
        {
            //activity?.finish()
            activity?.startActivity(Intent(activity!!, MainActivity::class.java))
            //finish()
        }

        view.get_recipes.setOnClickListener()
        {
            appModel.setMealInfo(noSelected, typeSelected)
        }

        if (noSpinner != null)
        {
            val noAdapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, numbers) }
            noSpinner.adapter = noAdapter
        }

        if (typeSpinner != null)
        {
            val typeAdapter =
                activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, types) }
            typeSpinner.adapter = typeAdapter
        }

        if (noSpinner != null)
        {
            noSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                )
                {
                    noSelected = numbers[position].toString()
                    Log.e("TAG", "Number selected $noSelected")
                }

                override fun onNothingSelected(parent: AdapterView<*>)
                {
                    //Empty
                }
            }
        }

        if (typeSpinner != null)
        {
            typeSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                )
                {
                    typeSelected = types[position].toString()
                    Log.e("TAG", "Type selected $typeSelected")
                }

                override fun onNothingSelected(parent: AdapterView<*>)
                {
                    //Empty
                }
            }
        }

        view.start_over.setOnClickListener()
        {
            typeSpinner?.setSelection(0)
            noSpinner?.setSelection(0)
        }
        return view
    }
}