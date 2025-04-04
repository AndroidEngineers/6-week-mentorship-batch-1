
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.apsakare.moviesapp.R
import com.apsakare.moviesapp.ui.theme.Black
import com.apsakare.moviesapp.ui.theme.MoviesAppTheme
import com.apsakare.moviesapp.ui.theme.White
import com.apsakare.moviesapp.ui.theme.app_black
import com.apsakare.moviesapp.ui.theme.golden

@Composable
fun ComposeLottieScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        ) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.cinema)
        )
        var isPlaying by remember {
            mutableStateOf(true)
        }
        val progress by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = isPlaying
        )

        LaunchedEffect(key1 = progress) {

            if (progress == 0f) {
                isPlaying = true

            }
            if (progress == 1f) {
                isPlaying = false
            }


        }
        if (!isPlaying) {
            Surface(modifier = Modifier.fillMaxSize(), color = colorScheme.background) {
                if (isInternetAvailable(LocalContext.current)) {
                    ShowSplash()
                } else {
                    val openDialog = remember { mutableStateOf(false) }
                    openDialog.value = true
                    AlertDialogNetwork(openDialog)
                }
            }
        }

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(1500.dp)
                .clickable {
                    isPlaying = true
                },

            progress = {
                progress
            }
        )
    }
}

@Composable
fun ShowSplash() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "image",
            alignment = Alignment.Center,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = CenterHorizontally,

            ) {
            val sContext = LocalContext.current
            Text(
                text = sContext.getString(R.string.welcome),
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    Toast.makeText(
                        sContext,
                        sContext.getText(R.string.splash_btn),
                        Toast.LENGTH_LONG
                    ).show()
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(CenterHorizontally),

                colors = ButtonDefaults.buttonColors(golden)
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = sContext.getString(R.string.splash_btn), color = Black,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun AlertDialogNetwork(openDialog: MutableState<Boolean>) {
    val localContext = LocalContext.current
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = localContext.getString(R.string.no_internet))
            },
            text = {
                Text(localContext.getString(R.string.check_internet))
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }) {
                    Text(localContext.getString(R.string.okay))
                }
            },

            )
    }
}

private fun isInternetAvailable(context: Context): Boolean {
    var result = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connectivityManager.run {
            connectivityManager.activeNetworkInfo?.run {
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
    }
    return result
}