package com.erkindilekci.bookapp.presentation.listscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.ui.theme.myBackgroundColor
import com.erkindilekci.bookapp.ui.theme.myCardColor
import com.erkindilekci.bookapp.ui.theme.myTextColor
import com.erkindilekci.bookapp.ui.theme.typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookListItem(book: Book, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.myBackgroundColor)
            .padding(12.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.myCardColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick() },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(book.thumbnailUrl)
                    .crossfade(true)
                    .build(),
                //placeholder = painterResource(R.drawable.placeholder),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(95.dp, 135.dp)
                    .fillMaxSize()
                    .padding(12.dp)
                    //.clip(RoundedCornerShape(15.dp)),
                ,error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "by ${book.authors.joinToString()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.myTextColor.copy(0.6F),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = book.title,
                    style = typography.headlineSmall,
                    color = MaterialTheme.myTextColor,
                    //fontSize = 16.sp
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
}