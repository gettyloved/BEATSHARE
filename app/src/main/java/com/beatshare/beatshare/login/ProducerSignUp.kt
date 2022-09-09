package com.beatshare.beatshare.login


//Signup Page for Producers (1)

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
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.Greeting
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.TheViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme


@Composable
fun ProducerSignUp(
    navController: NavController,
    theViewModel: TheViewModel
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)) {
            ProducerData(
                navController = navController,
                theViewModel = theViewModel
            )
        }
    }
}

@Composable
fun ProducerData(
    navController: NavController,
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
        Text(text = stringResource(R.string.signUp), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = stringResource(R.string.getstarted), fontSize = 20.sp, color = Color.White)

        val mContext = LocalContext.current

        TextField(
            value = theViewModel.pFirstNameText,
            onValueChange = {theViewModel.onpFirstNameTextChanged(it)},
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
            }
        )
        TextField(
            value = theViewModel.pLastNameText,
            onValueChange = {theViewModel.onpLastNameTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.last_name),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )}
        )
        TextField(
            value = theViewModel.pUserNameText,
            onValueChange = {theViewModel.onpUserNameTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.userName),
                    modifier = Modifier.padding(5.dp),
                    color = Color.White
                )}
        )
        TextField(
            value = theViewModel.pEmailText,
            onValueChange = {theViewModel.onpEmailTextChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.email_address),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )}
        )
        TextField(
            value = theViewModel.pPassword,
            onValueChange = {theViewModel.onpPasswordChanged(it)},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            label = {
                Text(
                    text = stringResource(R.string.password),
                    color = Color.White,
                    modifier = Modifier.padding(5.dp)
                )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (theViewModel.ispPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { theViewModel.ispPasswordVisible == !theViewModel.ispPasswordVisible }) {
                    Icon(
                        imageVector = if(theViewModel.ispPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )
        TextField(
            value = theViewModel.pConfirmPassword,
            onValueChange = {theViewModel.onpConfirmPasswordChanged(it)},
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
            visualTransformation = if(theViewModel.ispConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { theViewModel.ispConfirmPasswordVisible == !theViewModel.ispConfirmPasswordVisible }) {
                    Icon(
                        imageVector = if (theViewModel.ispConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            }
        )
        Button(
            onClick = {
                 navController.navigate(Screen.ProducerSignUpCont.route)
            },
            enabled = theViewModel.pFirstNameText.isNotBlank() && theViewModel.pLastNameText.isNotBlank()
                    && theViewModel.pEmailText.isNotBlank() && theViewModel.pUserNameText.isNotBlank()
                    && theViewModel.pPassword.isNotBlank() && theViewModel.pConfirmPassword.isNotBlank(),
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
            Text(text = stringResource(R.string.agree_with), fontSize = 20.sp,color = Color.White)
            Text(text = stringResource(R.string.terms_conditions), fontSize = 20.sp,color = Color.White)
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(R.string.anAccount), fontSize = 20.sp,color = Color.White)
            Text(text = stringResource(R.string.login), fontSize = 20.sp,color = Color.White)
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

