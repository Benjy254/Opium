package com.example.opium.ui.theme.screens.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.opium.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController){
    val coroutineScope= rememberCoroutineScope()

    LaunchedEffect(true) {
        coroutineScope.launch {
            delay(2000)
            navController.navigate("home")
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.slide_14),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Text(
            text = " Opium   Spurs   Hotel",
            color= Color.Cyan,
            style = MaterialTheme.typography.headlineLarge,
            fontSize =80.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController = rememberNavController())
}