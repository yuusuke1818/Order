package com.example.order

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.order.ui.theme.OrderTheme

@Composable
fun OrderView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .selectableGroup()
    ) {
        Text("注文画面")
        var h by remember { mutableStateOf("ハンバーガー") }
        Column {
            Row(
                modifier = Modifier.selectable(
                    selected = h == "ハンバーガー",
                    onClick = { h = "ハンバーガー" },
                    role = Role.RadioButton
                )
            ) {
                RadioButton(
                    selected = h == "ハンバーガー",
//                    onClick = { h = "ハンバーガー" },
                    onClick = null
                )
                Text("ハンバーガー")
            }
            Row(
                modifier = Modifier.selectable(
                    selected = h == "チーズバーガー",
                    onClick = { h = "チーズバーガー" },
                    role = Role.RadioButton
                )
            ) {
                RadioButton(
                    selected = h == "チーズバーガー",
//                    onClick = { "チーズバーガー".also { h = it } }
                    onClick = null
                )
                Text("チーズバーガー")
            }
        }

        HorizontalDivider()
        Text("サイドメニューを選択してください。")
        var frenchFry by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.toggleable(
                value = frenchFry,
                onValueChange = { frenchFry = !frenchFry },
                role = Role.Checkbox
            )
        )
        {
            Checkbox(
                checked = frenchFry,
                onCheckedChange = null
            )
            Text("フレンチフライ")
        }
        var salad by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.toggleable(
                value = salad,
                onValueChange = { salad = !salad },
                role = Role.Checkbox
            )
        )
        {
            Checkbox(
                checked = salad,
                onCheckedChange = null
            )
            Text("サラダ")
        }
        var chicken_nugget by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.toggleable(
                value = chicken_nugget,
                onValueChange = { chicken_nugget = !chicken_nugget },
                role = Role.Checkbox
            )
        )
        {
            Checkbox(
                checked = chicken_nugget,
                onCheckedChange = null
            )
            Text("チキンナゲット")
        }

        HorizontalDivider()
        Text("ソースの量を調整できます。")
        var sliderPosition by remember { mutableStateOf(0f) }
        Text(sliderPosition.toString())
        Text(
            text = when {
                sliderPosition < 0.3f -> "少なめ"
                sliderPosition > 0.7f -> "多め"
                else -> "普通"
            }
        )
//        if (sliderPosition <= 0.3) {
//            Text("少なめ")
//        } else if (0.8 <= sliderPosition) {
//            Text("多め")
//        } else {
//            Text("普通")
//        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )

        HorizontalDivider()
        Text("ドリンクを選択してください。")
        var expanded by remember { mutableStateOf(false) }
        var drink by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart)
        ) {
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .clickable { expanded = true }
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(4.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(drink.toString())
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "dropdown"
                )
            }
            DropdownMenu(expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        drink = "コーラ"
                        expanded = false
                    },
                    text = { Text("コーラ") }
                )
                DropdownMenuItem(
                    onClick = {
                        drink = "カルピス"
                        expanded = false
                    },
                    text = { Text("カルピス") }
                )
                DropdownMenuItem(
                    onClick = {
                        drink = "ジンジャエール"
                        expanded = false
                    },
                    text = { Text("ジンジャエール") }
                )
                DropdownMenuItem(
                    onClick = {
                        drink = "アイスカフェラテ"
                        expanded = false
                    },
                    text = { Text("アイスカフェラテ") }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun OrderViewPreview() {
    OrderTheme {
        OrderView()
    }

}