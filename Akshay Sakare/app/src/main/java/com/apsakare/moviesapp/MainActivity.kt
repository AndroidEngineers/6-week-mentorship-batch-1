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
import com.apsakare.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.app_black)
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
            val ctx = LocalContext.current;
Text(text = "Welcome", color = colorResource(id = R.color.white), fontWeight = FontWeight.Bold,
    fontSize = 35.sp)
            Spacer(modifier = Modifier.width(10.dp))
Button(onClick = {
    Toast.makeText(ctx, "Wait.. Movie Will Release Soon", Toast.LENGTH_LONG).show()
},
    modifier = Modifier.padding(16.dp).align(CenterHorizontally),

    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.golden))
    ) {
    Text(modifier = Modifier.padding(10.dp),
        text = "Click Here To Start Your MoviesApp", color = colorResource(id = R.color.black),
        fontSize = 15.sp)
}
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesAppTheme {
        Greeting("Android")
    }
}