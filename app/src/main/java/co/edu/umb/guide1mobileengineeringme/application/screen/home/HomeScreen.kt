package co.edu.umb.guide1mobileengineeringme.application.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginViewModel

@Composable
fun HomeScreen(
  email: String,
  token: String,
  onBack: () -> Unit,
) {

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Home Screen",
      style = MaterialTheme.typography.h3
    )

    Text(
      text = "Email: $email",
      style = MaterialTheme.typography.h5.copy(
        color = MaterialTheme.colors.primary
      )
    )

    Text(
      text = "JWT Token: $token",
      style = MaterialTheme.typography.body1.copy(
        color = MaterialTheme.colors.primary
      )
    )

    FloatingActionButton(
      modifier = Modifier
        .size(72.dp),
      backgroundColor = MaterialTheme.colors.primary,
      onClick = {
        onBack()
      }
    ) {
      Icon(
        modifier = Modifier.size(42.dp),
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Forward Icon",
        tint = Color.White
      )
    }
  }
}

@Composable
@Preview
fun PreviewHome() {
  HomeScreen(
    email = "mail@mail.com",
    token = "Bearer ebgnioqauefbnvlaiefdb",
    onBack = {}
  )
}