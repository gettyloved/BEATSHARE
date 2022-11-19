package com.beatshare.beatshare.welcome


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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
fun Welcome(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.wavewhite),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Body(navController = navController)
        }
    }
}

@Composable
fun Body(navController: NavController) {
    val helveticaFont = FontFamily(Font(R.font.helvetica))
    Column(){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            Modifier
                .size(100.dp)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(TopCenter)) {
                Text(
                    text = stringResource(R.string.welcome_beatshare),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(15.dp),
                    fontFamily = helveticaFont
                )
                Text(
                    text = stringResource(R.string.unique_beats_commercial),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(15.dp),
                    lineHeight = 50.sp,
                    fontFamily = helveticaFont
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { navController.navigate(Screen.ArtistVProducer.route)},
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
                    fontWeight = FontWeight.Light,
                    fontFamily = helveticaFont
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .align(BottomCenter),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.anAccount),
                    fontSize = 20.sp,
                    fontFamily = helveticaFont
                )
                Text(
                    text = stringResource(R.string.login),
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.LogIn.route) }
                        .padding(horizontal = 5.dp),
                    fontSize = 20.sp,
                    fontFamily = helveticaFont
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun welcomePreview() {
    BeatshareTheme {
       Welcome(navController = rememberNavController())
    }
}
