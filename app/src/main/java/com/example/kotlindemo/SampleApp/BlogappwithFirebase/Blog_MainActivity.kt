package com.example.kotlindemo.SampleApp.BlogappwithFirebase

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.EmployeeInfo
import com.example.kotlindemo.databinding.ActivityBlogmainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class Blog_MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogmainBinding
    var firebaseDatabase: FirebaseDatabase? = null

    var databaseReference: DatabaseReference? = null

    var employeeInfo: EmployeeInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogmainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseDatabase = FirebaseDatabase.getInstance()

        databaseReference = firebaseDatabase!!.getReference("EmployeeInfo")

        employeeInfo = EmployeeInfo()

        binding.idBtnSendData.setOnClickListener {


            val name: String = binding.idEdtEmployeeName.getText().toString()
            val phone: String = binding.idEdtEmployeePhoneNumber.getText().toString()
            val address: String = binding.idEdtEmployeeAddress.getText().toString()


            if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {

                Toast.makeText(this@Blog_MainActivity, "Please add some data.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                addDatatoFirebase(name, phone, address)
            }

        }

    }

    private fun addDatatoFirebase(name: String, phone: String, address: String) {
        // below 3 lines of code is used to set
        // data in our object class.
        employeeInfo!!.employeeName = name
        employeeInfo!!.employeeContactNumber = phone
        employeeInfo!!.employeeAddress = address

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference!!.setValue(employeeInfo)

                // after adding this data we are showing toast message.
                Toast.makeText(this@Blog_MainActivity, "data added", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(
                    this@Blog_MainActivity,
                    "Fail to add data $error",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }
}