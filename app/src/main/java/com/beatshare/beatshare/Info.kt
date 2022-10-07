package com.beatshare.beatshare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Info(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Releases",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Image(painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription = null)
        }
        Minfo(infoItem = listOf())
        Image(
            painter = painterResource(id = R.drawable.person1),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp),
        )
    }
}

@Composable
fun Minfo(infoItem:List<InfoItems>) {
    LazyRow( modifier = Modifier.fillMaxWidth()){
        items(infoItem.size){
            MinfoItems(infoItems = infoItem[it])
        }
    }
}

@Composable
fun MinfoItems(infoItems: InfoItems) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .size(90.dp)) {
                Image(
                    painter = painterResource(id = infoItems.image) ,
                    contentDescription = null)
            }
            Text(
                text = infoItems.title,
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