package com.finalProject.plantoplate.Profile

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.finalProject.plantoplate.R

class SignInDialogFragment: DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.signin_dialog_fragment)
            .setTitle("Item Name")
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
                val userName = (dialog as AlertDialog).findViewById<EditText>(R.id.edit_user_name)
                val passWord = dialog.findViewById<EditText>(R.id.edit_pass_word)
                val intent = Intent()
                intent.putExtra("uName", userName?.text.toString())
                intent.putExtra("pWord", passWord?.text.toString())

                intent.putExtra("signIn", 1)

                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}