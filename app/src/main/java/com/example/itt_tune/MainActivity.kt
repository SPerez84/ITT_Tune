package com.example.itt_tune

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itt_tune.ui.theme.ITT_TuneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ITT_TuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadrodeTexto()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ITT_TuneTheme {
        CuadrodeTexto()
    }
}

@Composable
fun CuadrodeTexto() {
    val primerTextFieldValue = remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 5.dp)
            .safeDrawingPadding()
            .fillMaxHeight()
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        OutlinedTextField (
            value = primerTextFieldValue.value,
            placeholder = { Text(text =  stringResource(id = R.string.textFieldPlaceHolder))},
            onValueChange = { newValue ->
                primerTextFieldValue.value = newValue
            }, // Acción a realizar cuando cambia el valor del cuadro de texto
            modifier = Modifier
                .padding(10.dp) // Añadir padding al cuadro de texto
                .fillMaxWidth() // Establecer el ancho del cuadro de texto en dp
                .height(IntrinsicSize.Max),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            )
        Spacer(modifier = Modifier
            .height(5.dp))
        Row(modifier = Modifier
            .wrapContentSize(Alignment.Center)) {
            botonSeleccion()
            listaIdiomas()
        }
        TextField(
            value = " ", // Valor inicial del cuadro de texto
            onValueChange = {}, // Acción a realizar cuando cambia el valor del cuadro de texto
            modifier = Modifier
                .padding(10.dp) // Añadir padding al cuadro de texto
                .fillMaxWidth()  // Establecer el ancho del cuadro de texto en dp
                .height(IntrinsicSize.Max),
            readOnly = true,
        )
    }
}

@Composable
fun botonSeleccion(modifier: Modifier = Modifier
    .wrapContentSize(Alignment.Center)){
    Button(onClick = { /*TODO*/ }) {
        Text(text = stringResource(R.string.btnSeleccionIdioma))
    }
}

@Composable
fun listaIdiomas(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = ">")
    }
}
