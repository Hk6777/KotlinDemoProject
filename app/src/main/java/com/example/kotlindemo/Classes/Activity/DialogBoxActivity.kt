package com.example.kotlindemo.Classes.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.databinding.ActivityDialogboxBinding


class DialogBoxActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogboxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogboxBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDialog.setOnClickListener {
            binding.llDialogbox.visibility = View.VISIBLE
        }

        binding.btnCancle.setOnClickListener {
            binding.llDialogbox.visibility = View.GONE
        }

        binding.btnOk.setOnClickListener {
            finish()
        }

    }

    override fun onBackPressed() {
        // Create the object of AlertDialog Builder class
        val builder = AlertDialog.Builder(this)

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?")

        // Set Alert Title
        builder.setTitle("Alert !")

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false)

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes") {
            // When the user click yes button then app will close
                dialog, which -> finish()
        }

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No") {
            // If user click no then dialog box is canceled.
                dialog, which -> dialog.cancel()
        }

        // Create the Alert dialog
        val alertDialog = builder.create()
        // Show the Alert Dialog box
        alertDialog.show()
    }

}