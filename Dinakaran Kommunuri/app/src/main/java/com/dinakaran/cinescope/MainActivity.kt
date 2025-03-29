package com.dinakaran.cinescope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinakaran.cinescope.ui.screens.home.BottomNavigation
import com.dinakaran.cinescope.ui.screens.home.HomeScreen
import com.dinakaran.cinescope.ui.screens.home.TitleBar
import com.dinakaran.cinescope.ui.theme.CineScopeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineScopeTheme {
                Scaffold(
                    topBar = { TitleBar() },
                    bottomBar = { BottomNavigation() }
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HPreview() {
    Scaffold(
        topBar = { TitleBar() },
        bottomBar = { BottomNavigation() }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}


