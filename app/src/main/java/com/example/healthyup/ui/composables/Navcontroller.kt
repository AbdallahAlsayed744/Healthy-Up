package com.example.healthyup.ui.composables

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyup.constants

@Composable
fun Navcontroller() {
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = constants.sign_in) {

        composable(route = constants.sign_in){
           SignInScreen()
        }


    }
}