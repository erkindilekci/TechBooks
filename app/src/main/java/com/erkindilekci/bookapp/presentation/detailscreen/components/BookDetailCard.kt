package com.erkindilekci.bookapp.presentation.detailscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.presentation.listscreen.components.ChipView
import com.erkindilekci.bookapp.ui.theme.myCardColor
import com.erkindilekci.bookapp.ui.theme.myTextColor
import com.erkindilekci.bookapp.ui.theme.typography

@Composable
fun BookDetailCard(book: Book) {
    Box(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 16.dp, top = 40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.myCardColor),
        )

        BookImageContentView(book = book)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookImageContentView(book: Book) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.thumbnailUrl)
                .crossfade(true)
                .build(),
            //placeholder = painterResource(R.drawable.placeholder),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(120.dp, 180.dp)
                .padding(top = 36.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
                .clip(RoundedCornerShape(10.dp)),
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.myCardColor)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = book.title,
                style = typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.myTextColor
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "by ${book.authors.joinToString()}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.myTextColor.copy(0.6F),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            FlowRow {
                book.categories.forEach {
                    ChipView(category = it)
                }
            }
        }
    }
}

@Composable
fun BookDescription(book: Book) {
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
            text = book.longDescription,
            style = typography.bodyLarge,
            textAlign = TextAlign.Justify,
            color = MaterialTheme.myTextColor.copy(0.7F),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}