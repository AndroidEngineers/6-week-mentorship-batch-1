package com.prawin.cinescope.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prawin.cinescope.R
import com.prawin.cinescope.model.Filter
import com.prawin.cinescope.model.SubFilter
import com.prawin.cinescope.ui.theme.darkGold
import com.prawin.cinescope.ui.theme.darkRed
import com.prawin.cinescope.ui.theme.extraLightGray
import com.prawin.cinescope.ui.theme.lightReddish
import com.prawin.cinescope.ui.theme.white

val filterList = listOf<Filter>(
    Filter(
        1, "Language", listOf(
            SubFilter(1, "English", false),
            SubFilter(2, "German", false),
            SubFilter(3, "French", false),
            SubFilter(4, "Spanish", false),
            SubFilter(5, "Chinese", false),
        ), false
    ),
    Filter(
        2, "Year", listOf(
            SubFilter(1, "2025", false),
            SubFilter(1, "2024", false),
            SubFilter(1, "2023", false),
            SubFilter(1, "2022", false),
            SubFilter(1, "2021", false),
        ), false
    )
)

@Preview
@Composable
private fun FilterSheetContentsPreview() {
    FilterSheetContents(remember { mutableStateOf(true) })
}

@Composable
fun FilterSheetContents(isFilteringSheetOpen: MutableState<Boolean>) {
    val subFilterList = remember { mutableStateListOf<SubFilter>() }
    Column(modifier = Modifier.height(320.dp)) {
        Text(
            text = "Filter By",
            color = white,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .background(lightReddish)
                .padding(8.dp)
        )
        Row(modifier = Modifier.weight(1f)) {
            LazyColumn(modifier = Modifier.weight(0.4f)) {
                items(filterList) {
                    filterItem(it, subFilterList)
                }
            }
            LazyColumn(modifier = Modifier.weight(0.6f)) {
                items(subFilterList) {
                    subFilterItem(it)
                }
            }
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Button(
                onClick = {
                    //todo perform filtering

                },
                colors = ButtonDefaults.buttonColors(darkRed),
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = stringResource(R.string.filter))
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    isFilteringSheetOpen.value = false
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
fun filterItem(filter: Filter, subFilterList: SnapshotStateList<SubFilter>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(extraLightGray)
                .clickable(onClick = {
                    subFilterList.clear()
                    subFilterList.addAll(filter.subFilters)
                })
                .padding(horizontal = 8.dp, vertical = 12.dp), text = filter.filterName
        )
    }
}

@Composable
fun subFilterItem(subFilter: SubFilter) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(white)) {
        Checkbox(onCheckedChange = {
            subFilter.isChecked = !subFilter.isChecked
        }, checked = subFilter.isChecked)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(white)
                .padding(8.dp), text = subFilter.subFilterName
        )
    }
}