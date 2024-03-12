package com.example.ipz_cw_2_savchuk_andriy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.ipz_cw_2_savchuk_andriy.ui.theme.IPZ_CW_2_Savchuk_AndriyTheme
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2_Savchuk_AndriyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}

@Composable
fun SignInScreen() {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var signInSuccess by remember { mutableStateOf(false) }

    if (signInSuccess) {
        SignInSuccessScreen(email = email.text, onSignOut = {
            email = TextFieldValue()
            password = TextFieldValue()
            signInSuccess = false
        })
    } else {
        SignInForm(
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            onSignIn = {
                if (email.text.isNotBlank() && password.text.isNotBlank()) {
                    signInSuccess = true
                }
            }
        )
    }
}