package co.edu.umb.guide1mobileengineeringme

import Guide1MobileEngineeringMETheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Guide1MobileEngineeringMETheme() {

      }
    }
  }
}
