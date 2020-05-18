package com.finalProject.plantoplate.Profile

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.finalProject.plantoplate.R

class NewProfileDialog: DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.new_profile_dialog_frag)
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
                val firstName = (dialog as AlertDialog).findViewById<EditText>(R.id.enter_first_name)
                val lastName = dialog.findViewById<EditText>(R.id.enter_last_name)
                val email = dialog.findViewById<EditText>(R.id.enter_email)
                val userName = dialog.findViewById<EditText>(R.id.enter_user_name)
                val passWord = dialog.findViewById<EditText>(R.id.enter_pass_word)

                val intent = Intent()
                intent.putExtra("firstName", firstName?.text.toString())
                intent.putExtra("lastName", lastName?.text.toString())
                intent.putExtra("email", email?.text.toString())
                intent.putExtra("userName", userName?.text.toString())
                intent.putExtra("passWord", passWord?.text.toString())

                intent.putExtra("newProf", 1)

                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}