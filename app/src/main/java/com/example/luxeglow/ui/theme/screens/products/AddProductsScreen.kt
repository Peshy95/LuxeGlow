package com.example.luxeglow.ui.theme.screens.products

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.luxeglow.data.ProductViewModel
import com.example.luxeglow.ui.theme.LuxeGlowTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text( modifier = Modifier,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            text = "AddProducts")

        var productName by remember { mutableStateOf("") }
        var productQuantity by remember { mutableStateOf("") }
        var productPrice by remember { mutableStateOf("") }
        var context= LocalContext.current
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Product name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text(text = "Product quantity *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Product price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        var modifier = Modifier

        ImagePicker(modifier,context, navController, productName.trim(), productQuantity.trim(), productPrice.trim())
    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, quantity:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // Replace this with your actual logic to handle the product data and image upload
                    var productRepository = ProductViewModel(navController,context)
                    productRepository.uploadProduct(name, quantity, price,imageUri!!)
                }
            ) {
                Text(text = "Upload")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview(){
    LuxeGlowTheme {
        AddProductScreen( rememberNavController())
    }
}