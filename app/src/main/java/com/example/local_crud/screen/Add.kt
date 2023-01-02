package com.example.local_crud.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.local_crud.Navigation.Route

@Composable
fun AddScreen(
    navController: NavController
) {
    val nameVal = remember {
        mutableStateOf(TextFieldValue(""))
    }

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Data")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Route.Home.screen) {
                            popUpTo(Route.Home.screen) {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Arrow Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nameVal.value,
                onValueChange = {
                    nameVal.value = it
                },
                label = {
                    Text("Name")
                },
                modifier = Modifier.fillMaxWidth(),

            )
            Button(onClick = {
                if (nameVal.value.text == "") Toast.makeText(context, "Name cant be empty", Toast.LENGTH_LONG).show()
                focusManager.clearFocus()
            }) {
                Text("Save")
            }
        }
    }
}