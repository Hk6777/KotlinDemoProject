package com.example.kotlindemo.JetPackComposed.Activity

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginPage2() {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var showError by remember { mutableStateOf(false) }
    val passwordTextField = remember { FocusRequester() }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Welcome Back",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Email TextField with validation
                OutlinedTextField(
                    value = email.text,
                    onValueChange = { newEmail ->
                        email = email.copy(text = newEmail)
                        showError = false
                    },
                    label = { Text("Email") },
                    isError = showError && !Validation.isValidEmail(email),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            // Focus on the password field when 'Next' is pressed
                            passwordTextField.requestFocus()
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                // Password TextField with validation
                OutlinedTextField(
                    value = password.text,
                    onValueChange = { newPassword ->
                        password = password.copy(text = newPassword)
                        showError = false
                    },
                    label = { Text("Password") },
                    isError = showError && !Validation.isValidPassword(password),
                    textStyle = MaterialTheme.typography.titleSmall,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Hide the keyboard when 'Done' is pressed
//                            LocalSoftwareKeyboardController.current?.hide()
                            // Perform login action here if both fields are valid
                            if (Validation.isValidEmail(email) && Validation.isValidPassword(
                                    password
                                )
                            ) {
                                // Perform login action
                            } else {
                                showError = true
                            }
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .focusRequester(passwordTextField)
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (showError && (!Validation.isValidEmail(email) || !Validation.isValidPassword(
                        password
                    ))
                ) {
                    Text(
                        text = "Invalid email or password",
                        color = Color.Red,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // Perform login action here if both fields are valid
                        if (Validation.isValidEmail(email) && Validation.isValidPassword(password)) {
                            // Perform login action
                        } else {
                            showError = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Login")
                }
            }
        }
    )
}



