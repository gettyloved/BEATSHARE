package com.beatshare.beatshare.login


//First time Starter page for Artists and Producers signing up


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.Greeting
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun ArtistVProducer(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.beforeWeStart),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = stringResource(R.string.youWantToRegisterAs),
                fontSize = 35.sp,
                modifier = Modifier.padding(start = 20.dp,end = 20.dp,top = 30.dp)
            )
            Button(
                onClick = {navController.navigate(route = Screen.ArtistSignUp.route)},
                modifier = Modifier
                    .padding(top = 50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = stringResource(R.string.anArtist),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                )
            }
            Text(
                text = stringResource(R.string.explore_create),
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Row(modifier = Modifier.padding(top = 30.dp, bottom = 20.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                    .padding(2.dp)
                    .width(20.dp))
                Text(text = stringResource(R.string.or),fontSize = 20.sp,color = Color.Black, modifier = Modifier.padding(2.dp))
                Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                    .padding(2.dp)
                    .width(20.dp))
            }
            Button(
                onClick = { navController.navigate(route = Screen.ProducerSignUp.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = stringResource(R.string.producer),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )
            }
            Text(
                text = stringResource(R.string.publishingBeats),
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}








@Preview(showBackground = true)
@Composable
fun OptPreview() {
    BeatshareTheme {
        ArtistVProducer(navController = rememberNavController())
    }
}
