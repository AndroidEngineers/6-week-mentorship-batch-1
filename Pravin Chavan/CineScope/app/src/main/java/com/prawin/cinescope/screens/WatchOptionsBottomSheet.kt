package com.prawin.cinescope.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.R
import com.prawin.cinescope.model.Sort
import com.prawin.cinescope.model.WatchOpt
import com.prawin.cinescope.ui.theme.darkGold
import com.prawin.cinescope.ui.theme.darkGoldenShade
import com.prawin.cinescope.ui.theme.darkGray
import com.prawin.cinescope.ui.theme.darkRed
import com.prawin.cinescope.ui.theme.darkReddish
import com.prawin.cinescope.ui.theme.lightGraySubtitle
import com.prawin.cinescope.ui.theme.lightReddish
import com.prawin.cinescope.ui.theme.white

val watchOptList = listOf<WatchOpt>(
    WatchOpt(id = 1, name = "Prime", image = R.drawable.prime),
    WatchOpt(id = 2, name = "Youtube", image = R.drawable.youtube),
    WatchOpt(id = 3, name = "Netflix", image = R.drawable.netflix),
    WatchOpt(id = 4, name = "Hotstar", image = R.drawable.hotstar),
)

@Preview
@Composable
private fun WatchOptSheetContentsPreview() {
    WatchOptSheetContents(remember { mutableStateOf(true) })
}

@Composable
fun WatchOptSheetContents(isSheetOpen: MutableState<Boolean>) {
    Column(modifier = Modifier.wrapContentHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(listOf(darkGold, darkGoldenShade)))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Watch Options",
                color = white,
                style = MaterialTheme.typography.titleMedium,
            )
            IconButton(onClick = {
                isSheetOpen.value = false
            }, modifier = Modifier.size(24.dp)) {
                Image(
                    imageVector = Icons.Rounded.Clear,
                    colorFilter = ColorFilter.tint(white),
                    contentDescription = "close"
                )
            }
        }
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(watchOptList) {
                WatchOptItem(it)
            }
        }
    }
}

@Composable
fun WatchOptItem(watchOpt: WatchOpt) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(white)
    ) {
        Image(
            painter = painterResource(watchOpt.image),
            contentDescription = watchOpt.name,
            Modifier
                .size(128.dp)
                .padding(8.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
        )
    }
}