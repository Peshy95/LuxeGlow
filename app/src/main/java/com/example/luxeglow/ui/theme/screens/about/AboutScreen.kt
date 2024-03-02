package com.example.luxeglow.ui.theme.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.luxeglow.R
import com.example.luxeglow.navigation.HOME_URL
import com.example.luxeglow.ui.theme.LuxeGlowTheme

@Composable
fun AboutScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            modifier = Modifier
                .height(200.dp)
                .padding(bottom = 20.dp),
            painter = painterResource(id = R.drawable.img_9),
            contentDescription = "my pic"
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "About us",
            fontSize = 60.sp,
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Cursive,

        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "          LuxeGlow is an Online Cosmetic Shopping App that provides you with a variety of makeup cosmetics ",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We provide affordable original products  and supply them from all over the world",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default
        )
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.cartoon)
        )
        var isPlaying by remember {
            mutableStateOf(true)
        }
        val progress by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = isPlaying
        )
        LaunchedEffect(key1 = progress) {
            if (progress == 0f) {
                isPlaying = true
            }
            if (progress == 1f) {
                isPlaying = false
            }
        }

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp)
                .clickable() {
                    isPlaying = true
                },
            //iterations = LottieConstants.IterateForever
            progress = {
                progress
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { 
            navController.navigate(HOME_URL)
        },

            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.size(width = 100.dp, height = 60.dp)) {
            Text(text = "Back")
        }
        Spacer(modifier = Modifier.height(20.dp))

        BottomAppBar(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            IconButton(onClick = {
                navController.navigate(HOME_URL)
            }) {

            }

        }

    }

}
@Composable
@Preview(showBackground = true )
fun AboutScreenPreview(){
    LuxeGlowTheme {
        AboutScreen( navController = rememberNavController())
    }
}




