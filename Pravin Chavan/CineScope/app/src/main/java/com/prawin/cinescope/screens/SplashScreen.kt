package com.prawin.cinescope.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.R

@Preview
@Composable
private fun SplashScreenPreview() {
    splashScreen(PaddingValues(0.dp))
}

@Composable
fun splashScreen(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(128.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.app_icon), contentDescription = "splash_screen",
        )
    }
}