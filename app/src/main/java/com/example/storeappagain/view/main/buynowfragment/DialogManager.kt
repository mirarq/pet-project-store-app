package com.example.storeappagain.view.main.buynowfragment

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

object DialogManager {
    fun buyNowSettingsDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Buy now?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"YES"){_,_ ->
            Toast.makeText(context,"Congratulation!",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"NO"){_,_ ->
            Toast.makeText(context,"Sorry",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }

}