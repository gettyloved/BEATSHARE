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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun ArtistVProducer(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        FirstPart()
        ArtistAndProducer(navController = navController)
    }
}

@Composable
fun FirstPart(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 40.dp, top = 40.dp)) {
        Text(
            text = stringResource(R.string.beforeWeStart),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.youWantToRegisterAs),
            fontSize = 22.sp,
            modifier = Modifier.padding(end = 20.dp,top = 30.dp)
        )
        Spacer(modifier = Modifier.padding(20.dp))
    }
}


@Composable 
fun ArtistAndProducer(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = {navController.navigate(route = Screen.ArtistSignUp.route)},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(
                text = stringResource(R.string.anArtist),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign= TextAlign.Center,
                color = Color.White,
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.explore_create),
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                .padding(2.dp)
                .width(100.dp))
            Text(text = stringResource(R.string.or),fontSize = 20.sp,color = Color.Black, modifier = Modifier.padding(2.dp))
            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier
                .padding(2.dp)
                .width(100.dp))
        }
        Button(
            onClick = { navController.navigate(route = Screen.ProducerSignUp.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(
                text = stringResource(id = R.string.producer),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                textAlign= TextAlign.Center,
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.publishingBeats),
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}






@Preview(showBackground = true)
@Composable
fun OptPreview() {
    BeatshareTheme {
        ArtistVProducer(navController = rememberNavController())
    }
}
