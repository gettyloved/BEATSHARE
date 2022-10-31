
package com.beatshare.beatshare.login
//Login Page for both criteria of users.
// Login button has to check whether the user is an artist, producer or guest

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.beatshare.beatshare.ArtistsSignUpViewModel
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen


@Composable
fun LogIn(
    navController:NavHostController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            LogoPage()
            LogPage(
                navController = navController,
                artistsSignUpViewModel = artistsSignUpViewModel
            )
        }
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
    navController: NavController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var emailEntered by remember{ mutableStateOf("")}
        var passwordEntered by remember{ mutableStateOf("")}
        var isEmailValid by remember{ mutableStateOf(true) }
        var isPasswordValid by remember{ mutableStateOf(true) }
        var isPasswordVisible by remember{ mutableStateOf(false) }

        LaunchedEffect(passwordEntered,emailEntered){
            isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()
            isPasswordValid = passwordEntered.length>8 && passwordEntered.isNotEmpty() && passwordEntered.isNotBlank()
        }


        TextField(
            value = emailEntered,
            modifier = Modifier
                .scale(0.9f, 1.3f)
                .padding(30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
            isError = isEmailValid,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    tint = Color.White,
                    contentDescription = null
                )},

            onValueChange = {emailEntered = it},
            label = {
                Text(
                    text = stringResource(R.string.userName),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        )

        TextField(onValueChange = {value:String->
            passwordEntered=value
        },value=passwordEntered,
            modifier = Modifier
                .scale(0.9f, 1.3f)
                .padding(30.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible =!isPasswordVisible }) {
                    Icon(
                        imageVector = if(isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label={
                Text(
                    text = stringResource(R.string.password),
                    fontSize = 20.sp,
                    color = Color.White
                )
            },
            isError = isPasswordValid,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    tint = Color.White,
                    contentDescription = null
                )},


            )

        Button(
            onClick = {
                navController.navigate(route = Screen.BeatsProducer.route)

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
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.padding(top = 10.dp, bottom = 30.dp),
            onClick = { navController.navigate(route = Screen.GuestAccount.route) }
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
                    navController.navigate(route = Screen.ArtistVProducer.route)
                }
            ) {
                Text(
                    text = stringResource(R.string.signUp),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            TextButton(
                onClick = { navController.navigate(route = Screen.ForgotPassword.route) }
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
