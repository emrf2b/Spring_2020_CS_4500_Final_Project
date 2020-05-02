package com.finalProject.plantoplate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_plans.*
import kotlinx.android.synthetic.main.fragment_plans.view.*


class PlansFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        Log.e("TAG", "Hit the frag")
        val view = inflater.inflate(R.layout.fragment_plans, container, false)

        view.home_btn.setOnClickListener()
        {
            //activity?.finish()
            activity?.startActivity(Intent(activity!!, MainActivity::class.java))
            //finish()
        }

        return view
    }
}