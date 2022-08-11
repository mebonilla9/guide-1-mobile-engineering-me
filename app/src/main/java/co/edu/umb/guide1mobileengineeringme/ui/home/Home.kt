package co.edu.umb.guide1mobileengineeringme.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.edu.umb.guide1mobileengineeringme.R

@Composable
fun Home() {
  val colorBackground = listOf<Color>(
    Color(238, 113, 0, 255),
    Color(101, 0, 126, 255),
    Color(0, 47, 187)
  )

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(
        Brush.verticalGradient(
          colors = colorBackground
        )
      ),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(
        id = R.drawable.ic_home_welcome
      ), contentDescription = "Icon home",
      modifier = Modifier.size(400.dp)
    )
  }
}