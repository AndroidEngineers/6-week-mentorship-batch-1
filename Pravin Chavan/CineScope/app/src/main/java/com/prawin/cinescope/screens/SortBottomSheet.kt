package com.prawin.cinescope.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.R
import com.prawin.cinescope.model.Sort
import com.prawin.cinescope.ui.theme.darkGold
import com.prawin.cinescope.ui.theme.darkGray
import com.prawin.cinescope.ui.theme.darkRed
import com.prawin.cinescope.ui.theme.darkReddish
import com.prawin.cinescope.ui.theme.lightGraySubtitle
import com.prawin.cinescope.ui.theme.lightReddish
import com.prawin.cinescope.ui.theme.white

val sortList = listOf<Sort>(
    Sort(id = 1, name = "Name", isSelected = false),
    Sort(id = 2, name = "Duration", isSelected = false),
    Sort(id = 3, name = "Popularity", isSelected = false),
    Sort(id = 4, name = "Release Date", isSelected = false),
    Sort(id = 5, name = "Votes Count", isSelected = true),
)

@Preview
@Composable
private fun SortSheetContentsPreview() {
    SortSheetContents(remember { mutableStateOf(true) })
}

@Composable
fun SortSheetContents(isSortingSheetOpen: MutableState<Boolean>) {
    Column(modifier = Modifier.height(320.dp)) {
        Text(
            text = "Sort By",
            color = white,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .background(lightReddish)
                .padding(8.dp)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(sortList) {
                sortItem(it)
            }
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Button(
                onClick = {
                    //todo perform sorting

                },
                colors = ButtonDefaults.buttonColors(darkRed),
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = stringResource(R.string.sort))
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    isSortingSheetOpen.value = false
                },
                colors = ButtonDefaults.buttonColors(darkGold),
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = stringResource(R.string.cancel))
            }
        }
    }
}

@Composable
fun sortItem(sortItem: Sort) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            colors = RadioButtonColors(
                selectedColor = darkReddish,
                unselectedColor = darkGray,
                disabledSelectedColor = lightReddish,
                disabledUnselectedColor = lightGraySubtitle
            ), selected = sortItem.isSelected, onClick = {

            })
        Text(modifier = Modifier.fillMaxWidth(), text = sortItem.name)
    }
}