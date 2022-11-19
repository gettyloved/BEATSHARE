package com.beatshare.beatshare.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
fun ForgotPassword(navController: NavController){
    val helveticaFont = FontFamily(Font(R.font.helvetica))
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Forgot Password",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = helveticaFont
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = stringResource(R.string.forgotPasswordText),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraLight,
                fontFamily = helveticaFont
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Box(
                modifier = Modifier
                    .alpha(0.6f)
                    .background(Color.Gray, shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable { navController.navigate(Screen.DigitCode.route) },
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment=Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_smartphone_24),
                        contentDescription = "null",
                        modifier = Modifier.size(50.dp),
                        tint = Color.White
                    )
                    Column() {
                        Text(
                            text = "via SMS",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = helveticaFont
                        )
                        Text(
                            text = "**** **** *017",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = helveticaFont
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Box(
                modifier = Modifier
                    .alpha(0.6f)
                    .background(Color.Gray, shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable { navController.navigate(Screen.DigitCode.route) },
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment=Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_email_24),
                        contentDescription = "null",
                        modifier = Modifier.size(50.dp),
                        tint = Color.White
                    )
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "via Email",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = helveticaFont
                        )
                        Text(
                            text = "****e@gmail.com",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = helveticaFont
                        )
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ForgotPreview() {
    BeatshareTheme {
        ForgotPassword( navController = rememberNavController())
    }
}