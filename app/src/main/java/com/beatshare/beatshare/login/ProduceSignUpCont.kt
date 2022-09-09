package com.beatshare.beatshare.login


//Signup Page for Producers (2)

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.beatshare.beatshare.Greeting
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun SignUpCont(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        address()
        socialAccounts()
        buttons(navController = navController)
    }
}

@Composable
fun address(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.signUp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = stringResource(R.string.artist_background),
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        var back by remember { mutableStateOf("")}

        TextField(
            value = back,
            onValueChange = {back = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp),
            label = {
                Text(
                    text = stringResource(R.string.country),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        TextField(
            value = back,
            onValueChange = {back = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp),
            label = {
                Text(
                    text = stringResource(R.string.city_town),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        TextField(
            value = back,
            onValueChange = {back = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp),
            label = {
                Text(
                    text = stringResource(R.string.zip),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}

@Composable
fun socialAccounts(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.socialAccounts),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
fun buttons(navController: NavController){
    Column(modifier = Modifier.padding(top = 50.dp)) {
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    modifier = Modifier.padding(5.dp),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.back),
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Button(
                onClick = { navController.navigate(Screen.ProducersHome.route)},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Text(
                    text = stringResource(R.string.finish),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                )
            }
            Row(modifier = Modifier.padding(top = 90.dp)) {
                Text(
                    text = stringResource(R.string.anAccount),
                    color = Color.White
                )
                TextButton(onClick = { navController.navigate(Screen.LogIn.route)}) {
                    Text(
                        text = stringResource(R.string.login),
                        color = Color.White
                    )
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SignPreview() {
    BeatshareTheme {
       SignUpCont(navController = rememberNavController())
    }
}












