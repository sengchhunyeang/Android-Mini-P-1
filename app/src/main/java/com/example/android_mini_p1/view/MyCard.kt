package com.example.android_mini_p1.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.example.android_mini_p1.R

@Composable
fun MyViewApp() {
    var textVisit by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val borderWith = 4.dp.toPx()
            val cornerRadius = 16.dp.toPx()
            val borderReactSize = size.copy(
                width = size.width - borderWith,
                height = size.height - borderWith
            )
            // Draw the gradient border
            drawRoundRect(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xD0FF2D7C), Color.Blue),
                    start = Offset.Zero,
                    end = Offset(size.width, size.height)
                ),
                size = size,
                cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                style = Fill
            )
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Transparent, Color.Transparent),
                    start = Offset.Zero,
                    end = Offset(size.width, size.height)
                ),
                size = borderReactSize, topLeft = Offset(borderWith / 2, borderWith / 2)
            )
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0054A6)//0xFF003C6C ,0xFF003E7D 0xFF0054A6||FF2D7C||D027B5||B623D5||941FFF
            ), modifier = Modifier
                .size(width = 380.dp, height = 140.dp)
                .padding(3.dp)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))

        ) {
            Row(
                modifier = Modifier.padding(top = 3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (textVisit) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(width = 65.dp, height = 30.dp)
                            .background(
                                Color.LightGray, shape = RoundedCornerShape(5.dp)
                            )
                    )
                } else {
                    Text(
                        text = "$20.00",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Box(
                    modifier = Modifier
                        .background(Color(0x2D00C2FF), shape = RoundedCornerShape(5.dp))
                        .padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bx_show),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { textVisit = !textVisit }
                    )

                }

            }
            Row() {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .background(Color(0xFF34C2FF), shape = RoundedCornerShape(5.dp))
                ) {
                    Row() {
                        Text(
                            text = "Default",
                            color = Color.White, fontSize = 10.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
                Box(modifier = Modifier.padding()) {
                    Text(
                        text = "Saving",
                        color = Color.White, fontSize = 10.sp,
                        modifier = Modifier.padding(5.dp)
                    )

                }

            }
            Spacer(modifier = Modifier.padding(top = 38.dp))
            Row(modifier = Modifier.padding(start = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_receive),
                    contentDescription = null, modifier = Modifier.size(15.dp)
                )
                Text(
                    text = "Receive money",
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )
                Spacer(modifier = Modifier.padding(start = 30.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_pay),
                    contentDescription = null, modifier = Modifier.size(15.dp)
                )
                Text(
                    text = "Send Money",
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

            }
        }

    }
}


