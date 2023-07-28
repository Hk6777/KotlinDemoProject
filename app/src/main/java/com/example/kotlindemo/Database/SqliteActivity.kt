package com.example.kotlindemo.Database

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.databinding.ActivitySqliteDatabaseBinding

class SqliteActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySqliteDatabaseBinding


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqliteDatabaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdddata.setOnClickListener {

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DataBaseHandler(this, null)

            // creating variables for values
            // in name and age edit texts
            val name = binding.txtInputName.text.toString()
            val age = binding.txtInputAge.text.toString()

            // calling method to add
            // name to our database
            db.addName(name, age)

            // Toast to message on the screen
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            binding.txtInputName.text.clear()
            binding.txtInputAge.text.clear()
        }

        // below code is to add on  click
        // listener to our print name button
        binding.btnRead.setOnClickListener {

            // creating a DBHelper class
            // and passing context to it
            val db = DataBaseHandler(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            binding.Name.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.NAME_COl)) + "\n")
            binding.Age.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.AGE_COL)) + "\n")

            // moving our cursor to next
            // position and appending values
            while (cursor.moveToNext()) {
                binding.Name.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.NAME_COl)) + "\n")
                binding.Age.append(cursor.getString(cursor.getColumnIndex(DataBaseHandler.AGE_COL)) + "\n")
            }

            // at last we close our cursor
            cursor.close()
        }
    }
}