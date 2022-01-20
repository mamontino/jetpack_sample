package com.andro.ui_common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.size(140.dp, 140.dp),

    )
}

@Preview
@Composable
fun ComplexComposeContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Greeting(name = "Ээээээээ")
        Spacer(modifier = Modifier.height(16.dp))
        Image(painterResource(id = R.drawable.ic_android), "atom", modifier = Modifier.wrapContentHeight())
        Greeting(name = "Ээээээээ")
        Text(text = stringResource(id = R.string.app_name))
        Greeting(name = "Ээээээээ")
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Greeting(name = "Ээээээээ")
        }
    }
}