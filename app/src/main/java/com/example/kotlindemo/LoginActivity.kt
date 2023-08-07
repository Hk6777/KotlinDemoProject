package com.example.kotlindemo

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.kotlindemo.Retrofit.SessionManager
import com.example.kotlindemo.ViewModel.LoginViewModel
import com.example.kotlindemo.databinding.ActivityLoginBinding
import com.example.kotlindemo.model.BaseResponse
import com.example.kotlindemo.model.LoginResponse
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()
    //google login
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    private companion object{
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.rlGooglelogin.setOnClickListener{
            Log.d(TAG,"onCreate: begin google SignIn")
            val intent = googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
        }

        val token = SessionManager.getToken(this)
        if (!token.isNullOrBlank()) {
            navigateToHome("")
        }

        viewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }

                else -> {
                    stopLoading()
                }
            }
        }

        binding.btnLogin.setOnClickListener {
            doLogin()

        }

        binding.btnRegister.setOnClickListener {
            doSignup()
        }


    }



    private fun navigateToHome(username: String) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(FLAG_ACTIVITY_NO_HISTORY)
        intent.putExtra("userName",username)
        startActivity(intent)

    }

    fun doLogin() {
        val uname = binding.txtInputEmail.text.toString()
        val pwd = binding.txtPass.text.toString()
        viewModel.loginUser(uname = uname, pwd = pwd)

    }

    fun doSignup() {

    }

    fun showLoading() {
        binding.llLoader.visibility = View.VISIBLE
    }

    fun stopLoading() {
        binding.llLoader.visibility = View.GONE
    }

    fun processLogin(data: LoginResponse?) {

        if (!data?.id.isNullOrEmpty()) {
            data?.id?.let { SessionManager.saveAuthToken(this, it) }
            data?.username?.let { navigateToHome(it) }
        }
    }

    fun processError(msg: String?) {
        showToast("Error:" + msg)
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }



    //google signin
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
            finish()
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            Log.d(TAG, "onActivityResult: Google SignIn intent result")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = accountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogleAccount(account)
            }catch (e: Exception){
                Log.d(TAG, "onActivityResult: ${e.message}")
            }
        }
    }

    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
        Log.d(TAG, "firebaseAuthWithGoogleAccount: begin firebase auth with google account")
        val credential = GoogleAuthProvider.getCredential(account!!.idToken,null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult->
                Log.d(TAG, "firebaseAuthWithGoogleAccount: logged in")
                val firebaseUser = firebaseAuth.currentUser
                val uid = firebaseUser?.uid
                val email = firebaseUser?.email
                Log.d(TAG, "firebaseAuthWithGoogleAccount: UID: $uid")
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Email: $email")

                if (authResult.additionalUserInfo!!.isNewUser){
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Account created")
                    Toast.makeText(this,"Account created....\n $email",Toast.LENGTH_LONG).show()
                }
                else{
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Existing User")
                    Toast.makeText(this,"Existing User... \n $email",Toast.LENGTH_LONG).show()
                }

                startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
                finish()

            }
            .addOnFailureListener {e ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Login failed due to ${e.message}")
                Toast.makeText(this," Login failed due to ${e.message}",Toast.LENGTH_LONG).show()
            }
    }
}