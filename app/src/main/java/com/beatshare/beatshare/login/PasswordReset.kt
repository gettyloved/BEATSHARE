package com.beatshare.beatshare.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun PasswordReset(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), 
            contentDescription = "logo",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_check_circle_outline_24),
                contentDescription = "success",
                modifier = Modifier.size(100.dp),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Password \nReset \nSuccessful",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "You have successfully reset your password. \nPlease login with your new password",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = { navController.navigate(Screen.LogIn.route) },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = stringResource(id = R.string.next),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPreview() {
    BeatshareTheme {
        PasswordReset(navController = rememberNavController())
    }
}