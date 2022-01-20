package com.andro.ui_common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ArtistCard() {
    /**
     * Элементы внитри располагаются вертикально
     */
    Column {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}