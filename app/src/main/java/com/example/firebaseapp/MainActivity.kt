package com.example.firebaseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebaseapp.ui.theme.FirebaseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {

    var nome = ""
    Column(
        Modifier.
                fillMaxWidth()
    ) {
        Row(
            Modifier.
                fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                text = "App Firebase Firestore")
        }
        Spacer(modifier = Modifier.height(15.dp))
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
                Text(text = "Nome:")
            }
            Column {
                TextField(
                    modifier = Modifier.
                    fillMaxHeight(0.03f),
                    value = nome,
                    onValueChange = {}
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            Modifier.
            fillMaxWidth()
        ) {
            Column(
                Modifier.
                fillMaxWidth(0.3f)

            ) {
                Text(text = "Telefone:")
            }
            Column(

            ){
                TextField(
                    modifier = Modifier.
                        fillMaxHeight(0.03f),
                        value = nome,
                        onValueChange = {}
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
                onClick = { /* Ação do botão */ },
                colors = ButtonDefaults.buttonColors(
                    background = , // Cor de fundo padrão
                    contentColor = Color.White // Cor do texto do botão
                ),
                modifier = Modifier.padding(16.dp) // Espaçamento do botão
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}

@Preview
@Composable
fun appPreview(){
    FirebaseAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }
}