package co.edu.umb.guide1mobileengineeringme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginScreen
import co.edu.umb.guide1mobileengineeringme.ui.theme.Guide1MobileEngineeringMETheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Guide1MobileEngineeringMETheme {
        LoginScreen()
      }
    }
  }
}
