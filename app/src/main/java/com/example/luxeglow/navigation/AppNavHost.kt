package com.example.luxeglow.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.luxeglow.data.AuthViewModel
import com.example.luxeglow.ui.theme.Screens.Login.LoginScreen
import com.example.luxeglow.ui.theme.screens.about.AboutScreen
import com.example.luxeglow.ui.theme.screens.home.HomeScreen
import com.example.luxeglow.ui.theme.screens.products.AddProductScreen
import com.example.luxeglow.ui.theme.screens.signup.SignupScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController  = rememberNavController(),
    startDestination:String = HOME_URL
) {

    val context = LocalContext.current
    val authViewModel = AuthViewModel(navController = navController, context = context)


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HOME_URL) {
            HomeScreen(navController = navController)
        }
        composable(ABOUT_URL) {
            AboutScreen(navController = navController)
        }
        composable(SIGNUP_URL) {
            SignupScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL) {
            AddProductScreen(navController = navController)
        }
        composable(LOGIN_URL) {
            LoginScreen(navController = navController, authViewModel = authViewModel)

        }
    }


}





