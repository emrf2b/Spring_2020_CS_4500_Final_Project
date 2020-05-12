package com.finalProject.plantoplate

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class NewProfileDialog: DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(context!!)
            .setView(R.layout.new_profile_dialog_frag)
            .setTitle("Item Name")
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
                val firstName = (dialog as AlertDialog).findViewById<EditText>(R.id.enter_first_name)
                val lastName = dialog.findViewById<EditText>(R.id.enter_last_name)
                val email = dialog.findViewById<EditText>(R.id.enter_email)
                val userName = dialog.findViewById<EditText>(R.id.enter_user_name)
                val passWord = dialog.findViewById<EditText>(R.id.enter_pass_word)


                val intent = Intent()
                intent.putExtra("shoppingItemName", firstName?.text.toString())
                intent.putExtra("shoppingItemPrice", lastName?.text.toString())
                intent.putExtra("shoppingItemName", email?.text.toString())
                intent.putExtra("shoppingItemPrice", userName?.text.toString())
                intent.putExtra("shoppingItemName", passWord?.text.toString())

                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}