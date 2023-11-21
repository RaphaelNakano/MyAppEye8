package com.example.myappeye8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappeye8.ui.theme.MyAppEye8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppEye8Theme {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun MyAppEye8() {
    var nome by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarsenha by remember { mutableStateOf("") }
    var cadastrar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
            )

        }
    ) { espaçoDasBarras ->
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = String.
                )
            )
    ) {
        if (cadastrar) {
            CampoDeTexto(
                value = nome,
                onValueChange = { nome = it },
                idtexto = R.string.nome
            )
        }
        CampoDeTexto(
            value = login,
            onValueChange = { login = it },
            idtexto = R.string.login
        )
        Spacer(modifier = Modifier.size(20.dp))
        CampoDeTexto(
            value = senha,
            onValueChange = { senha = it },
            idtexto = R.string.senha
        )
        if (cadastrar) {
            CampoDeTexto(
                value = confirmarsenha,
                onValueChange = { confirmarsenha = it },
                idtexto = R.string.confirmarsenha
            )
        }
        if (cadastrar) {
            Text(
                text = "Cadastrar",
                modifier = Modifier.clickable {
                    cadastrar = true
                }
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                cadastrar = false
            }
        ) {
            Text(
                text = if (cadastrar)
                    "Cadastrar"
                else
                    "Entrar"
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    idtexto: Int
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(idtexto)
            )
        }
    )

}