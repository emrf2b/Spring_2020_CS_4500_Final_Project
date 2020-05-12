package com.finalProject.plantoplate.Profile

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.finalProject.plantoplate.R

class SignInDialogFragment: DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        return AlertDialog.Builder(context!!)
            .setView(R.layout.signin_dialog_fragment)
            .setTitle("Item Name")
            .setPositiveButton(android.R.string.ok) { dialog, buttonId ->
//                val itemName = (dialog as AlertDialog).findViewById<EditText>(R.id.item_title)
//                val itemPrice = dialog.findViewById<EditText>(R.id.price_title)
                val intent = Intent()
//                intent.putExtra("shoppingItemName", itemName?.text.toString())
//                intent.putExtra("shoppingItemPrice", itemPrice?.text.toString())
                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }
            .create()
    }
}