package com.beatshare.beatshare.login

//Signup Page for Artist (1)



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
import com.beatshare.beatshare.ArtistSignupData
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
    var mFirstNameText by remember{ mutableStateOf("") }
    var mLastNameText by remember{ mutableStateOf("") }
    var mUserNameText by  remember{ mutableStateOf("") }
    var mEmailText by remember{ mutableStateOf("") }
    var mPassword by remember{ mutableStateOf("") }
    var mConfirmPassword by remember{ mutableStateOf("") }
    var isPasswordVisible by remember{ mutableStateOf(false) }
    var isConfirmPasswordVisible by remember{ mutableStateOf(false) }
    var isError by remember{ mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 50.dp)
    ) {

        val mContext = LocalContext.current

        Text(
            text = stringResource(R.string.signUp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )

        Text(
            text = stringResource(R.string.getstarted),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )


        TextField(
            value = mFirstNameText,
            onValueChange = {mFirstNameText = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
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
            value = mLastNameText,
            onValueChange = {mLastNameText = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
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
            value = mUserNameText,
            onValueChange = {mUserNameText = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
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
            value = mEmailText,
            onValueChange = {mEmailText = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
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
            value = mPassword,
            onValueChange = {mPassword = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            singleLine = true,
            label = {
                Text(
                    text = stringResource(R.string.password),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible == !isPasswordVisible }) {
                    Icon(
                        imageVector = if(isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )

        TextField(
            value = mConfirmPassword,
            onValueChange = {mConfirmPassword = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            maxLines = 1,
            label = {
                Text(
                    text = stringResource(R.string.confirm_password),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isConfirmPasswordVisible == !isConfirmPasswordVisible }) {
                    Icon(
                        imageVector = if (isConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            isError = isError
        )
        if(mPassword != mConfirmPassword){
            isError = true
            Text(text = "Required", color = Color.White)
        }

        Button(
            onClick = {
                val artistSignupData = ArtistSignupData(mFirstNameText,mLastNameText,mUserNameText,mEmailText)
                theViewModel.setArtistSignUpDetails(artistSignupData)
                navController.navigate(route = Screen.ArtistSignUpCont.route)
                
            },
            enabled = mFirstNameText.isNotBlank() && mLastNameText.isNotBlank()
                    && mEmailText.isNotBlank() && mUserNameText.isNotBlank()
                    && mPassword.isNotBlank() && mConfirmPassword.isNotBlank(),
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
                        .padding(start = 10.dp)
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
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text = stringResource(R.string.agree_with), fontSize = 20.sp,color = Color.White)
                TextButton(onClick = { }) {
                    Text(text = stringResource(R.string.terms_conditions), fontSize = 20.sp,color = Color.White)
                }
            }
        }
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(R.string.anAccount), fontSize = 20.sp,color = Color.White)
            TextButton(onClick = { navController.navigate(Screen.LogIn.route) }) {
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


