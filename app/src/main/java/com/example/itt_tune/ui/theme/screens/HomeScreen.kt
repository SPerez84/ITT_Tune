import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itt_tune.R

@Composable
fun PantallaInicial() {
    val marcoMedio = dimensionResource(id = R.dimen.padding_medium)
    val espacioBtn = dimensionResource(id = R.dimen.espacio_Chico)
    var primerTextFieldValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(marcoMedio)
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
                Spacer(modifier = Modifier.size(espacioBtn))
                botonSeleccion()
                Spacer(modifier = Modifier.size(espacioBtn))
                listaIdiomas()
            }
        }
    }
}
@Composable
fun Titulo(){
    val espacioBtn = dimensionResource(id = R.dimen.espacio_Chico)
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 10 .dp)
    ){
        Row(
            modifier = Modifier.background(Color.White),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "ITT TextTune",
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.size(espacioBtn))
            Image(painter = painterResource(id = R.drawable.logo_textune),
                contentDescription ="logoTextune" ,
                modifier = Modifier.size(35.dp))
        }
    }
}
@Composable
fun textFieldInput(
    primerTextFieldValue: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField (
        label = { Text(text =  stringResource(id = R.string.textFieldPlaceHolder)) },
        value = primerTextFieldValue,
        shape = MaterialTheme.shapes.large,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            //.clip(MaterialTheme.shapes.medium)
            .height(200.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
    )
}

@Composable
fun botonSeleccion(modifier: Modifier = Modifier
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
fun botonCamara(
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
) {
    OutlinedTextField(
        value = value,
        shape = MaterialTheme.shapes.large,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .absoluteOffset(y = -185.dp)
            //.border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp))
            .height(200.dp),
        readOnly = true,
    )
}