package com.finalProject.plantoplate.Profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.finalProject.plantoplate.AppViewModel
import com.finalProject.plantoplate.MainActivity
import com.finalProject.plantoplate.R
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment()
{
    interface ProfileListener
    {
        fun launchNewProfileFrag()
        fun launchSignInFrag()
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
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.home_btn.setOnClickListener()
        {
            activity?.startActivity(Intent(activity!!, MainActivity::class.java))
        }

        view.new_profile.setOnClickListener()
        {
            listener?.launchNewProfileFrag()
        }

        view.sign_in.setOnClickListener()
        {
            listener?.launchSignInFrag()
        }

        return view
    }
}