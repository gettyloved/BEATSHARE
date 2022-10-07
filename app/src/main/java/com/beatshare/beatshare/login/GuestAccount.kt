package com.beatshare.beatshare.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun GuestAccount(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(50.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(90.dp)
        )

        Column(modifier = Modifier
            .align(Alignment.BottomStart)
            .background(Color.Transparent)) {
            Text(
                text = "Sign In to \nContinue",
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.navigate(Screen.ArtistVProducer.route) },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 35.sp
                    )
                }
                Button(
                    onClick = { navController.navigate(Screen.LogIn.route) },
                    modifier = Modifier.border(1.dp, Color.White),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(
                        text = "Login",
                        fontSize = 35.sp,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = {  }
                ) {
                    Text(
                        text = "Continue without Login",
                        color = Color.White,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GuestPreview() {
    BeatshareTheme {
        GuestAccount(navController = rememberNavController())
    }
}