package com.andro.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.andro.domain.CountryModel


@ExperimentalCoilApi
@Composable
fun CountryList(list: List<CountryModel>, onSelectionChange: (CountryModel) -> Unit) {
    LazyColumn {
        for (countryModel in list) {
            item {
                CountryCell(countryModel, onSelectionChange)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CountryCell(countryModel: CountryModel, onSelectionChange: (CountryModel) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { onSelectionChange(countryModel) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start

    ) {
        Image(
            painter = rememberImagePainter(
                data = countryModel.countryIcon,
                builder = {
                    crossfade(true)
                    placeholder(android.R.drawable.ic_menu_compass)
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(48.dp)
                .height(48.dp)

        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = countryModel.countryName)
    }
}
