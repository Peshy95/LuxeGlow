package com.example.luxeglow.ui.theme.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.luxeglow.R
import com.example.luxeglow.navigation.LOGIN_URL
import com.example.luxeglow.navigation.VIEW_PRODUCTS_URL
import com.example.luxeglow.ui.theme.LuxeGlowTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .paint(painterResource(id = R.drawable.signup), contentScale = ContentScale.FillBounds),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = " Welcome to LuxeGlow",
            color = Color.Blue,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,

        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text ="Create your account by filling the form below",
            color = Color.DarkGray


            )








        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {name= it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),

            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "")},
            label = { Text(text = "Name") }

        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            label = { Text(text = "Email Address") }

        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password= it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),

            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            label = { Text(text = "Password") }

        )
        Spacer(modifier = Modifier.height(30.dp))

        val context = LocalContext.current
        Button(onClick = {
            navController.navigate(VIEW_PRODUCTS_URL)
        },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.size(width = 150.dp, height = 40.dp)
        ) {
            Text(text = "Sign up")
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(LOGIN_URL)
        },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.size(width = 150.dp, height = 40.dp)
            ) {
            Text(text = "Login instead")
        }








    }

}


@Composable
@Preview(showBackground = true )
fun SignupScreenPreview(){
    LuxeGlowTheme {
        SignupScreen(navController = rememberNavController())
    }
}

