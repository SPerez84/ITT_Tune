package com.example.itt_tune

import android.content.Context
import android.os.Bundle
import android.print.PrintAttributes.Margins
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    PantallaInicial()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ITT_TuneTheme {
        PantallaInicial()
    }
}

@Composable
fun PantallaInicial() {
    var primerTextFieldValue by remember { mutableStateOf("") }
    var traduccion : String = " "
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 5.dp)
            .safeDrawingPadding()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo()
        Spacer(modifier = Modifier.size(50.dp))
        Box(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
        ) {
            Column {
                textFieldInput(
                    primerTextFieldValue = primerTextFieldValue,
                    onValueChange = { primerTextFieldValue = it }
                )
                Spacer(modifier = Modifier.height(180.dp))
                textFieldOutput(
                    value = primerTextFieldValue,
                    onValueChange = { primerTextFieldValue = it }
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 60.dp)
                    .absoluteOffset(y = 180.dp)

            ) {
                botonCamara()
                Spacer(modifier = Modifier.size(10.dp))
                botonSeleccion()
                Spacer(modifier = Modifier.size(10.dp))
                listaIdiomas()
            }
        }
    }
}
@Composable
fun Titulo(){
    Card (modifier = Modifier
        .background(Color.Transparent)
        .wrapContentSize(Alignment.TopCenter)
        .padding(top = 15.dp)
    ){
        Surface {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "ITT TextTune",
                    fontFamily = FontFamily.Serif,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.size(10.dp))
                Image(painter = painterResource(id = R.drawable.logo_textune),
                    contentDescription ="logoTextune" ,
                    modifier = Modifier.size(35.dp))
            }
        }
    }
}
@Composable
fun textFieldInput(
    primerTextFieldValue: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField (
        label = { Text(text =  stringResource(id = R.string.textFieldPlaceHolder))},
        value = primerTextFieldValue,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(200.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
    )
}

@Composable
fun botonSeleccion(modifier: Modifier = Modifier
    //.wrapContentSize(Alignment.Center)
    ){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.width(100.dp)

    ) {
        Text(text = stringResource(R.string.btnSeleccionIdioma)
            )
    }
}

@Composable
fun botonCamara(modifier: Modifier = Modifier
   // .wrapContentSize(Alignment.Center)
){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(60.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.camara), contentDescription = "camBtn")
    }
}

@Composable
fun listaIdiomas(){
    FloatingActionButton(onClick = { },
        modifier = Modifier
            .width(60.dp)) {
        Image(painter = painterResource(id = R.drawable.mic), contentDescription ="micBtn" )
    }
}

@Composable
fun textFieldOutput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
    ) {
    //var segundoTextFieldValue by remember { mutableStateOf(traduccion) }
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .absoluteOffset(y = -190.dp)
            .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp))
            .height(200.dp),
        readOnly = true,
    )
}