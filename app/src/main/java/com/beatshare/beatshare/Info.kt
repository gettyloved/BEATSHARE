package com.beatshare.beatshare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Info(){
    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Stats()
            Spacer(modifier = Modifier.padding(20.dp))
            AboutMe()
            Spacer(modifier = Modifier.padding(20.dp))
            SocialMedia()
        }
    }
}

@Composable
fun Stats() {
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Text(
                    text = stringResource(R.string.number),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.followers),
                    color = Color.White
                )
            }
            Column() {
                Text(
                    text = "205",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.tracks),
                    color = Color.White
                )
            }
            Column() {
                Text(
                    text = "1.2M",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.plays),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun AboutMe() {
  Column() {
      Text(
          text = "About Me",
          color = Color.White,
          fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.padding(10.dp))
      Text(
          text = "",
          color = Color.White
      )
  }
}

@Composable
fun SocialMedia() {
   Column() {
       Text(
           text = stringResource(R.string.contacts),
           fontWeight = FontWeight.Bold,
           color = Color.White
       )
       Text(
           text = stringResource(R.string.emailEg),
           color = Color.White
       )
       Spacer(modifier = Modifier.padding(10.dp))
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceAround
       ) {
           Image(
               painter = painterResource(id = R.drawable.facebook_removebg_preview),
               contentDescription = null,
               modifier = Modifier.size(50.dp).padding(end = 20.dp)
           )
           Text(
               text = stringResource(R.string.zhino),
               color = Color.White
           )
       }
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceAround
       ) {
           Image(
               painter = painterResource(id = R.drawable.ig_removebg_preview),
               contentDescription = null,
               modifier = Modifier.size(50.dp).padding(end = 20.dp)
           )
           Text(
               text = stringResource(R.string.zhino),
               color = Color.White
           )
       }
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceAround
       ) {
           Image(
               painter = painterResource(id = R.drawable.twitter_removebg_preview),
               contentDescription = null,
               modifier = Modifier.size(50.dp).padding(end = 20.dp)
           )
           Text(
               text = stringResource(R.string.zhino),
               color = Color.White
           )
       }
   }
}


@Preview(showBackground = true)
@Composable
fun InfoPreview() {
    BeatshareTheme {
        Info()
    }
}