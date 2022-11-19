package com.beatshare.beatshare.welcome

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.beatshare.beatshare.R
import com.beatshare.beatshare.Screen
import com.beatshare.beatshare.ui.theme.BeatshareTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    var startAnimation by remember{ mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            4000
        )
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(3000)
        navController.navigate(Screen.WelcomePage.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha:Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_name2),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .alpha(alpha)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun splashPreview() {
    BeatshareTheme {
        SplashScreen(rememberNavController())
    }
}