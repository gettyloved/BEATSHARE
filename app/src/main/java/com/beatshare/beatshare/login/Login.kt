package com.beatshare.beatshare.login


//Login Page for both criteria of users.
// Login button has to check whether the user is an artist, producer or guest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme


@Composable
fun LogIn(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LogoPage()
        LogPage(navController = navController)
    }
}




@Composable
fun LogoPage() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.login),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(15.dp)
        )

        Divider(color = Color.White, thickness = 10.dp, modifier = Modifier.padding(10.dp))

    }
}


@Composable
fun LogPage(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var valueEntered by remember{ mutableStateOf("")}

        TextField(
            value = valueEntered,
            modifier = Modifier
                .scale(0.9f, 1.3f)
                .padding(30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    tint = Color.White,
                    contentDescription = null
                )},

            onValueChange = {valueEntered = it},
            label = {
                Text(
                    text = stringResource(R.string.userName),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        )

        TextField(
            value = valueEntered,
            modifier = Modifier
                .scale(0.9f, 1.3f)
                .padding(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    tint = Color.White,
                    contentDescription = null
                )},

            onValueChange = {valueEntered = it},
            label = {
                Text(
                    text = stringResource(R.string.password),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        )

        Button(
            onClick = {
                navController.navigate(route = Screen.Beats.route)

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.padding(30.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 60.dp)
            )
        }

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.padding(top = 10.dp, bottom = 30.dp)
        ) {
            Text(
                text = stringResource(R.string.login_guest),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 70.dp, bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(R.string.signUp),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            TextButton(
                onClick = {  }
            ) {
                Text(
                    text = stringResource(R.string.forgotPassword),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}














@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BeatshareTheme {
        LogIn(navController = rememberNavController())
    }
}