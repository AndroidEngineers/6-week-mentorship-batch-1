package com.dinakaran.cinescope.ui.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dinakaran.cinescope.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(){

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.title_bar),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)
        },
        actions = {
            IconButton(
                onClick = {/* TODO: Handle Search Click */}
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(
                onClick = {/* TODO: Handle Filter Click */}
            ) {
                Icon(
                    Icons.Filled.FilterList,
                    contentDescription = "Filter"
                )
            }
        }
    )
}