package com.erkindilekci.bookapp.presentation.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.ui.theme.myBackgroundColor
import com.erkindilekci.bookapp.ui.theme.myTextColor

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.myBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = "loading",
            modifier = Modifier.size(300.dp),
            tint = MaterialTheme.myTextColor
        )
    }
}