package com.prawin.cinescope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.ui.theme.CineScopeTheme
import com.prawin.cinescope.ui.theme.reddish
import com.prawin.cinescope.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineScopeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    splashScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
private fun splashScreen(innerPadding: PaddingValues) {
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