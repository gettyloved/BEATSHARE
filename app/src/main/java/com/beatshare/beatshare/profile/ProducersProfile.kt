package com.beatshare.beatshare.profile



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.TabItem
import com.beatshare.beatshare.login.ForgotPassword
import com.beatshare.beatshare.ui.theme.BeatshareTheme
import com.beatshare.beatshare.ui.theme.White
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

//This one is a profile page for Producers.
// Can be displayed and accessed by any account type; Guest, Producer or artist.
//The artist or producer can navigate the Producer's content and information
//If a Guest tries to access the follow button,
// the user will be prompted to the Sign Up or Login page

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProducerProfile(navController: NavController){
    val list = listOf(TabItem.Explore,TabItem.Info)
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
       Box(
           contentAlignment = Alignment.BottomStart,
           modifier = Modifier
               .fillMaxWidth()
               .height(300.dp)
               .background(Color.Blue)
       ) {
           Column (modifier = Modifier.padding(start = 20.dp, bottom = 20.dp)){
               Text(
                   text = stringResource(R.string.zhino),
                   fontSize = 40.sp,
                   color = White,
                   fontWeight = FontWeight.Bold
               )
               Spacer(modifier = Modifier.padding(10.dp))
               Button(onClick = {}) {
                   Icon(
                       painter = painterResource(id = R.drawable.ic_baseline_person_add_alt_1_24),
                       contentDescription = stringResource(R.string.follow)
                   )
                   Text(
                       text = stringResource(R.string.follow),
                       fontWeight = FontWeight.Bold
                   )
               }
           }
       }
       Column(modifier = Modifier.fillMaxSize()) {
            Tabs(tabs = list, pagerState = pagerState)
           TabContent(tabs = list, pagerState = pagerState)
       }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs:List<TabItem>,
    pagerState: PagerState
){
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Black,
        indicator = {tabPositions ->
            Modifier.pagerTabIndicatorOffset(
                pagerState = pagerState,
                tabPositions = tabPositions
            )
        }
    ) {
        tabs.forEachIndexed{index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Text(
                        text = tabItem.title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ) }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].pages()
    }
}

@Preview(showBackground = true)
@Composable
fun FPreview() {
    BeatshareTheme {
        ProducerProfile(navController = rememberNavController())
    }
}