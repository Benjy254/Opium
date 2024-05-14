
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.opium.R
import com.example.opium.data.AuthViewModel
import com.example.opium.ui.theme.screens.Home.NavController
import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun LoginScreen(navController: NavController) {
    var Fullname by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.slide_16),
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
        OutlinedTextField(value = Fullname, onValueChange = {Fullname=it}, label = { Text(
            modifier = Modifier
                .padding(6.dp)
                .background(color = Color.White)
            , text = "Full Name",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email, onValueChange = {email=it}, label = { Text(
            modifier = Modifier
                .padding(6.dp)
                .background(color = Color.White)
            , text = "email",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = pass, onValueChange = {pass=it}, label = { Text(
            modifier = Modifier
                .padding(6.dp)
                .background(color = Color.White)
            , text = "Password",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = confirmpass, onValueChange = {confirmpass=it}, label = { Text(
            modifier = Modifier
                .padding(6.dp)
                .background(color = Color.White)
            , text = "ConfirmPassword",onTextLayout=onTextLayout)
        },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next), modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = {
                val myloginlogic = AuthViewModel(
                    navController,
                    context)
                myloginlogic.Login(
                    Email.text.trim(),
                    Password.trim())

            },
            modifier = Modifier
                .fillMaxWidth()
               // .align(LineHeightStyle.Alignment.CenterHorizontally),
           // colors = ButtonDefaults.buttonColors(Tertirary)
        ) {
            Text(text = "Login", onTextLayout = onTextLayout)
        }
    }
}




@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(navController = NavController())
}

