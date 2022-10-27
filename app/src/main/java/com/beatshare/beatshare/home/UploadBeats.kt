package com.beatshare.beatshare.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Uploads

@Composable
fun UploadBeats(){
    val helveticaFont = FontFamily(Font(R.font.helvetica))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Beats by Top Creators",
                    color = Color.White,
                    fontFamily=helveticaFont,
                    modifier = Modifier.padding(5.dp)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            BeatsBody(
                uploads = listOf(
                    Uploads(R.drawable.ic_baseline_account_circle_24),
                    Uploads(R.drawable.ic_baseline_account_circle_24),
                    Uploads(R.drawable.ic_baseline_account_circle_24),
                    Uploads(R.drawable.ic_baseline_account_circle_24)
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = stringResource(id = R.string.submit_beats_instrumentation),
                color = Color.White,
                fontFamily = helveticaFont,
                fontSize = 21.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = stringResource(R.string.submitHere),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BeatsBody(uploads: List<Uploads>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(5.dp)
    ){
        items(uploads.size){
            BeatsUpload(uploads = uploads[it])
        }
    }
}

@Composable
fun BeatsUpload(uploads: Uploads) {
    Image(
        painter = painterResource(id = uploads.image),
        contentDescription = null,
        modifier = Modifier.size(150.dp)
    )
}


@Composable
@Preview
fun UpPreview(){
    UploadBeats()
}