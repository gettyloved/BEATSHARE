package com.beatshare.beatshare.login


//Continuation Signup Page for Artists (2)


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import com.beatshare.beatshare.ArtistSignupContData
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ArtistsSignUpViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun ArtistSignUpCont(
    navController: NavController,
    artistsSignUpViewModel: ArtistsSignUpViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(start = 20.dp )
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        var mCountry by remember { mutableStateOf("")}
        var mCity by remember { mutableStateOf("")}
        var mZip by remember { mutableStateOf("")}

            Text(
                text = stringResource(R.string.signUp),
                fontWeight = FontWeight.ExtraBold,
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
                value = mCountry,
                onValueChange = {mCountry = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .height(70.dp),
                label = {
                    Text(
                        text = stringResource(R.string.country),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )

            Spacer(modifier = Modifier.padding(30.dp))

            TextField(
                value = mCity,
                onValueChange = {mCity = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .height(70.dp),
                label = {
                    Text(
                        text = stringResource(R.string.city_town),
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            )

            Spacer(modifier = Modifier.padding(30.dp))

            TextField(
                value = mZip,
                onValueChange = {mZip = it},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.White
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .height(70.dp),
                label = {
                    Text(
                        text = stringResource(R.string.zip),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = stringResource(R.string.socialAccounts),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 15.dp).fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook_removebg_preview),
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.ig_removebg_preview),
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.twitter_removebg_preview),
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 5.dp, end = 5.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.google_removebg_preview),
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 5.dp),
                contentDescription = null
            )

        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(
            onClick = {
                val artistCont = ArtistSignupContData(mCountry,mCity,mZip)
                artistsSignUpViewModel.setArtistContSignupDetails(artistCont)
                navController.navigate(Screen.ArtistHome.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.finish),
                color = Color.Black,
                modifier = Modifier.padding(start = 40.dp, end = 40.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
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
fun ArtistPreview() {
    BeatshareTheme {
        ArtistSignUpCont(navController = rememberNavController(), artistsSignUpViewModel = ArtistsSignUpViewModel())
    }
}












