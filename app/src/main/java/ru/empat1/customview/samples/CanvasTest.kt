package ru.empat1.customview.samples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun CanvasTest(){
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        drawCircle(
            Color.White,
            radius = 50.dp.toPx(),
            center = Offset(50.dp.toPx(), 50.dp.toPx()),
            style = Stroke(width = 1.dp.toPx())
        )

        drawLine(
            color = Color.White,
            start = Offset(100.dp.toPx(), 100.dp.toPx()),
            end = Offset(120.dp.toPx(), 0f )
        )

        drawLine(
            color = Color.White,
            start = Offset(120.dp.toPx(), 0f),
            end = Offset(140.dp.toPx(), 100.dp.toPx() )
        )
    }
}