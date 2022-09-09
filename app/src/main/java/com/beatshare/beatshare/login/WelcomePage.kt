package com.beatshare.beatshare.login


//It's supposed to be animated.
//Especially the intro after the landing page


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.beatshare.beatshare.Greeting
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Welcome(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            body()
        }
    }
}

@Composable
fun body() {
    Column(){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            Modifier
                .size(150.dp)
                .padding(10.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.welcome_beatshare),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp)
            )
            Text(
                text = stringResource(R.string.unique_beats_commercial),
                fontSize = 30.sp,
                modifier = Modifier.padding(15.dp),
                lineHeight = 50.sp,
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { },
                modifier = Modifier.padding(25.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = stringResource(R.string.getStarted),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(modifier = Modifier.padding(15.dp)) {
                Text(text = stringResource(R.string.anAccount))
                Text(
                    text = stringResource(R.string.login),
                    modifier = Modifier.clickable {  }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun welcomePreview() {
    BeatshareTheme {
       Welcome()
    }
}
