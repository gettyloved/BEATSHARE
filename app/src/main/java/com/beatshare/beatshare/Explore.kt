package com.beatshare.beatshare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatshare.beatshare.ui.theme.BeatshareTheme


@Composable
fun Explore(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.recentReleases),
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                    contentDescription = null)
            }
            Released(release = listOf(
                ReleasesItems("Afro Beats",R.color.blue),
                ReleasesItems("Amapiano vibes",R.color.wineRed),
                ReleasesItems("Rhumba",R.color.green),
                ReleasesItems("Hip Hop",R.color.yellow),
                ReleasesItems("Blues",R.color.orange)
            ))
            Tracks(trackItems = listOf(
                TrackItems(
                    R.color.wineRed,
                    "Sound of Sahara",
                    "$5.00"
                ),
                TrackItems(
                    R.color.blue,
                    "Sound of Sahara",
                    "$5.00"
                ),
                TrackItems(
                    R.color.yellow,
                    "Sound of Sahara",
                    "$5.00"
                ),
                TrackItems(
                    R.color.pink,
                    "Sound of Sahara",
                    "$5.00"
                ),
                TrackItems(
                    R.color.orange,
                    "Sound of Sahara",
                    "$5.00"
                ),
                TrackItems(
                    R.color.green,
                    "Sound of Sahara",
                    "$5.00"
                ),
            ))
        }
    }
}


@Composable
fun Released(release:List<ReleasesItems>) {
    LazyRow( modifier = Modifier.fillMaxWidth()){
        items(release.size){
            Releases(releasesItems = release[it])
        }
    }
}

@Composable
fun Releases(releasesItems: ReleasesItems) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .padding(10.dp),
        elevation = 4.dp
    ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .background(Color.Black),
           verticalArrangement = Arrangement.SpaceEvenly
       ) {
          Box(
              modifier = Modifier
                  .height(100.dp)
                  .width(150.dp)
                  .background(colorResource(id = releasesItems.color))
          ) {}
           Spacer(Modifier.height(10.dp))
          Text(
              text = releasesItems.title,
              color = Color.White
          )
       } 
    }
}

@Composable
fun Tracks(trackItems: List<TrackItems>) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ){
        item {  Text(
            text = "Tracks",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            textAlign= TextAlign.Start,
            modifier=Modifier.padding(horizontal = 10.dp)
        )
        }
        item{ Spacer(Modifier.height(10.dp)) }

        items(trackItems.size){
            TrackCard(trackItems = trackItems[it])
        }
    }
}

@Composable
fun TrackCard(trackItems: TrackItems) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .size(20.dp)
            .background(colorResource(id = trackItems.color))
        )
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = trackItems.title, color = Color.White)
            Text(text = trackItems.subTitle, color = Color.White)
        }
        Button(
            onClick = {  },
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        ) {
            Text(text = stringResource(R.string.preview))
        }
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_circle_24),
                contentDescription = null,
                tint = Color.White
            )
        }
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_favorite_border_24),
                contentDescription = null,
                tint = Color.White
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    BeatshareTheme {
        Explore()
    }
}