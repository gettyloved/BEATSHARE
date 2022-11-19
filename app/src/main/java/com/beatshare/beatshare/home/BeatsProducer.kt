package com.beatshare.beatshare.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.*
import com.beatshare.beatshare.R

//Beats by Producers (still part of the home page, but to be accessed downwards as user
// scrolls to get more content)
//Some contents needs to be navigated from left to right
//This one now should be under Beatshare for Artists. Together with Home Page part 1 (for artists)


@Composable
fun BeatsProducer(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(15.dp)
       ) {
          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
          ) {
              Text(
                  text = "Beats by \nProducers",
                  fontWeight = FontWeight.ExtraBold,
                  color = Color.White,
                  fontSize = 22.sp
              )
              IconButton(
                  onClick = {
                            navController.navigate(route = Screen.ProducersProfile.route)
                  },
                  modifier = Modifier
                      .size(60.dp)
                      .clip(CircleShape)
              ) {
                 Image(
                     painter = painterResource(id = R.drawable.person1),
                     modifier=Modifier.size(120.dp),
                     contentDescription = null
                 )
              }
          }
           Spacer(modifier = Modifier.padding(15.dp))
          Featured(
              topFeature = listOf(
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24),
                  TopFeature("Prod", R.drawable.ic_baseline_account_circle_24)
              )
          )
        Spacer(Modifier.height(25.dp))
          Sounds(
              topSound = listOf(
                  TopSounds(R.color.blue,"Grass","Prod - $3.00"),
                  TopSounds(R.color.green,"Calm","Prod - $1.95"),
                  TopSounds(R.color.wineRed,"Chain","Prod - $2.94"),
                  TopSounds(R.color.orange,"Grass","Prod - $3.00"),
                  TopSounds(R.color.pink,"Calm","Prod - $1.95"),
                  TopSounds(R.color.purple,"Chain","Prod - $2.94"),
                  TopSounds(R.color.yellow,"Grass","Prod - $3.00"),
                  TopSounds(R.color.white,"Calm","Prod - $1.95")
              )
          )
           Spacer(Modifier.height(25.dp))
          NewSounds(
              newSound = listOf(
                  NewSound(R.color.blue,"Grass","Prod - $3.00"),
                  NewSound(R.color.green,"Grass","Prod - $3.00"),
                  NewSound(R.color.wineRed,"Grass","Prod - $3.00"),
                  NewSound(R.color.orange,"Grass","Prod - $3.00"),
                  NewSound(R.color.pink,"Grass","Prod - $3.00"),
                  NewSound(R.color.purple,"Grass","Prod - $3.00"),
                  NewSound(R.color.yellow,"Grass","Prod - $3.00"),
                  NewSound(R.color.white,"Grass","Prod - $3.00")
              )
          )
       }
    }
}

@Composable
fun Featured(topFeature:List<TopFeature>) {
    Text(
        text = "Top Featured",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Spacer(modifier = Modifier.padding(5.dp))
    LazyRow(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(topFeature.size){
            FeaturedItems(topFeature = topFeature[it])
        }
    }
}

@Composable
fun FeaturedItems(topFeature: TopFeature) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        Image(
            painter = painterResource(id = topFeature.img),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(
            text = topFeature.title,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 25.dp)
        )
    }
}

@Composable
fun Sounds(topSound:List<TopSounds>) {
    Text(
        text = "Top Sounds",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Spacer(modifier = Modifier.padding(5.dp))
    LazyRow(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(topSound.size){
            SoundItems(topSound = topSound[it])
        }
    }
}

@Composable
fun SoundItems(topSound: TopSounds) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
    ) {

        Box(
            modifier = Modifier
                .height(130.dp)
                .width(150.dp)
                .padding(10.dp)
                .background(
                    color = colorResource(id = topSound.color),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {

        }
        Text(
            text = topSound.title,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 25.dp)
        )
        Text(
            text = topSound.subTitle,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 25.dp)
        )
    }
}


@Composable
fun NewSounds(newSound:List<NewSound>) {
    Text(
        text = "New Sounds",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Spacer(modifier = Modifier.padding(5.dp))
    LazyRow(
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        items(newSound.size){
            SoundsItems(newSound = newSound[it])
        }
    }
}

@Composable
fun SoundsItems(newSound: NewSound) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
    ) {

        Box(
            modifier = Modifier
                .height(130.dp)
                .width(150.dp)
                .padding(10.dp)
                .background(
                    color = colorResource(id = newSound.color),
                    shape = RoundedCornerShape(5.dp)
                )
        ) {

        }
        Text(
            text = newSound.title,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 25.dp)
        )
        Text(
            text = newSound.subTitle,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 25.dp)
        )
    }
}


@Composable
@Preview
fun beatPreview(){
    BeatsProducer(navController = rememberNavController())
}