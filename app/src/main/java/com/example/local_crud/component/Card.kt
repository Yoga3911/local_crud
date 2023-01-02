package com.example.local_crud.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(
    title: String,
    height: Dp,
    onClick: () -> Unit,
    deleteClick: () -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .padding(10.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.LightGray)
        .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            content = {
            Text(
                title,
                textAlign = TextAlign.Start
            )
            IconButton(
                onClick = deleteClick,
                content = {
                    Icon(
                        Icons.Rounded.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red,
                    )
                },
            )
        })
    }
}