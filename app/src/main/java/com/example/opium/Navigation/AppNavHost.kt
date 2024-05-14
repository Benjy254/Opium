package com.example.opium.Navigation

import HomeScreen
import LoginScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.opium.ui.theme.screens.Bookings.BookingScreen
import com.example.opium.ui.theme.screens.Contacts.RoomScreen
//import com.example.opium.ui.theme.screens.Home.HomeScreen
import com.example.opium.ui.theme.screens.Home.NavController
import com.example.opium.ui.theme.screens.Homing.HomingScreen
import com.example.opium.ui.theme.screens.Register.RegisterScreen
import com.example.opium.ui.theme.screens.splashscreen.SplashScreen

//import com.example.opium.ui.theme.screens.Login.LoginScreen



@Composable
fun AppNavHost(
    modifier: NavHostController, navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH_SCREEN
){
    NavHost(navController = navController,
        modifier = Modifier,
        startDestination = startDestination){

        composable(ROUTE_SPLASH_SCREEN) {
            SplashScreen(navController)
        }
        composable(ROUTE_HOME_SCREEN) {
            HomeScreen(navController)

        }
        composable(ROUTE_HOMING_SCREEN) {
            HomingScreen(navController)

        }
        composable(ROUTE_LOGIN_SCREEN) {
            LoginScreen(NavController())

        }

        composable(ROUTE_REGISTER_SCREEN) {
            RegisterScreen(navController)
        }
        composable(ROUTE_CONTACT_SCREEN) {
            RoomScreen(navController)
        }
        composable(ROUTE_BOOKING_SCREEN) {
            BookingScreen(navController)
        }

    }
}
