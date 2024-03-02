package com.example.luxeglow.ui.theme.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.luxeglow.ui.theme.LuxeGlowTheme
import com.example.luxeglow.ui.theme.screens.home.HomeScreen


@Composable
fun MainScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

    }
}











@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    LuxeGlowTheme {
        MainScreen(navController = rememberNavController())
    }
}