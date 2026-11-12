package com.zonnon.project220_2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}


@Composable
fun BottomNavigationBar() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
        containerColor = colorResource(id = R.color.black3),
        contentColor = colorResource(id = R.color.white),
        tonalElevation = 3.dp,
        modifier = Modifier.background(color = colorResource(id = R.color.black3)),

    ) {
        bottomMenuItemsList.forEachIndexed { index, item ->
            if (index == 2) {
                BottomNavigationItem(
                    selected = false, onClick = {}, icon = {}, enabled = false
                )
            }
            BottomNavigationItem(
                selected = item.label == selectedItem,
                onClick = {
                    selectedItem = item.label
                    Toast.makeText(contextForToast, item.label, Toast.LENGTH_SHORT).show()
                }, icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                }, label = {
                    Text(
                        text = item.label, modifier = Modifier.padding(top = 14.dp)
                    )
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }
    }
}

data class BottomMenuItem(
    val label: String, val icon: Painter
)

@Composable
private fun prepareBottomMenu(): List<BottomMenuItem> {
    return listOf(
        BottomMenuItem(
            label = "Home", icon = painterResource(id = R.drawable.btn_1)
        ),
        BottomMenuItem(
            label = "Profile", icon = painterResource(id = R.drawable.btn_2)
        ),
        BottomMenuItem(
            label = "Support", icon = painterResource(id = R.drawable.btn_3)
        ),
        BottomMenuItem(
            label = "Settings", icon = painterResource(id = R.drawable.btn_4)
        ),
    )
}