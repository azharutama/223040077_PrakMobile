package com.example.latihan2.ui.theme


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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormRegistrasi(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val nomorTelepon = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        InputField("Nama", nama)
        InputField("Username", username)
        InputField("Nomor Telepon", nomorTelepon, KeyboardType.Phone)
        InputField("Email", email, KeyboardType.Email)
        InputField("Alamat Rumah", alamat)

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (nama.value.text.isNotEmpty() && username.value.text.isNotEmpty() &&
                        nomorTelepon.value.text.isNotEmpty() && email.value.text.isNotEmpty() &&
                        alamat.value.text.isNotEmpty()
                    ) {
                        Toast.makeText(context, "Halo, ${nama.value.text}", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Semua inputan harus diisi!", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
            ) {
                Text(
                    text = "Simpan",
                    style = TextStyle(color = Color.White, fontSize = 18.sp),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    nama.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    nomorTelepon.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    alamat.value = TextFieldValue("")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text(
                    text = "Reset",
                    style = TextStyle(color = Color.White, fontSize = 18.sp),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun InputField(label: String, state: MutableState<TextFieldValue>, keyboardType: KeyboardType = KeyboardType.Text) {
    Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        Text(text = label)
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun FormRegistrasiPreview() {
    HelloComposeTheme {
        FormRegistrasi()
    }
}
