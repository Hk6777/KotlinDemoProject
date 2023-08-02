package com.example.kotlindemo

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlindemo.Classes.AllClassesActivity
import com.example.kotlindemo.Database.SqliteActivity
import com.example.kotlindemo.Google.MapActivity
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Blog_MainActivity
import com.example.kotlindemo.SampleApp.ProjectMainActivity
import com.example.kotlindemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val NOTIFICATION_PERMISSION_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (!isNotificationPermissionGranted()) {
            // Request the notification permission if it's not granted
            requestNotificationPermission()
        }

        binding.button2.setOnClickListener {
            val i = Intent(this, DiceRollActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        binding.btnmap.setOnClickListener {
            val i = Intent(this, MapActivity::class.java)
            startActivity(i)
        }
        binding.btnSqlite.setOnClickListener {
            val i = Intent(this, SqliteActivity::class.java)
            startActivity(i)
        }
        binding.btnClasses.setOnClickListener {
            val i = Intent(this, AllClassesActivity::class.java)
            startActivity(i)
        }
        binding.btnproject.setOnClickListener {
            val i = Intent(this, ProjectMainActivity::class.java)
            startActivity(i)
        }


    }

    private fun isNotificationPermissionGranted(): Boolean {
        // Check for the notification permission on Android API 23+ (Marshmallow) and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.RECEIVE_BOOT_COMPLETED
            ) == PackageManager.PERMISSION_GRANTED
        }
        return true // If not on API 23+, assume the permission is granted
    }

    private fun requestNotificationPermission() {
        // Request the notification permission
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.RECEIVE_BOOT_COMPLETED),
            NOTIFICATION_PERMISSION_REQUEST
        )
    }

}


