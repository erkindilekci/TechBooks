package com.erkindilekci.bookapp.presentation.detailscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.ui.theme.myTextColor
import com.erkindilekci.bookapp.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookDetailScaffold(book: Book, onBackCLicked: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Book Detail", color = MaterialTheme.myTextColor, style = MaterialTheme.typography.headlineLarge) },
                navigationIcon = {
                    IconButton(onClick = { onBackCLicked() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.back), tint = MaterialTheme.myTextColor)
                    }
                }
            )
        },
        content = {
            LazyColumn {
                item {
                    BookDetailCard(book = book)
                }

                item {
                    Column {
                        Text(
                            text = stringResource(R.string.description),
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.myTextColor,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 8.dp, top = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = if (book.longDescription.trim().isEmpty()) "Long description is empty" else book.longDescription,
                            style = typography.bodyLarge,
                            textAlign = TextAlign.Justify,
                            color = MaterialTheme.myTextColor.copy(0.7F),
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                        )
                    }
                }
            }
        }
    )
}