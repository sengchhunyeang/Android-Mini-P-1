package com.example.android_mini_p1.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_mini_p1.R


//create data class store data (mockup data )
data class MyImage(
    val imageId: Int,
    val text: String,
    val text2: String
)

val myFacture = listOf(
    MyImage(imageId = R.drawable.ic_acc, text = "Account", text2 = "Your Balance"),
    MyImage(imageId = R.drawable.ic_bills, text = "Pay bills", text2 = "School, Shop, etc"),
    MyImage(imageId = R.drawable.ic_transfer, text = "Transfer", text2 = "Send money"),
    MyImage(imageId = R.drawable.ic_fav, text = "Favorites", text2 = "Users"),
    MyImage(imageId = R.drawable.ic_scan, text = "BAB Scan", text2 = "School, Shop, etc"),
    MyImage(imageId = R.drawable.ic_service, text = "Service", text2 = "Your balance"),
)

@Composable
fun MyAccounts() {
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
                .size(width = 380.dp, height = 220.dp)
                .padding(3.dp)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))

        ) {


            // Map data to MyImage objects
            Column {
                val itemsPerRow = 3
                val myItemChunks = myFacture.chunked(itemsPerRow)
                myItemChunks.forEach { myItems ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        myItems.forEachIndexed {index, item ->
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .height(90.dp)
                                    .background(Color.White, RoundedCornerShape(16.dp))
                                    .weight(1f)
                                    .clip(RoundedCornerShape(16.dp))
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)

                                ) {
                                    Image(
                                        painter = painterResource(id = item.imageId),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(20.dp)
                                            .align(Alignment.End)
                                            .let { modifier ->
                                                if (index== 1){
                                                    modifier.shadow(
                                                        elevation = 8.dp,
                                                        shape = RoundedCornerShape(16.dp)
                                                    )
                                                } else
                                                    modifier
                                            }
                                    )
                                    Text(text = item.text, fontSize = 16.sp, color = Color.Black)
                                    Text(text = item.text2, fontSize = 10.sp, color = Color.Black)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



