package com.beatshare.beatshare.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.ArtistSignupData
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ArtistsSignUpViewModel
import com.beatshare.beatshare.ui.theme.BeatshareTheme


//Library Page. This Library page is accessed from clicking the Profile icon on the top right corner.
// An Artist or Producer will have different UI navigation.
// The above share some features that a producer should access, like View Stats and View Earnings.

@Composable
fun Library(
    artistsSignUpViewModel: ArtistsSignUpViewModel,
    navController: NavController
){
    val artistSignupData:ArtistSignupData by artistsSignUpViewModel.artistSignupData.collectAsState(initial = ArtistSignupData.EMPTY)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.library),
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.White
                )
                IconButton(onClick = {
                    navController.navigate(Screen.Settings.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                        contentDescription = "Music Library",
                        modifier = Modifier.size(50.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.person1),
                        contentDescription = "Person",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                }
                Column (modifier = Modifier.padding(start = 20.dp)){
                    Text(
                        text = "Hello ${artistSignupData.userName}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = stringResource(R.string.youre_an_artist),
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            LazyRow(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ){
                items(5){
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                            contentDescription = "Statistics Illustrations",
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text = "View Stats",
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.recentActivity),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(10.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items(5){
                        Box(
                            modifier = Modifier
                                .size(120.dp)
                                .padding(10.dp)
                                .background(Color.Magenta)
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                text = "Your Purchases",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(contentPadding = PaddingValues()){
                items(10){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Blue)
                        )
                        Column() {
                            Text(text = "Jazz Tunes", fontWeight = FontWeight.Bold, color = Color.White)
                            Text(text = "Sex Vibes", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LibPreview() {
    BeatshareTheme {
        Library(artistsSignUpViewModel = ArtistsSignUpViewModel(), navController = rememberNavController())
    }
}




