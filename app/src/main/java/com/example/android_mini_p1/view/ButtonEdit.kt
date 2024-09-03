package com.example.android_mini_p1.view

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.android_mini_p1.R

data class StoreIamge(
    val imageId: Int
)

val myImage = listOf(
    StoreIamge(imageId = R.drawable.myui),
    StoreIamge(imageId = R.drawable.myui),
    StoreIamge(imageId = R.drawable.myui),
    StoreIamge(imageId = R.drawable.myui)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonEdit() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedButton by remember {
        mutableStateOf<String?>("Themes")
    }
    Scaffold(floatingActionButton = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { showBottomSheet = true },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color.Black
                )
            ) {
                Text(text = "Edit Home")
            }
        }
    }) { contentPadding ->
        // Box to set the background color for the entire Scaffold content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF00468B))
                .padding(contentPadding) // Apply content padding
        ) {
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    }, sheetState = sheetState
                ) {
                    // Sheet content
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth() // Ensure the box takes up the full width
                                .height(400.dp)
                        ) {
                            Box(modifier = Modifier.padding(15.dp)) {
                                Text(
                                    text = "Appearance",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )

                                Row(modifier = Modifier.padding(top = 35.dp)) {
                                    Button(
                                        onClick = { selectedButton = "Themes" },
                                        enabled = showBottomSheet,
                                        modifier = Modifier,
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (selectedButton == "Themes") Color(
                                                0xFFCBE5FF
                                            ) else Color(0xFFA0A0A0)

                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text(
                                            text = "Themes",
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Button(
                                        onClick = { selectedButton = "Dark Mode" },
                                        modifier = Modifier,
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (selectedButton == "Dark Mode") Color(
                                                0xFFCBE5FF
                                            ) else Color(0xFFA0A0A0)

                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text(
                                            text = "Dark Mode",
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Button(
                                        onClick = { selectedButton = "Language" },
                                        modifier = Modifier,
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (selectedButton == "Language") Color(
                                                0xFFCBE5FF
                                            ) else Color(0xFFA0A0A0)

                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text(
                                            text = "Language",
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold
                                        )

                                    }
                                }

                                Box(modifier = Modifier.padding(end = 6.dp)) {
                                    Row(
                                        modifier = Modifier.padding(top = 100.dp)
                                    ) {
                                        myImage.forEach { image ->
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .padding(5.dp)
                                                    .clip(RoundedCornerShape(15.dp))
                                                    .background(Color.White),
                                                contentAlignment = Alignment.Center

                                            ) {
                                                Image(
                                                    painter = painterResource(id = image.imageId),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(160.dp)
                                                        .clip(RoundedCornerShape(40.dp))
                                                        .background(Color.White)
                                                        .padding(10.dp),

                                                    )
                                            }

                                        }
                                    }
                                }

                            }
                            Button(
                                onClick = {
                                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                                        if (!sheetState.isVisible) {
                                            showBottomSheet = false
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF00468B)
                                )
                            ) {
                                Text(text = "Save")
                            }
                        }
                    }
                }
            }
        }
    }
}
