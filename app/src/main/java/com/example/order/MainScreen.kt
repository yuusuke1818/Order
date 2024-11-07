package com.example.order

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var isOrderView by remember { mutableStateOf(false) }
    if (isOrderView) {
        OrderView()
    } else {
        TopView(onTapButton = { isOrderView = true })
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}