package com.example.android_mini_p1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_mini_p1.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.util.lerp // Import this for Float lerp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Information() {
    val pagerState = rememberPagerState(initialPage = 0)
    val imageSlider = listOf(
        painterResource(id = R.drawable.slider1),
        painterResource(id = R.drawable.slider2),
        painterResource(id = R.drawable.slider3)
    )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    Text(
        text = "New and Information",
        color = Color.White,
        fontSize = 15.sp, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)
    )
    Box(modifier = Modifier) {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .height(180.dp)
                .fillMaxSize()
        ) { page ->
            Card(shape = RoundedCornerShape(12.dp), modifier = Modifier.graphicsLayer {
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                val scale = lerp(0.85f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                scaleX = scale
                scaleY = scale
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            })
            {
                Image(
                    painter = imageSlider[page],
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(5.dp)
                .background(Color(0xFF616161).copy(alpha = 0.5f), shape = RoundedCornerShape(5.dp))
                .height(20.dp)
                .padding(5.dp),
            activeColor = Color.Yellow,
            inactiveColor = Color.Gray
        )
    }
}