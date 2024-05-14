package com.example.opium.ui.theme.screens.Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.opium.R
import com.example.opium.data.AuthViewModel
import onTextLayout

//import com.example.opium.TextFieldComponent


@Composable
fun RegisterScreen(navController: NavHostController) {
    var Firstname by remember { mutableStateOf(TextFieldValue("")) }
    var Lastname by remember { mutableStateOf(TextFieldValue("")) }
    var Gender by remember { mutableStateOf(TextFieldValue("")) }
    var Email by remember { mutableStateOf(TextFieldValue ("")) }
    var Password by remember { mutableStateOf(TextFieldValue("")) }
    var Confirmpassword by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.slide_15),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .border(width = 2.dp, color = Color.White)
    ) {
        val onTextLayout = onTextLayout
OutlinedTextField(value = Firstname, onValueChange = {Firstname=it}, label = { Text(
    modifier = Modifier
        .padding(4.dp)
        .background(color = Color.White)
    , text = "First Name",onTextLayout=onTextLayout)
},
    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = Lastname, onValueChange = {Lastname=it}, label = { Text(
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.White)
            , text = "Last Name",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = Gender, onValueChange = {Gender=it}, label = { Text(
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.White)
            , text = "Gender",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = Email, onValueChange = {Email=it}, label = { Text(
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.White)
            , text = "Email",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value =Password , onValueChange = {Password=it}, label = { Text(
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.White)
            , text = "Password",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = Confirmpassword, onValueChange = {Confirmpassword=it}, label = { Text(
            modifier = Modifier
                .padding(4.dp)
                .background(color = Color.White)
            , text = "Confirmpassword",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

//        val Tertirary = null
        Button(
            onClick = {
                val mysignuplogic = AuthViewModel(navController, context)
                mysignuplogic.SignUp(
                    Email.text.trim(),
                    Firstname.text.trim(),
                    Password.text.trim(),
                    Gender.text.trim()
                )
//            navController.navigate(ROUTE_DASHBOARD)
            },
            modifier = Modifier
                .fillMaxWidth()
//                .align(LineHeightStyle.Alignment.Center),

        ) {

            Text(text = "Submit", onTextLayout = onTextLayout)
        }
    }
}




@Preview
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}