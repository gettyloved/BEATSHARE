package com.beatshare.beatshare

import androidx.compose.runtime.Composable


typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val title:String,
    val pages:ComposableFun
){
   object Explore:TabItem("Explore",  pages = { Explore()})
   object Info:TabItem("Info",  pages = { Info()})
}
