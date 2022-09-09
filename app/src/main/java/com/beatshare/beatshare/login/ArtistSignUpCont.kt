package com.beatshare.beatshare.login


//Signup Page for Artists (2)


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.beatshare.beatshare.TheViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun ArtistSignUpCont(
    navController: NavController,
    theViewModel: TheViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        artistAddress(theViewModel = theViewModel)
        artistSocialAccounts()
        artistButtons(navController = navController)
    }
}

@Composable
fun artistAddress(theViewModel: TheViewModel){
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


        TextField(
            value = theViewModel.mCountry,
            onValueChange = {theViewModel.onmCountryTextChanged(it)},
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
            value = theViewModel.mCity,
            onValueChange = {theViewModel.onmCityTextChanged(it)},
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
            value = theViewModel.mZip,
            onValueChange = {theViewModel.onmZipTextChanged(it)},
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
fun artistSocialAccounts(){
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
fun artistButtons(navController: NavController){
    Column(modifier = Modifier.padding(top = 50.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Button(
                onClick = { navController.navigate(Screen.ArtistHome.route)},
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
fun ArtistPreview() {
    BeatshareTheme {
        ArtistSignUpCont(navController = rememberNavController(), theViewModel = TheViewModel())
    }
}












