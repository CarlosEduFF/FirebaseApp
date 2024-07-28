package com.example.firebaseapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebaseapp.ui.theme.FirebaseAppTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(db)
                }
            }
        }
    }
}

@Composable
fun App(db: FirebaseFirestore) {

    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    Column(
        Modifier.
        fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            Modifier.
            fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                text = "App Firebase Firestore")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            Modifier.
            fillMaxWidth()
        ) {

        }
        Row(
            Modifier.
            fillMaxWidth()
        ) {
            Column(
                Modifier.
                fillMaxWidth(0.3f)

            ) {
                Text(text = "Nome:", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
            }
            Column {
                TextField(
                    value = nome,
                    onValueChange = {nome = it},
                    label = { Text(text = "Nome") }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            Modifier.
            fillMaxWidth()
        ) {
            Column(
                Modifier.
                fillMaxWidth(0.3f)

            ) {
                Text(text = "Telefone:",
                    fontSize = 25.sp, fontFamily = FontFamily.Cursive
                )

            }
            Column(

            ){
                TextField(
                    value = telefone,
                    onValueChange = {telefone = it},
                    label = { Text(text = "Telefone") }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            Modifier.
            fillMaxWidth(),
            Arrangement.Center
        ) {
            Button(
                onClick = {
                    val city = hashMapOf(
                        "nome" to nome,
                        "telefone" to telefone
                    )
                    db.collection("pessoas").document("PrimeiroCliente")
                        .set(city)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written") }
                        .addOnFailureListener { e-> Log.w(ContentValues.TAG, "Error ", e) }

                },
                colors = ButtonDefaults.buttonColors(  // Cor de fundo padrão
                    contentColor = Color.White // Cor do texto do botão
                    , containerColor = Color.Blue
                ),
                modifier = Modifier.padding(20.dp) // Espaçamento do botão
                    .width(150.dp) // Largura do botão
                    .height(50.dp)
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}

@Preview
@Composable
fun appPreview(){
    val db = Firebase.firestore
    FirebaseAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App(db)
        }
    }
}