package com.erkindilekci.bookapp.presentation.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.erkindilekci.bookapp.ui.theme.PrimaryColorLight
import com.erkindilekci.bookapp.ui.theme.Shapes
import com.erkindilekci.bookapp.ui.theme.myPrimaryColor

@Composable
fun ChipView(category: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .clip(shape = Shapes.large)
            .background(PrimaryColorLight.copy(.10F))
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.myPrimaryColor,
            fontWeight = FontWeight.Medium
        )
    }
    Spacer(modifier = Modifier.width(5.dp))
}