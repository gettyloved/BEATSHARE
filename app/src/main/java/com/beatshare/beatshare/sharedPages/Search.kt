package com.beatshare.beatshare.sharedPages



//The search UI design with background icon and search bar.

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
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
import com.beatshare.beatshare.R
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Search(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.search),
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
            }

            searchView()

            Text(
                text = stringResource(R.string.search_entire_collection),
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(40.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_library_music_24),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(top = 50.dp)
            )

        }
    }
}


@Composable
fun searchView() {
    Card(
        shape = RoundedCornerShape(30.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(25.dp),
        elevation = 5.dp
    ) {
        Row(){
            var ans by remember {
                mutableStateOf("")
            }
            TextField(
                value = ans,
                onValueChange = {ans = it},
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = stringResource(R.string.search),
                        fontSize = 15.sp
                    )
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    BeatshareTheme {
        Search()
    }
}



