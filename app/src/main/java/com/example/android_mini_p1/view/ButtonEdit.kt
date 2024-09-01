package com.example.android_mini_p1.view

import androidx.compose.foundation.background
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
import androidx.compose.material3.ExtendedFloatingActionButton
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
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonEdit() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedButton by remember {
        mutableStateOf<String?>(null)
    }
    Scaffold(
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), // Adjust padding as needed
                contentAlignment = Alignment.Center // Center the FAB horizontally
            ) {
                ExtendedFloatingActionButton(
                    text = { Text("Edit Home") },
                    icon = { },
                    onClick = {
                        showBottomSheet = true
                    },
                    containerColor = Color.White,
                    contentColor = Color.Black, modifier = Modifier.size(200.dp, 200.dp)
                )
            }
        }
    ) { contentPadding ->
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
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
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
                                    modifier = Modifier, colors = ButtonDefaults.buttonColors(
                                        containerColor = if (selectedButton == "Themes") Color(
                                            0xFFCBE5FF
                                        ) else Color(0xFFA0A0A0)

                                    ), shape = RoundedCornerShape(10.dp)
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
                                    modifier = Modifier, colors = ButtonDefaults.buttonColors(
                                        containerColor = if (selectedButton == "Dark Mode") Color(
                                            0xFFCBE5FF
                                        ) else Color(0xFFA0A0A0)

                                    ), shape = RoundedCornerShape(10.dp)
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
                                    modifier = Modifier, colors = ButtonDefaults.buttonColors(
                                        containerColor = if (selectedButton == "Language") Color(
                                            0xFFCBE5FF
                                        ) else Color(0xFFA0A0A0)

                                    ), shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = "Language",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    )
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
                                .padding(15.dp), colors = ButtonDefaults.buttonColors(
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