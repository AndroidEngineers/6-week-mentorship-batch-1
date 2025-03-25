package com.prawin.cinescope

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prawin.cinescope.screens.splashScreen
import com.prawin.cinescope.ui.theme.CineScopeTheme

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

