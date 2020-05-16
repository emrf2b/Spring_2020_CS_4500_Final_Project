package com.finalProject.plantoplate.Profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.finalProject.plantoplate.AppViewModel
import com.finalProject.plantoplate.MainActivity
import com.finalProject.plantoplate.R
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment()
{
//    interface ProfileListener
//    {
//        fun launchNewProfileFrag()
//        fun launchSignInFrag()
//    }
//    var listener: ProfileListener? = null

    lateinit var appModel: AppViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        appModel = ViewModelProvider(this).get(AppViewModel::class.java)
    }

    interface ProfileListener
    {
        fun launchNewProfileFrag()
        fun launchSignInFrag()
    }
    var listener: ProfileListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.home_btn.setOnClickListener()
        {
            activity?.startActivity(Intent(requireActivity(), MainActivity::class.java))
        }

        view.new_profile.setOnClickListener()
        {
            val newProfFrag = parentFragmentManager.beginTransaction()
            val prev = parentFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
            { newProfFrag.remove(prev) }

            newProfFrag.addToBackStack(null)

            val diagFrag = NewProfileDialog()
            diagFrag.setTargetFragment(this, Activity.RESULT_OK)
            diagFrag.show(newProfFrag, "dialog")
        }

        view.sign_in.setOnClickListener()
        {
            val signInFrag = parentFragmentManager.beginTransaction()
            val prev = parentFragmentManager.findFragmentByTag("dialog")
            if (prev != null)
            { signInFrag.remove(prev) }

            signInFrag.addToBackStack(null)
            val diagFrag = SignInDialogFragment()

            diagFrag.setTargetFragment(this, Activity.RESULT_OK)
            diagFrag.show(signInFrag, "dialog")
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        val newProf = data?.getStringExtra("newProf").toString()
        if (newProf === "1")
        {
            val firstName = data?.getStringExtra("firstName").toString()
            val lastName = data?.getStringExtra("lastName").toString()
            val email = data?.getStringExtra("email").toString()
            val userName = data?.getStringExtra("userName").toString()
            val passWord = data?.getStringExtra("passWord").toString()
            appModel.createNewProfile(firstName, lastName, email, userName, passWord)
        }
        val signIn = data?.getStringExtra("signIn").toString()
        if (signIn === "1")
        {
            val uName = data?.getStringExtra("uName").toString()
            val lastName = data?.getStringExtra("pWord").toString()

            activity?.let {Toast.makeText(it, "You signed in!", Toast.LENGTH_SHORT ).show()}
        }
    }
}