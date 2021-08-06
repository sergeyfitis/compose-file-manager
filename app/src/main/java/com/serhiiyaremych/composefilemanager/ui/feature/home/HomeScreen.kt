package com.serhiiyaremych.composefilemanager.ui.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection.Ltr
import androidx.compose.ui.unit.dp
import com.serhiiyaremych.composefilemanager.R
import com.serhiiyaremych.composefilemanager.ui.theme.ComposeFileManagerTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = contentPadding.calculateTopPadding())
    ) {
        SearchBar(
            modifier = Modifier.padding(
                horizontal = contentPadding.calculateStartPadding(Ltr)
            ),
            onClick = {})
        Spacer(modifier = Modifier.requiredHeight(32.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = contentPadding.calculateLeftPadding(Ltr))
        ) {
            items(3) { index ->
                val color =
                    if (index == 0) MaterialTheme.colors.secondary else MaterialTheme.colors.background
                val accentColor = if (index == 0) Color.White else MaterialTheme.colors.onBackground
                StorageCard(
                    surfaceColor = color,
                    contentAccentColor = accentColor,
                    state = StorageCardState(
                        cardTitle = stringResource(R.string.card_internal_storage),
                        usedStorageBytes = 0,
                        totalStorageBytes = 0,
                        storageDataFormatter = { "$it bytes" }
                    )
                )

                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Spacer(modifier = Modifier.requiredHeight(32.dp))

        LazyVerticalGrid(cells = GridCells.Fixed(4), content = {
            items(8) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Green)
                )
            }
        })
    }
}


@Preview
@Composable
private fun HomePreview() {
    ComposeFileManagerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(16.dp)) {
                HomeScreen()
            }
        }
    }
}