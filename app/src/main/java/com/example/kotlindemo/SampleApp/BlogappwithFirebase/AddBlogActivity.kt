package com.example.kotlindemo.SampleApp.BlogappwithFirebase

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogData
import com.example.kotlindemo.databinding.ActivityAddblogcontainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AddBlogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddblogcontainBinding

    var firebaseDatabase: FirebaseDatabase? = null

    var databaseReference: DatabaseReference? = null

    var blogData: BlogData? = null

    var downloadUri: Uri? = null


    // creating a storage reference
    var storageRef = Firebase.storage.reference;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddblogcontainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseDatabase = FirebaseDatabase.getInstance()

        databaseReference = firebaseDatabase!!.getReference()

        blogData = BlogData()

        binding.isBtnSlectImage.setOnClickListener {
            // PICK INTENT picks item from data
            // and returned selected item
            val galleryIntent = Intent(Intent.ACTION_PICK)
            // here item is type of image
            galleryIntent.type = "image/*"
            // ActivityResultLauncher callback
            imagePickerActivityResult.launch(galleryIntent)
        }

        binding.idBtnSendData.setOnClickListener {


            val title: String = binding.idEdtTitle.getText().toString()
            val details: String = binding.idEdtDetail.getText().toString()
            val auth: String = binding.idEdtAutherName.getText().toString()
            val imageurl: String = downloadUri.toString()


            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(details) && TextUtils.isEmpty(auth)) {

                Toast.makeText(this@AddBlogActivity, "Please add some data.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                addDatatoFirebase(title, details, auth, imageurl)
            }

        }
    }

    private fun addDatatoFirebase(
        title: String,
        details: String,
        auther: String,
        imageurl: String
    ) {
        // below 3 lines of code is used to set
        // data in our object class.

        var newRef = databaseReference!!.push();
        blogData!!._id = newRef.key
        blogData!!.blogtitle = title
        blogData!!.blogdetail = details
        blogData!!.blogauther = auther
        blogData!!.blogimageurl = imageurl

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {


                val postsRef: DatabaseReference = databaseReference!!.child("BlogData").child(
                    blogData!!._id!!
                )
                postsRef.setValue(blogData)

                Toast.makeText(this@AddBlogActivity, "data added", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(
                    this@AddBlogActivity,
                    "Fail to add data $error",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }


    //image upload in firebase storage and image picker code
    private var imagePickerActivityResult: ActivityResultLauncher<Intent> =
    // lambda expression to receive a result back, here we
        // receive single item(photo) on selection
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result != null) {
                // getting URI of selected Image
                val imageUri: Uri? = result.data?.data

                // val fileName = imageUri?.pathSegments?.last()

                // extract the file name with extension
                val sd = getFileName(applicationContext, imageUri!!)

                // Upload Task with upload to directory 'file'
//                 and name of the file remains same
                val ref = storageRef.child("file/$sd")
                val uploadTask = imageUri?.let { ref.putFile(it) }

//                 On success, download the file URL and display it
                val urlTask = uploadTask?.continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            throw it
                        }
                    }
                    ref.downloadUrl
                }?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        downloadUri = task.result


                        Glide.with(this)
                            .load(downloadUri)
                            .into(binding.idivuploadimage)
                    } else {
                        // Handle failures
                        // ...
                    }
                }?.addOnFailureListener {
                    Log.e("Firebase", "Failed in downloading")
                }
            }

        }


    @SuppressLint("Range")
    private fun getFileName(context: Context, uri: Uri): String? {
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                }
            }
        }
        return uri.path?.lastIndexOf('/')?.let { uri.path?.substring(it) }
    }


}




