package com.apsakare.moviesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apsakare.moviesapp.ui.theme.Black
import com.apsakare.moviesapp.ui.theme.MoviesAppTheme
import com.apsakare.moviesapp.ui.theme.White
import com.apsakare.moviesapp.ui.theme.app_black
import com.apsakare.moviesapp.ui.theme.golden

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  app_black
                ) {
                    showSplash()
                }
            }
        }
    }
}
@Composable
fun showSplash(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription ="image",
            alignment = Alignment.Center,

            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
             horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            val sContext = LocalContext.current;
Text(text = sContext.getString(R.string.welcome), color = White, fontWeight = FontWeight.Bold,
    fontSize = 35.sp)
            Spacer(modifier = Modifier.width(10.dp))
Button(onClick = {
    Toast.makeText(sContext, sContext.getText(R.string.splash_btn), Toast.LENGTH_LONG).show()
},
    modifier = Modifier.padding(16.dp).align(CenterHorizontally),

    colors = ButtonDefaults.buttonColors(golden)
    ) {
    Text(modifier = Modifier.padding(10.dp),
        text = sContext.getString(R.string.splash_btn), color = Black,
        fontSize = 15.sp)
}
        }
    }
}



