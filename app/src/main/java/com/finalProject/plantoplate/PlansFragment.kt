package com.finalProject.plantoplate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_plans.*
import kotlinx.android.synthetic.main.fragment_plans.view.*


class PlansFragment : Fragment()
{
    @SuppressLint("ResourceType")
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
        val noSpinner: Spinner? = getView()?.findViewById(R.id.meal_number_spinner)
        val typeSpinner: Spinner? = getView()?.findViewById(R.id.meal_type_spinner)

        view.home_btn.setOnClickListener()
        {
            //activity?.finish()
            activity?.startActivity(Intent(activity!!, MainActivity::class.java))
            //finish()
        }

//        view.start_over.setOnClickListener()
//        {
//            typeSpinner?.setSelection(0)
//            noSpinner?.setSelection(0)
//        }

        view.get_recipes.setOnClickListener()
        {

        }

        if (noSpinner != null) {
            val noAdapter = activity?.let {
                ArrayAdapter.createFromResource(
                    it,
                    R.id.meal_number_spinner,
                    android.R.layout.simple_spinner_item
                )
                    .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
            }
            noSpinner.adapter = noAdapter
        }

        if (typeSpinner != null)
        {
            val typeAdapter = activity?.let {
                ArrayAdapter.createFromResource(
                    it,
                    R.id.meal_type_spinner,
                    android.R.layout.simple_spinner_item
                )
                    .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
            }
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
                    Log.e("TAG", "types selected?")
                    Toast.makeText(activity,getString(R.string.selected_item) + " " +"" + types[position], Toast.LENGTH_SHORT).show()
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
                    Log.e("TAG", "types selected?")
                    Toast.makeText(activity,getString(R.string.selected_item) + " " +"" + numbers[position], Toast.LENGTH_SHORT).show()
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
            Log.e("TAG", "The button works?")
        }


        return view
    }

}