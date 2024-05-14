package com.example.opium.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.example.opium.Navigation.ROUTE_BOOKING_SCREEN
import com.example.opium.Navigation.ROUTE_LOGIN_SCREEN
import com.example.opium.Navigation.ROUTE_REGISTER_SCREEN
import com.example.opium.ui.theme.screens.Home.NavController
import com.google.firebase.auth.FirebaseAuth


class AuthViewModel(var navController: NavController, var context: Context) {
    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val progress: ProgressDialog = ProgressDialog(context)

    init {
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }


    fun SignUp(email: String, fullName: String, password: String, gender: String) {
//         Validate input fields
        if (fullName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && gender.isNotBlank()) {
            // Call Firebase to create a user with email and password
            progress.show()
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context,"Successfully Registered!",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_BOOKING_SCREEN)}
//
                // Sign up success, navigate to next screen or do something else
                else {
                    // Sign up failed, display an error message
                    Toast.makeText(context, "Sign up failed. ${it.exception!!.message}", Toast.LENGTH_LONG).show()
                    navController.navigate(
                        ROUTE_REGISTER_SCREEN)
                }
            }


        }

        else{
            Toast.makeText(context, "Please fill in all the fields!", Toast.LENGTH_LONG).show()
        }

    }



    fun Login(email: String, password: String, ) {
        progress.show()
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_BOOKING_SCREEN)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN_SCREEN)
            }
        }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN_SCREEN)
    }

    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }
//
//    fun ResetPass(email: String){
//        mAuth.sendPasswordResetEmail(email).addOnCompleteListener {
//            if (it.isSuccessful) {
//                // Password reset email sent successfully
//                Toast.makeText(context,"Password reset email sent successfully",Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_LOGIN_SCREEN)
//            } else {
//                // Password reset email could not be sent
//                Toast.makeText(context,"Password reset email could not be sent",Toast.LENGTH_LONG).show()
//            }
        }
//
