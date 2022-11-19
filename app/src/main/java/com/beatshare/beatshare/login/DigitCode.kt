package com.beatshare.beatshare.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun DigitCode(){
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
                .padding(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Enter the 4-digit code",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = helveticaFont
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Text(
                text = "The recovery code has been sent to your mobile number. \nPlease enter the code.",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = helveticaFont
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Transparent)
            ) {
                var digitOne by remember{ mutableStateOf("")}
                var digitTwo by remember{ mutableStateOf("")}
                var digitThree by remember{ mutableStateOf("")}
                var digitFour by remember{ mutableStateOf("")}
                OutlinedTextField(
                    value = digitOne,
                    onValueChange = {digitOne = it},
                    modifier = Modifier
                        .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                        .width(50.dp)
                        .height(50.dp)
                )
                OutlinedTextField(
                    value = digitTwo,
                    onValueChange = {digitTwo = it},
                    modifier = Modifier
                        .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                        .width(50.dp)
                        .height(50.dp)
                )
                OutlinedTextField(
                    value = digitThree,
                    onValueChange = {digitThree = it},
                    modifier = Modifier
                        .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                        .width(50.dp)
                        .height(50.dp)
                )
                OutlinedTextField(
                    value = digitFour,
                    onValueChange = {digitFour = it},
                    modifier = Modifier
                        .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                        .width(50.dp)
                        .height(50.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DigitPreview() {
    BeatshareTheme {
        DigitCode()
    }
}