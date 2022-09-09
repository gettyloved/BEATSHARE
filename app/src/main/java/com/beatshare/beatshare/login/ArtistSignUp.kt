package com.beatshare.beatshare.login

//Signup Page for Artist (1)


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.TheViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme


@Composable
fun ArtistSignUp(
    navController: NavHostController,
    theViewModel: TheViewModel
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)) {
            ArtistData(navController = navController, theViewModel = theViewModel)
        }
    }
}

@Composable
fun ArtistData(
    navController:NavController,
    theViewModel: TheViewModel
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {

        val mContext = LocalContext.current

        Text(
            text = stringResource(R.string.signUp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = stringResource(R.string.getstarted),
            fontSize = 20.sp,
            color = Color.White
        )


        TextField(
            value = theViewModel.mFirstNameText,
            onValueChange = {theViewModel.onmFirstNameTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.first_name),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            value = theViewModel.mLastNameText,
            onValueChange = {theViewModel.onmLastNameTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.last_name),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            value = theViewModel.mUserNameText,
            onValueChange = {theViewModel.onmUserNameTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.userName),
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            value = theViewModel.mEmailText,
            onValueChange = {theViewModel.onmEmailTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.email_address),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = theViewModel.mPassword,
            onValueChange = {theViewModel.onmPasswordChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            singleLine = true,
            label = {
                Text(
                    text = stringResource(R.string.password),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (theViewModel.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { theViewModel.isPasswordVisible == !theViewModel.isPasswordVisible }) {
                    Icon(
                        imageVector = if(theViewModel.isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )

        TextField(
            value = theViewModel.mConfirmPassword,
            onValueChange = {theViewModel.onmConfirmPasswordChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.confirm_password),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(theViewModel.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { theViewModel.isConfirmPasswordVisible == !theViewModel.isConfirmPasswordVisible }) {
                    Icon(
                        imageVector = if (theViewModel.isConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )

        Button(
            onClick = {
                    navController.navigate(Screen.ArtistSignUpCont.route)
            },
            enabled = theViewModel.mFirstNameText.isNotBlank() && theViewModel.mLastNameText.isNotBlank()
                    && theViewModel.mEmailText.isNotBlank() && theViewModel.mUserNameText.isNotBlank()
                    && theViewModel.mPassword.isNotBlank() && theViewModel.mConfirmPassword.isNotBlank(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.padding(start = 30.dp,end = 30.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.next),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_24),
                    contentDescription = "",
                    modifier = Modifier
                        .background(Color.Black)
                        .clip(CircleShape)
                )
            }
        }
        val checkedState = remember{ mutableStateOf(true)}
        Row(horizontalArrangement = Arrangement.Center) {
            Checkbox(
                checked = false,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                )
            )
            Row(){
                Text(text = stringResource(R.string.agree_with), fontSize = 20.sp,color = Color.White)
                TextButton(onClick = { }) {
                    Text(text = stringResource(R.string.terms_conditions), fontSize = 20.sp,color = Color.White)
                }
            }
        }
        Row(horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {  }) {
                Text(text = stringResource(R.string.anAccount), fontSize = 20.sp,color = Color.White)
            }
            TextButton(onClick = {  }) {
                Text(text = stringResource(R.string.login), fontSize = 20.sp,color = Color.White)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ArtSignPreview() {
    BeatshareTheme {
        ArtistSignUp(navController = rememberNavController(), theViewModel = TheViewModel())
    }
}


