package ru.empat1.customview.samples

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CanvasTest() {

    var points by rememberSaveable {
        mutableStateOf<List<Offset>>(value = listOf())
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .background(
                Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Magenta)
                )
            )
            .pointerInput(key1 = Unit) {
                detectDragGestures { change, dragAmount ->
                    points += change.historical.map { it.position }
                }
            }
    ) {
        drawPath(
            path = Path().apply {

                moveTo(center.x - 75.dp.toPx(), 100.dp.toPx())
                lineTo(center.x - 50.dp.toPx(), 50.dp.toPx())
                lineTo(center.x, 100.dp.toPx())

                lineTo(center.x + 50.dp.toPx(), 50.dp.toPx())
                lineTo(center.x + 75.dp.toPx(), 100.dp.toPx())


                lineTo(center.x + 70.dp.toPx(), 150.dp.toPx())
                lineTo(center.x, 200.dp.toPx())

                lineTo(center.x - 70.dp.toPx(), 150.dp.toPx())
                lineTo(center.x - 75.dp.toPx(), 100.dp.toPx())


            },
            color = Color.White,
            style = Fill
        )

        points.forEach {
            drawCircle(
                color = Color.White,
                center = it,
                radius = 8.dp.toPx()
            )
        }
    }
}