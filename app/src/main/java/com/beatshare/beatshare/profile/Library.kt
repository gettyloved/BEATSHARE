package com.beatshare.beatshare.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
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
import com.beatshare.beatshare.ArtistSignupData
import com.beatshare.beatshare.R
import com.beatshare.beatshare.TheViewModel
import com.beatshare.beatshare.login.Welcome
import com.beatshare.beatshare.ui.theme.BeatshareTheme


//Library Page. This Library page is accessed from clicking the Profile icon on the top right corner.
// An Artist or Producer will have different UI navigation.
// The above share some features that a producer should access, like View Stats and View Earnings.

@Composable
fun Library(theViewModel: TheViewModel){
    val artistSignupData:ArtistSignupData by theViewModel.artistSignupData.collectAsState(initial = ArtistSignupData.EMPTY)
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
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                    contentDescription = "Music Library",
                    modifier = Modifier.size(50.dp)
                )
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
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                }
                Column {
                    Text(
                        text = "Hello ${artistSignupData.userName}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.youre_an_artist),
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ){
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                        contentDescription = "Statistics Illustrations",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = "View Stats",
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                        contentDescription = "Statistics Illustrations",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = "Favorites",
                        color = Color.White
                    )
                }
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                        contentDescription = "Statistics Illustrations",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = "View Earnings",
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.recentActivity),
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Card(
                        modifier = Modifier
                            .size(50.dp),
                        elevation = 4.dp,
                        backgroundColor = Color.Red
                    ) {

                    }
                    Card(
                        modifier = Modifier
                            .size(50.dp),
                        elevation = 4.dp,
                        backgroundColor = Color.Green
                    ) {

                    }
                    Card(
                        modifier = Modifier
                            .size(50.dp),
                        elevation = 4.dp,
                        backgroundColor = Color.Gray
                    ) {

                    }
                }
            }
            Column {
//            Should be a lazy column
                Text(text = "Your Purchases", color = Color.White, fontSize = 20.sp)
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "Jazz Tunes")
                        Text(text = "Sex Vibes")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "Afro Tunes")
                        Text(text = "Dj Zhino")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "Gengetone Beats")
                        Text(text = "Odi sounds")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "HipHop Beats")
                        Text(text = "Casper")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "EDM Tunes")
                        Text(text = "Jedd")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)
                    ) {

                    }
                    Column {
                        Text(text = "Rock Beats")
                        Text(text = "Harts")
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
        Library(theViewModel = TheViewModel())
    }
}




