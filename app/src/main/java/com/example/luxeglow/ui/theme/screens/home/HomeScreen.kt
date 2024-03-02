package com.example.luxeglow.ui.theme.screens.home
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.luxeglow.R
import com.example.luxeglow.navigation.ABOUT_URL
import com.example.luxeglow.navigation.ADD_PRODUCTS_URL
import com.example.luxeglow.navigation.LOGIN_URL
import com.example.luxeglow.navigation.SIGNUP_URL
import com.example.luxeglow.ui.theme.LuxeGlowTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var context = LocalContext.current
    val scrollState = rememberScrollState()
    var expanded by remember { mutableStateOf(false) }
    var isAddedToCart by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state = scrollState)
    ) {
        // App Bar with menu icon
        TopAppBar(
            title = { Text(text = "LuxeGlow") },
            navigationIcon = {
                IconButton(
                    onClick = { expanded = true },
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            actions = {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxWidth()
                ) {

                    DropdownMenuItem(text = { Text(text = "Login") }, onClick = {
                        navController.navigate(LOGIN_URL)
                        expanded = false
                    })

                    DropdownMenuItem(text = { Text(text = "About us") }, onClick = {
                        navController.navigate(ABOUT_URL)
                        expanded = false
                    })

                    DropdownMenuItem(text = { Text(text = "Sign up") }, onClick = {
                        navController.navigate(SIGNUP_URL)
                        expanded = false
                    })
                    // Add more menu items as needed
                }
            }

        )

        // Your existing rows and cards here

        // Repeat the following block as many times as needed for your content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(98.dp)
                    )
                    Text(text = "ksh/=2000", color = Color.White)
                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "011282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(25.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                        Button(onClick = {
                            val phoneNumber = "0712345678" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }

                    Button(onClick = {
                        if (!isAddedToCart) {
                            // Perform add to cart action
                            Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show()
                            isAddedToCart = true
                        } else {
                            // Perform remove from cart action if needed
                            isAddedToCart = false
                        }
                    }) {
                        if (isAddedToCart) {
                            // If item is in cart, show trolley icon
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Shopping Cart",
                                modifier = Modifier.size(24.dp)
                            )
                        } else {
                            // Otherwise, show "Add to Cart" text
                            Text(text = "Add to Cart")
                        }
                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.img_3),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1900", color = Color.White)
                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.img_4),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1000", color = Color.White)
                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.img_3),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1500", color = Color.White)

                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.img_2),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1100", color = Color.White)
                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=800", color = Color.White)


                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }



                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.img_5),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1300", color = Color.White)


                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.img_5),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "ksh/=1500", color = Color.White)
                    Row (modifier =Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val phoneNumber = "0111282300" // Replace with your actual phone number
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                            context.startActivity(dialIntent)
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }


                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(ADD_PRODUCTS_URL) }) {
                Text(text = "Add Products")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LuxeGlowTheme{
        HomeScreen(navController = rememberNavController())
    }
}

