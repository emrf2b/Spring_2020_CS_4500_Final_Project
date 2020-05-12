package com.finalProject.plantoplate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment()
{
    interface ProfileListener
    {

    }
    var listener: ProfileListener? = null

    lateinit var appModel: AppViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        appModel = ViewModelProvider(this).get(AppViewModel::class.java)
    }

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

        view.new_profile.setOnClickListener()
        {
            //TODO launch the create new profile fragment
        }

        view.sign_in.setOnClickListener()
        {
            //TODO launch the sign in fragment
        }

        return view
    }

}