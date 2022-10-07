package com.beatshare.beatshare.login


//Signup Page for Producers (1)


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
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.TheViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme
import com.beatshare.beatshare.ui.theme.White


@Composable
fun ProducerSignUp(
    navController: NavController,
    theViewModel: TheViewModel
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        var pFirstNameText by remember {mutableStateOf("")}
        var pLastNameText by remember {mutableStateOf("")}
        var pUserNameText by  remember {mutableStateOf("")}
        var pEmailText by remember {mutableStateOf("")}
        var pPassword by remember {mutableStateOf("")}
        var pConfirmPassword by remember {mutableStateOf("")}
        var ispPasswordVisible by remember {mutableStateOf(false)}
        var ispConfirmPasswordVisible by remember {mutableStateOf(false)}

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 80.dp)
        ) {
            Text(
                text = stringResource(R.string.signUp),
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Text(
                text = stringResource(R.string.getstarted),
                fontSize = 20.sp,
                color = Color.White
            )

            val mContext = LocalContext.current

            TextField(
                value = pFirstNameText,
                onValueChange = {pFirstNameText = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.first_name),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            )
            TextField(
                value = pLastNameText,
                onValueChange = {pLastNameText = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.last_name),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )}
            )
            TextField(
                value = pUserNameText,
                onValueChange = {pUserNameText = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.userName),
                        modifier = Modifier.padding(5.dp),
                        color = Color.White
                    )}
            )
            TextField(
                value = pEmailText,
                onValueChange = {pEmailText = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.email_address),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )}
            )
            TextField(
                value = pPassword,
                onValueChange = {pPassword = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.password),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (ispPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { ispPasswordVisible == !ispPasswordVisible }) {
                        Icon(
                            imageVector = if(ispPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }
            )
            TextField(
                value = pConfirmPassword,
                onValueChange = {pConfirmPassword = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                label = {
                    Text(
                        text = stringResource(R.string.confirm_password),
                        color = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if(ispConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { ispConfirmPasswordVisible == !ispConfirmPasswordVisible }) {
                        Icon(
                            imageVector = if (ispConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }
            )
            Button(
                onClick = {
                    navController.navigate(route = Screen.ProducerSignUpCont.route)
                },
                enabled = pFirstNameText.isNotBlank() && pLastNameText.isNotBlank()
                        && pEmailText.isNotBlank() && pUserNameText.isNotBlank()
                        && pPassword.isNotBlank() && pConfirmPassword.isNotBlank(),
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
                        contentDescription = null
                    )
                }
            }
            val checkedState = remember{ mutableStateOf(true)}
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.White,
                        checkmarkColor = Color.White
                    )
                )
                Text(
                    text = stringResource(R.string.agree_with),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(
                    text = stringResource(R.string.terms_conditions),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(text = stringResource(R.string.anAccount), fontSize = 20.sp,color = Color.White)
                TextButton(onClick = { navController.navigate(Screen.LogIn.route) }) {
                    Text(text = stringResource(R.string.login), fontSize = 20.sp,color = Color.White)
                }

            } 
        }
    }
}






@Preview(showBackground = true)
@Composable
fun SPreview() {
    BeatshareTheme {
        ProducerSignUp(navController = rememberNavController(), theViewModel = TheViewModel())
    }
}

