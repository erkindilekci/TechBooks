package com.erkindilekci.bookapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val CardColorLight = Color(0xFFFFFFFF)
val BackgroundColorLight = Color(0xFFF3F7F9)
val PrimaryColorLight = Color(0xFF006AF6)
val TextColorLight = Color(0xFF000000)

val CardColorDark = Color(0xFF0A1A3A)
val BackgroundColorDark = Color(0xFF051024)
val PrimaryColorDark = Color(0xFF0D9BFF)
val TextColorDark = Color(0xFFFFFFFF)

val MaterialTheme.myCardColor: Color
@Composable
get() = if (isSystemInDarkTheme()) CardColorDark else CardColorLight

val MaterialTheme.myBackgroundColor: Color
@Composable
get() = if (isSystemInDarkTheme()) BackgroundColorDark else BackgroundColorLight

val MaterialTheme.myPrimaryColor: Color
@Composable
get() = if (isSystemInDarkTheme()) PrimaryColorDark else PrimaryColorLight

val MaterialTheme.myTextColor: Color
@Composable
get() = if (isSystemInDarkTheme()) TextColorDark else TextColorLight