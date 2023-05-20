package com.erkindilekci.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.erkindilekci.bookapp.presentation.util.ComposeNavigation
import com.erkindilekci.bookapp.ui.theme.BookAppTheme
import com.erkindilekci.bookapp.ui.theme.myBackgroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAppTheme {
                Surface(color = MaterialTheme.myBackgroundColor) {
                    ComposeNavigation()
                }
            }
        }
    }
}