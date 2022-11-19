package com.beatshare.beatshare.login


//Signup Page for Producers (1)


import android.widget.Toast
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
fun ProducerSignUp(
    navController: NavHostController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.boxblack),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()) {
            ArtistData(navController = navController, artistsSignUpViewModel = artistsSignUpViewModel)
        }
    }
}

@Composable
fun ProducerData(
    navController:NavController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
) {
    var pFirstNameText by remember{ mutableStateOf("") }
    var pLastNameText by remember{ mutableStateOf("") }
    var pUserNameText by  remember{ mutableStateOf("") }
    var pEmailText by remember{ mutableStateOf("") }
    var pPassword by remember{ mutableStateOf("") }
    var pConfirmPassword by remember{ mutableStateOf("") }
    var isPasswordVisible by remember{ mutableStateOf(false) }
    var isConfirmPasswordVisible by remember{ mutableStateOf(false) }
    var isConfirmPasswordError by remember { mutableStateOf(false) }
    val isArtistSignUpDataValid by artistsSignUpViewModel.artistsSignUpDataValid.collectAsState()
    val context = LocalContext.current
    val helveticaFont = FontFamily(Font(R.font.helvetica))

    LaunchedEffect(pConfirmPassword,pPassword){
        isConfirmPasswordError = pPassword.contentEquals(pConfirmPassword)
    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {

        Text(
            text = stringResource(R.string.signUp),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            fontFamily = helveticaFont
        )

        Text(
            text = stringResource(R.string.getstarted),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = helveticaFont
        )


        TextField(
            value = pFirstNameText,
            onValueChange = {pFirstNameText = it},
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
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
                )
            },
            isError = !isArtistSignUpDataValid.isFirstNameValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        HelperText(text="should be at least 8 characters")


        TextField(
            value = pLastNameText,
            onValueChange = {pLastNameText = it},
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
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
                )},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        HelperText(text="should be at least 8 characters")

        TextField(
            value = pUserNameText,
            onValueChange = {pUserNameText = it},
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
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
                )},
            isError = !isArtistSignUpDataValid.isUserNameValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        HelperText(text="Should be at least 8 characters")

        TextField(
            value = pEmailText,
            onValueChange = {pEmailText = it},
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
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
                )},
            isError = !isArtistSignUpDataValid.isEmailValid,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        HelperText(text="should be a valid email address eg. JohnDoe@gmail.com")


        TextField(
            value = pPassword,
            onValueChange = {pPassword = it},
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
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
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
        HelperText(text="Should be at least 8 characters, and should contain 2 special character, 2 lower case " +
                "and 2 upper case letters and 2 numbers")

        TextField(
            value = pConfirmPassword,
            onValueChange = {pConfirmPassword = it},
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
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = helveticaFont
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
            }
        )
        HelperText(text = "should match with your password")


        Button(
            onClick = {
                val artistSignupData = ArtistSignupData(pFirstNameText,pLastNameText,pUserNameText,pEmailText,pPassword)
                artistsSignUpViewModel.setArtistSignUpDetails(artistSignupData)
                if (artistsSignUpViewModel.validateUserCredentials()) navController.navigate(route = Screen.ProducerSignUpCont.route)
                else{
                    Toast.makeText(context,"Ensure your credentials are valid", Toast.LENGTH_LONG).show()
                }

            },
            enabled = pFirstNameText.isNotBlank() && pLastNameText.isNotBlank()
                    && pEmailText.isNotBlank() && pUserNameText.isNotBlank()
                    && pPassword.isNotBlank() && pConfirmPassword.isNotBlank() && pPassword.contentEquals
                (pConfirmPassword),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = stringResource(R.string.next),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = helveticaFont
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
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.anAccount),
                fontSize = 15.sp,
                color = Color.White
            )

            TextButton(
                onClick = { navController.navigate(Screen.LogIn.route) }
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 15.sp,
                    color = Color.White,
                    fontFamily = helveticaFont
                )
            }
        }
    }
}


@Composable
private fun ColumnScope.HelperText(modifier:Modifier=Modifier,text:String){
    Spacer(Modifier.height(5.dp))
    Text(
        modifier=modifier.align(Alignment.Start),
        text = text,
        color = Color.White,
        fontSize = 10.sp
    )
}


@Preview(showBackground = true)
@Composable
fun SPreview() {
    BeatshareTheme {
        ProducerSignUp(navController = rememberNavController(), artistsSignUpViewModel = ArtistsSignUpViewModel())
    }
}

