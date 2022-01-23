package com.andro.jetpack_sample.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andro.domain.CountryModel
import com.andro.home.CountryList
import com.andro.jetpack_sample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                TopAppBar(
                    title = {
                        Text(text = getString(R.string.app_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Menu Btn")
                        }
                    },
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Gray,
                    elevation = 2.dp
                )

                CountryList(
                    list = viewModel.countryList,
                    onSelectionChange = {})
            }

        }
    }

    @Composable
    fun TextInput() {

        val inputvalue = remember { mutableStateOf(TextFieldValue()) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
//            TextField(
//                value = inputvalue.value,
//                onValueChange = { txt -> inputvalue.value = it },
//                placeholder = { Text(text = "Enter user name") },
//                modifier = Modifier.padding(all = 16.dp).fillMaxWidth(),
//                keyboardOptions = KeyboardOptions(
//                    capitalization = KeyboardCapitalization.None,
//                    autoCorrect = true,
//                    keyboardType = KeyboardType.Text,
//                ),
//                textStyle = TextStyle(
//                    color = Color.Black,
//                    fontSize = 15.sp,
//                    fontFamily = FontFamily.SansSerif
//                ),
//                maxLines = 2,
//                activeColor = colorResource(id = R.color.purple_200),
//                singleLine = true,
//                inactiveColor = Color.Gray,
//                backgroundColor = Color.LightGray,
//                leadingIcon = {
//                    Icon(Icons.Filled.AccountCircle, tint = colorResource(id = R.color.purple_200))
//                },
//                trailingIcon = {
//                    Icon(Icons.Filled.Info, tint = colorResource(id = R.color.purple_200))
//                },
//            )
        }
    }
}

