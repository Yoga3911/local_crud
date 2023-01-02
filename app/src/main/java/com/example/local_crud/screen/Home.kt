package com.example.local_crud.screen

import android.text.Layout.Alignment
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.local_crud.Navigation.Route
import com.example.local_crud.component.MyCard
import com.example.local_crud.ui.theme.DarkColorPalette
import com.example.local_crud.ui.theme.LightColorPalette
import com.example.local_crud.ui.theme.Purple200
import com.example.local_crud.ui.theme.Purple500

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    val isDelete = remember {
        mutableStateOf<Boolean>(false)
    }

    val isDarkModel = remember {
        mutableStateOf<Boolean>(false)
    }

    MaterialTheme(
        colors = if (isDarkModel.value) DarkColorPalette else LightColorPalette
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Local CRUD")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            Toast.makeText(context, "Ini Menu", Toast.LENGTH_LONG).show()
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "more", tint = Color.White)
                        }
                    },
                    actions = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(Icons.Rounded.MoreVert, contentDescription = "more", tint = Color.White)
//                    }
                        Switch(
                            checked = isDarkModel.value,
                            onCheckedChange =  {
                                isDarkModel.value = it
                            },
                            colors = SwitchDefaults.colors(checkedThumbColor = Color.Black)
                        )
                    },
                    elevation = 5.dp,
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navController.navigate(Route.Add.screen)
                }, backgroundColor = Purple500) {
                    Icon(Icons.Rounded.Add, contentDescription = "Add")
                }
            }) {

            LazyColumn(content = {
                items(5) {
                    MyCard(
                        title = "Mantap",
                        height = 75.dp,
                        onClick = {
                            println("Mantap")
                        },
                        deleteClick = {
                            isDelete.value = true
                        }
                    )
                }
            })

            if (isDelete.value) AlertDialog(onDismissRequest = { /*TODO*/ },
                text = {
                    Text(text = "Are you sure delete this item?")
                }, title = {
                    Text(text = "Warning!")
                },
                dismissButton = {
                    OutlinedButton(
                        onClick = {
                            isDelete.value = false
                        },
                        content = {
                            Text("Cancel")
                        }
                    )
                },
                confirmButton = {
                    OutlinedButton(
                        onClick = {},
                        content = {
                            Text("Ok")
                        },
                    )
                }
            )
        }
    }
}