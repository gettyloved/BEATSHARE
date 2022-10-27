package com.beatshare.beatshare.home

//Home Page (for artists). This should be scrollable downwards to access extra library content.



import android.widget.ImageButton
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import com.beatshare.beatshare.EditorsItems
import com.beatshare.beatshare.ExploreItems
import com.beatshare.beatshare.Galore
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@ExperimentalFoundationApi
@Composable
fun ArtistsHome(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            header()
            Aexplore(explored = listOf(
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
            Aeditor(
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
            footer(
                navController = navController,
                galore = listOf(
                    Galore("hiphop"),
                    Galore("rock"),
                    Galore("amapiano"),
                    Galore("regge"),
                    Galore("ragga"),
                    Galore("Bongo"),
                    Galore("Sol"),
                    Galore("Zilizopendwa"),
                )
            )
        }
    }
}



@Composable
fun header() {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(R.string.home),
            color = Color.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold
        )
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.person1),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Aexplore(explored: List<ExploreItems>){
    Column() {
        Text(
            text = stringResource(R.string.collection_beats),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(10.dp)
        ){
            items(explored.size){
                AexploreView(exploreItems = explored[it])
            }
        }
    }
}


@Composable
fun AexploreView(exploreItems: ExploreItems) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .size(80.dp)
            .background(Color.Blue, shape=RoundedCornerShape(5.dp))

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
fun Aeditor(editorsItems: List<EditorsItems>) {
    Column() {
        Text(
            text = stringResource(R.string.editorsPicks),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(editorsItems.size){
                AeditorView(editorItem = editorsItems[it])
            }
        }
    }
}

@Composable
fun AeditorView(editorItem: EditorsItems) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Gray,shape=RoundedCornerShape(5.dp))
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




@Composable
fun footer(
    navController: NavController,
    galore:List<Galore>
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.insrumentalGalore),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(10.dp)
        ){
            items(galore.size){
                AeditorGalore(galore = galore[it])
            }
        }
    }
}

@Composable
fun AeditorGalore(galore: Galore) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.Magenta,shape=RoundedCornerShape(5.dp))
            .size(80.dp)
    ) {
        Text(
            text = galore.title,
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
fun DArtPreview() {
    BeatshareTheme {
        ArtistsHome(navController = rememberNavController())
    }
}