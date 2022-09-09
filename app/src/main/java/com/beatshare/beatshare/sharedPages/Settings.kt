package com.beatshare.beatshare.sharedPages


//Settings UI page. Any additional parts will come up later in the future.

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.beatshare.beatshare.R
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Settings(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(10.dp)
    ){
        settingBody()
    }
}

@Composable
fun settingBody() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(id = R.string.settings),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
        }
        Text(
            text = stringResource(R.string.account),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = stringResource(R.string.userType),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        Text(
            text = stringResource(R.string.artist),
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp)
        )
        Text(
            text = stringResource(R.string.email),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        Text(
            text = stringResource(R.string.example_email),
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 20.dp)
        )
        Text(
            text = stringResource(R.string.social),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        Text(
            text = stringResource(R.string.linked_accounts),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.facebook),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.tiktok),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.instagram),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.google),
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Text(
            text = stringResource(R.string.notifications),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp)
        )
        Text(
            text = stringResource(R.string.choose_notifications),
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 40.dp)
        )
        Text(
            text = stringResource(R.string.about),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = stringResource(R.string.version),
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}











@Preview(showBackground = true)
@Composable
fun SettingPreview() {
    BeatshareTheme {
        Settings(navController = rememberNavController())
    }
}

