package com.beatshare.beatshare.login

//Signup Page for Artist (1)



import android.widget.Toast
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
import com.beatshare.beatshare.ArtistsSignUpViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme


@Composable
fun ArtistSignUp(
    navController: NavHostController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)) {
            ArtistData(navController = navController, artistsSignUpViewModel = artistsSignUpViewModel)
        }
    }
}

@Composable
fun ArtistData(
    navController:NavController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
) {
    var mFirstNameText by remember{ mutableStateOf("") }
    var mLastNameText by remember{ mutableStateOf("") }
    var mUserNameText by  remember{ mutableStateOf("") }
    var mEmailText by remember{ mutableStateOf("") }
    var mPassword by remember{ mutableStateOf("") }
    var mConfirmPassword by remember{ mutableStateOf("") }
    var isPasswordVisible by remember{ mutableStateOf(false) }
    var isConfirmPasswordVisible by remember{ mutableStateOf(false) }
    var isConfirmPasswordError by remember { mutableStateOf(false) }
    val isArtistSignUpDataValid by artistsSignUpViewModel.artistsSignUpDataValid.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(mConfirmPassword,mPassword){
        isConfirmPasswordError = mPassword.contentEquals(mConfirmPassword)
    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 50.dp)
    ) {

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
            isError = !isArtistSignUpDataValid.isFirstNameValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        HelperText(text="should be at least 8 characters")


        TextField(
            value = mLastNameText,
            onValueChange = {mLastNameText = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            isError = !isArtistSignUpDataValid.isLastNameValid,
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
        HelperText(text="should be at least 8 characters")

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
            isError = !isArtistSignUpDataValid.isUserNameValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        HelperText(text="Should be at least 8 characters")

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
            isError = !isArtistSignUpDataValid.isEmailValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        HelperText(text="should be a valid email address eg. JohnDoe@gmail.com")


        TextField(
            value = mPassword,
            onValueChange = {mPassword = it},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                textColor = Color.White
            ),
            isError = !isArtistSignUpDataValid.isPasswordValid,
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
                IconButton(onClick = { isPasswordVisible =!isPasswordVisible }) {
                    Icon(
                        imageVector = if(isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )
        HelperText(text="should be at least 8 characters, and should contain 1 special character, 2 lower case " +
                "and 2 upper case letters and number")

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
                IconButton(onClick = {
                    isConfirmPasswordVisible =!isConfirmPasswordVisible }) {
                    Icon(
                        imageVector = if (isConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            isError = isConfirmPasswordError
        )
        HelperText(text = "should match with your password")


        Button(
            onClick = {
                val artistSignupData = ArtistSignupData(mFirstNameText,mLastNameText,mUserNameText,mEmailText,mPassword)
                artistsSignUpViewModel.setArtistSignUpDetails(artistSignupData)
                if (artistsSignUpViewModel.validateUserCredentials()) navController.navigate(route = Screen.ArtistSignUpCont.route)
                else{
                    Toast.makeText(context,"Ensure your credentials are valid",Toast.LENGTH_LONG).show()
                }

            },
            enabled = mFirstNameText.isNotBlank() && mLastNameText.isNotBlank()
                    && mEmailText.isNotBlank() && mUserNameText.isNotBlank()
                    && mPassword.isNotBlank() && mConfirmPassword.isNotBlank() && mPassword.contentEquals
                (mConfirmPassword),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 30.dp,end = 30.dp, top = 10.dp, bottom = 10.dp)
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
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White)
//                //    .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp)
//            ) {
//
//            }
        }
        val checkedState = remember{ mutableStateOf(true)}
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier=Modifier.fillMaxWidth()
                .align(Alignment.Start)) {
            Checkbox(
                checked = false,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                )
            )
            Text(text = stringResource(R.string.agree_with),
                fontSize = 18.sp,color = Color.White)
            TextButton(onClick = { }) {
                Text(text = stringResource(R.string.terms_conditions),
                    fontSize = 18.sp,color = Color.White,
                    modifier = Modifier.fillMaxWidth())
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


@Composable
private fun ColumnScope.HelperText(modifier:Modifier=Modifier,text:String){
    Spacer(Modifier.height(5.dp))
    Text(modifier=modifier.align(Alignment.Start), text = text, color = Color.White)
}

@Preview(showBackground = true)
@Composable
fun ArtSignPreview() {
    BeatshareTheme {
        ArtistSignUp(navController = rememberNavController(), artistsSignUpViewModel = ArtistsSignUpViewModel())
    }
}
