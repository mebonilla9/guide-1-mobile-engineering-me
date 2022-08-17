package co.edu.umb.guide1mobileengineeringme.application.navigation

import androidx.navigation.compose.NamedNavArgument

sealed class Routes(
  val route: String,
  val arguments: List<NamedNavArgument>
) {

  object Login : Routes("login", emptyList())
  object Register : Routes("register", emptyList())
  object Home : Routes("home", emptyList())

}