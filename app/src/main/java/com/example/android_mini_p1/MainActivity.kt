package com.example.android_mini_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_mini_p1.ui.theme.Androidminip1Theme
import com.example.android_mini_p1.view.MyAccounts
import com.example.android_mini_p1.view.MyViewApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBackApp()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBackApp() {

    Column {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF00468B),
                    ),
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chhunyeang),
                                contentDescription = "MyImage",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(BorderStroke(2.dp, Color.White), shape = CircleShape)

                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = "Hello, Chhunyeang !",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                                Text(text = "View Profile !", color = Color.White, fontSize = 12.sp)

                            }
                            Spacer(modifier = Modifier.width(140.dp))

                            Image(
                                painter = painterResource(id = R.drawable.ic_notification),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_bk),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .background(Color(0xFF00468B))
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier.padding(innerPadding)) {
                    // Add other UI elements here
                    MyViewApp()

                    MyAccounts()
                }
            }
        }
    }

}