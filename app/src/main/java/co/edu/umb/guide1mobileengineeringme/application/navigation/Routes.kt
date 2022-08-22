package co.edu.umb.guide1mobileengineeringme.application.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument

sealed class Routes(
  val route: String,
  val arguments: List<NamedNavArgument>
) {

  object Login : Routes("login", emptyList())
  object Register : Routes("register", emptyList())
  object Home : Routes(
    "home",
    listOf(
      navArgument("email") { type = NavType.StringType },
      navArgument("password") { type = NavType.StringType }
    )
  )

}