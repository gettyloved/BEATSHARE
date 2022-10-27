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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .padding(30.dp)
        ) {
            Body()
        }
    }
}

@Composable
fun Body() {
    Column(){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            Modifier
                .size(150.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(TopCenter)) {
                Text(
                    text = stringResource(R.string.welcome_beatshare),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    text = stringResource(R.string.unique_beats_commercial),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(15.dp),
                    lineHeight = 50.sp,
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .align(BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = stringResource(R.string.getStarted),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .align(BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.anAccount),
                    fontSize = 25.sp
                )
                Text(
                    text = stringResource(R.string.login),
                    modifier = Modifier.clickable {  },
                    fontSize = 25.sp
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
