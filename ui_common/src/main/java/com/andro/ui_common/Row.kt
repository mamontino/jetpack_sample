package com.andro.ui_common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

/**
 * Элементы внитри располагаются горизонтально
 */
@Composable
fun ArtistCard(artist: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(artist)
        Column {
            Text(artist)
            Text(artist)
        }
    }
}