package com.erkindilekci.bookapp.presentation.listscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.erkindilekci.bookapp.R
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.presentation.util.MainActions
import com.erkindilekci.bookapp.ui.theme.myTextColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.erkindilekci.bookapp.presentation.listscreen.ListScreenViewModel
import com.erkindilekci.bookapp.ui.theme.myBackgroundColor
import com.erkindilekci.bookapp.ui.theme.myCardColor
import com.erkindilekci.bookapp.ui.theme.typography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(bookList: List<Book>, actions: MainActions, viewModel: ListScreenViewModel) {
    LazyColumn {
        item {
            Text(
                text = stringResource(R.string.explore_thousands_of_books),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Start,
                color = MaterialTheme.myTextColor,
                maxLines = 2,
                modifier = Modifier.padding(start = 16.dp, end = 20.dp, bottom = 16.dp)
            )
        }

        item {
            var isSearchBarActive by remember { mutableStateOf(false) }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(70.dp)
            ) {
                SearchBar(
                    query = viewModel.searchText,
                    onQueryChange = { viewModel.updateSearchText(it) },
                    onSearch = { isSearchBarActive = false },
                    active = isSearchBarActive,
                    onActiveChange = { isSearchBarActive = it },
                    placeholder = { Text(text = stringResource(R.string.search_for_books)) },
                    colors = SearchBarDefaults.colors(
                        containerColor = MaterialTheme.myCardColor
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search),
                            tint = MaterialTheme.myTextColor
                        )
                    },
                    trailingIcon = {
                        if (isSearchBarActive){
                            Icon(
                                modifier = Modifier.clickable { if (viewModel.searchText.trim().isEmpty()) isSearchBarActive = false else viewModel.updateSearchText("") },
                                imageVector = Icons.Default.Close,
                                contentDescription = stringResource(R.string.close),
                                tint = MaterialTheme.myTextColor
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {}
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }

        items(bookList.filter {
            it.title.contains(
                viewModel.searchText,
                ignoreCase = true
            )
        }) { book ->
            BookListItem(
                book = book,
                onItemClick = {
                    actions.gotoBookDetails.invoke(book.isbn)
                }
            )
        }
    }
}