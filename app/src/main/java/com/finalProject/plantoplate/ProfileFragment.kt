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
import kotlinx.android.synthetic.main.fragment_plans.view.home_btn
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("TAG", "Hit the frag")
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.home_btn.setOnClickListener()
        {
            activity?.startActivity(Intent(activity!!, MainActivity::class.java))
        }

        return view
    }

}