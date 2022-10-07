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
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun SignUpCont(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(start = 50.dp, end = 30.dp)
    ) {
        Address()
        Spacer(modifier = Modifier.padding(100.dp))
        SocialAccounts()
        Spacer(modifier = Modifier.padding(50.dp))
        Buttons(navController = navController)
    }
}

@Composable
fun Address(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.signUp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 50.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.whats_your_producer_details),
            fontSize = 20.sp,
            color = Color.White
        )
        var pAliasName by remember { mutableStateOf("")}
        var pType by remember { mutableStateOf("")}

        TextField(
            value = pAliasName,
            onValueChange = {pAliasName = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            modifier = Modifier
                .height(70.dp),
            label = {
                Text(
                    text = stringResource(R.string.aliasName),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = pType,
            onValueChange = {pType = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            modifier = Modifier
                .height(70.dp),
            label = {
                Text(
                    text = stringResource(R.string.type_of_music_producer),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}

@Composable
fun SocialAccounts(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook_removebg_preview),
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ig_removebg_preview),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.twitter_removebg_preview),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.google_removebg_preview),
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 5.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
fun Buttons(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate(Screen.ProducersHome.route)},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.finish),
                color = Color.Black,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
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



@Preview(showBackground = true)
@Composable
fun SignPreview() {
    BeatshareTheme {
       SignUpCont(navController = rememberNavController())
    }
}












