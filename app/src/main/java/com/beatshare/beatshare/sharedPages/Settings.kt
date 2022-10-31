package com.beatshare.beatshare.sharedPages


//Settings UI page. Any additional parts will come up later in the future.
//Its also artist's profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beatshare.beatshare.R
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.SocialItems
import com.beatshare.beatshare.ui.theme.BeatshareTheme

@Composable
fun Settings(navController: NavController){
    val helveticaFont = FontFamily(Font(R.font.helvetica))
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(20.dp)
    ){
        Text(
            text = stringResource(id = R.string.settings),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = helveticaFont
        )
        Spacer(modifier = Modifier.padding(20.dp))
        SettingBody(fontFamily = helveticaFont)
        Spacer(modifier = Modifier.padding(20.dp))
        ArtistSocialAccounts(
            fontFamily = helveticaFont,
            socialItems = listOf(
                SocialItems(
                    R.drawable.facebook_removebg_preview,
                    stringResource(id = R.string.facebook)
                ),
                SocialItems(
                    R.drawable.ig_removebg_preview,
                    stringResource(id = R.string.instagram)
                ),
                SocialItems(
                    R.drawable.twitter_removebg_preview,
                    stringResource(R.string.twitter)
                ),
                SocialItems(
                    R.drawable.google_removebg_preview,
                    stringResource(id = R.string.google)
                )
            )
        )
        Notifications(fontFamily = helveticaFont)
    }
}

@Composable
fun SettingBody(fontFamily: FontFamily) {
   Column {
       Text(
           text = stringResource(id = R.string.account),
           fontFamily = fontFamily,
           color = Color.White
       )
       Spacer(modifier = Modifier.padding(20.dp))
       Text(
           text = stringResource(id = R.string.userType),
           fontFamily = fontFamily,
           color = Color.White,
           fontWeight = FontWeight.Bold
       )
       Spacer(modifier = Modifier.padding(5.dp))
       Text(
           text = stringResource(id = R.string.artist),
           fontFamily = fontFamily,
           color = Color.White
       )
       Spacer(modifier = Modifier.padding(20.dp))
       Text(
           text = stringResource(id = R.string.email),
           fontFamily = fontFamily,
           color = Color.White,
           fontWeight = FontWeight.Bold
       )
       Spacer(modifier = Modifier.padding(5.dp))
       Text(
           text = stringResource(id = R.string.emailEg),
           fontFamily = fontFamily,
           color = Color.White
       )
   }
}


@Composable
fun ArtistSocialAccounts(
    fontFamily: FontFamily,
    socialItems:List <SocialItems>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.social),
            fontFamily = fontFamily,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.linked_accounts),
            fontFamily = fontFamily,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            items(socialItems.size){
                SocialCard(socialItems = socialItems[it])
            }
        }
    }
}

@Composable
fun SocialCard(socialItems: SocialItems) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .size(80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = socialItems.image),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = socialItems.title,
                color = Color.White,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}


@Composable
fun Notifications(fontFamily: FontFamily) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.notifications),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.choose_notifications),
            color = Color.White,
            fontFamily = fontFamily
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = stringResource(id = R.string.version),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.versionType),
            color = Color.Gray,
            fontFamily = fontFamily
        )
    }
}




@Preview(showBackground = true)
@Composable
fun SettingPreview() {
    BeatshareTheme {
        Settings(navController = rememberNavController())
    }
}

