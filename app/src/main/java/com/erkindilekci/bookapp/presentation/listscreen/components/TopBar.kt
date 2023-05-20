package com.erkindilekci.bookapp.presentation.listscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.ui.theme.myTextColor
import com.erkindilekci.bookapp.ui.theme.typography

@Composable
fun TopBar(title: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(R.string.back), tint = MaterialTheme.myTextColor)
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Text(text = title, style = typography.headlineLarge, color = MaterialTheme.myTextColor)
    }
}