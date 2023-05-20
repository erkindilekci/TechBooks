package com.erkindilekci.bookapp.presentation.util

import androidx.annotation.StringRes

sealed class Screen(val route: String) {
    object ListScreen: Screen("notes_screen")
    object DetailScreen: Screen("add_edit_note_screen")
}