package com.example.android_mini_p1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_mini_p1.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.lightspark.composeqr.QrCodeView
import androidx.compose.ui.graphics.Color as ComposeColor

@Composable
fun PopUpQr(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(modifier = Modifier) {

            Image(
                painter = painterResource(id = R.drawable.qrbg),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
            Text(
                text = "$ 0",
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(50.dp, top = 80.dp),
                color = ComposeColor.Black,
                fontWeight = FontWeight.Bold,

                )
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.BottomCenter)
                    .padding(start = 24.dp)
            ) {
                BoringPreview()
            }

        }
    }
}


@Composable
fun BoringPreview() {
    QrCodeView(
        data = "https://pay.ababank.com/t4oF3M2KpLSixmm98", modifier = Modifier.size(200.dp)
    )
}



