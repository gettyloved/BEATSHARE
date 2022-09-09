package com.beatshare.beatshare.home


//Home Page (for producers).
// This is for producers to access similar content but check their upload record stats.
// Scrollable to down.


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.beatshare.beatshare.*
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@ExperimentalFoundationApi
@Composable
fun ProducersHome(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            heading()
            explore(explored = listOf(
                ExploreItems(
                    stringResource(R.string.rockBeats),
                    R.color.green
                ),
                ExploreItems(
                    stringResource(R.string.hiphopBeats),
                    R.color.yellow
                ),
                ExploreItems(
                    stringResource(R.string.gengetoneBeats),
                    R.color.orange
                ),
                ExploreItems(
                    stringResource(R.string.edmBeats),
                    R.color.pink
                ),
                ExploreItems(
                    stringResource(R.string.afroBeats),
                    R.color.purple
                ),
                ExploreItems(
                    stringResource(R.string.more_genres),
                    R.color.blue
                ),
            )
            )
            editor(
                editorsItems = listOf(
                    EditorsItems(
                        stringResource(R.string.curated_sounds)
                    ),
                    EditorsItems(
                        stringResource(R.string.new_trending)
                    ),
                    EditorsItems(
                        stringResource(R.string.best_gengetone)
                    ),
                    EditorsItems(
                        stringResource(R.string.best_instumentals)
                    )
                )
            )
            instrumental(
                instrument = listOf(
                    Instrumental(
                        "Cows"
                    ),
                    Instrumental(
                        "Goats"
                    ),
                    Instrumental(
                        "Hen"
                    ),
                    Instrumental(
                        "Sheep"
                    )
                )
            )
        }
    }
}



@Composable
fun heading() {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(R.string.home),
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun explore(explored: List<ExploreItems>){
    Column() {
        Text(
            text = stringResource(R.string.collection_beats),
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(10.dp)
        ){
            items(explored.size){
                exploreView(exploreItems = explored[it])
            }
        }
    }
}


@Composable
fun exploreView(exploreItems: ExploreItems) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(5.dp))
            .size(80.dp)
            .background(Color.Blue)

    ) {
        Text(
            text = exploreItems.title,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(5.dp)
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun editor(editorsItems: List<EditorsItems>) {
    Column() {
        Text(
            text = stringResource(R.string.editorsPicks),
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(editorsItems.size){
                editorView(editorItem = editorsItems[it])
            }
        }
    }
}

@Composable
fun editorView(editorItem: EditorsItems) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Gray)
            .clip(RoundedCornerShape(10.dp))
            .size(80.dp)
    ) {
        Text(
            text = editorItem.topic,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(5.dp)
        )
    }
}




@ExperimentalFoundationApi
@Composable
fun instrumental(instrument: List<Instrumental>) {
    Column() {
        Text(
            text = stringResource(R.string.instruments_galore),
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(instrument.size){
                instrumentalView(instruments = instrument[it])
            }
        }
    }
}

@Composable
fun instrumentalView(instruments: Instrumental) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Magenta)
            .clip(RoundedCornerShape(10.dp))
            .size(80.dp)
    ) {
        Text(
            text = instruments.heading,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(5.dp)
        )
    }
}








@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun ProdPreview() {
    BeatshareTheme {
        ProducersHome(navController = rememberNavController())
    }
}














