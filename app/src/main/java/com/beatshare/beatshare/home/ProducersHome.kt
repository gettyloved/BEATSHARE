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
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.*
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme
import com.beatshare.beatshare.utils.generateRandomColors

@ExperimentalFoundationApi
@Composable
fun ProducersHome(navController: NavController){
    val helveticaFont = FontFamily(Font(R.font.helvetica))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Heading(navController = navController)
            Explore(explored = listOf(
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
            ), fontFamily = helveticaFont
            )
            Editor(
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
            , fontFamily = helveticaFont)
            InstrumentalGridView(
                instrument = listOf(
                    Instrumental(
                        "Drums"
                    ),
                    Instrumental(
                        "Guiter"
                    ),
                    Instrumental(
                        "Piano"
                    ),
                    Instrumental(
                        "Flute"
                    )
                )
            , fontFamily = helveticaFont)


        }
    }
}



@Composable
fun Heading(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(R.string.home),
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )
        IconButton(onClick = { navController.navigate(Screen.ProducersProfile.route) }) {
            Image(
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
fun Explore(explored: List<ExploreItems>, fontFamily: FontFamily){
    Column() {
        Text(
            text = stringResource(R.string.selectionOfSounds),
            color = Color.White,
            fontSize = 22.sp,
            fontFamily=fontFamily,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(10.dp)
        ){
            items(explored.size){
                ExploreView(exploreItems = explored[it],fontFamily)
            }
        }
    }
}


@Composable
fun ExploreView(exploreItems: ExploreItems,fontFamily: FontFamily) {
   // val helveticaFont = FontFamily(Font(R.font.helvetica))
    val color = remember { derivedStateOf { generateRandomColors() } }
    BoxWithConstraints(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .size(80.dp)
            .background(color.value, shape = RoundedCornerShape(5.dp))

    ) {
        Text(
            text = exploreItems.title,
            color = Color.White,
            fontFamily= fontFamily,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun Editor(editorsItems: List<EditorsItems>,fontFamily: FontFamily) {
    Column() {
        Text(
            text = stringResource(R.string.editorsPicks),
            color = Color.White,
            fontSize = 22.sp,
            fontFamily=fontFamily,
            textAlign= TextAlign.Start,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(editorsItems.size){
                EditorView(editorItem = editorsItems[it],fontFamily=fontFamily)
            }
        }
    }
}

@Composable
fun EditorView(editorItem: EditorsItems,fontFamily: FontFamily) {
    val color = remember { derivedStateOf { generateRandomColors() } }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color.value, shape = RoundedCornerShape(10.dp))
            .size(80.dp)
    ) {
        Text(
            text = editorItem.topic,
            color = Color.White,
            fontFamily=fontFamily,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(10.dp)
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun InstrumentalGridView(instrument: List<Instrumental>,fontFamily: FontFamily) {
    Column() {
        Text(
            text = stringResource(R.string.instruments_galore),
            color = Color.White,
            fontSize = 22.sp,
            fontFamily=fontFamily,
            modifier = Modifier.padding(start = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(instrument.size){
                InstrumentalView(instruments = instrument[it], fontFamily = fontFamily)
            }
        }
    }
}

@Composable
fun InstrumentalView(modifier:Modifier=Modifier,
                     instruments: Instrumental,fontFamily: FontFamily) {
    val color = remember { derivedStateOf { generateRandomColors() } }
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color.value, shape = RoundedCornerShape(10.dp))
            .size(80.dp)
    ) {
        Text(
            text = instruments.heading,
            color = Color.White,
            fontFamily=fontFamily,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(10.dp)
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














