package com.example.pertemuan3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan3.ui.theme.HelloComposeTheme
import com.example.pertemuan3.ui.theme.Pink40
import com.example.pertemuan3.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormLogin(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormLogin(modifier: Modifier = Modifier) {
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Username", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        Text(text = "Password", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            containerColor = Pink40,
            contentColor = Color.White
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            containerColor = Pink80,
            contentColor = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (username.value.text == "admin" && password.value.text == "admin") {
                        Toast.makeText(context, "Login Sukses", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Login Gagal", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = loginButtonColors
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    username.value = TextFieldValue("")
                    password.value = TextFieldValue("")
                },
                colors = resetButtonColors
            ) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormLoginPreview() {
    HelloComposeTheme {
        FormLogin()
    }
}