package co.edu.umb.guide1mobileengineeringme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import co.edu.umb.guide1mobileengineeringme.application.navigation.Routes
import co.edu.umb.guide1mobileengineeringme.application.screen.home.HomeScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.register.RegisterScreen
import co.edu.umb.guide1mobileengineeringme.ui.theme.Guide1MobileEngineeringMETheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Guide1MobileEngineeringMETheme {
        val navController = rememberAnimatedNavController()

        BoxWithConstraints {
          AnimatedNavHost(
            navController = navController,
            startDestination = Routes.Login.route
          ) {
            addLogin(navController)
            addRegister(navController)
            addHome()
          }
        }
      }
    }
  }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addLogin(
  navController: NavController
) {
  composable(
    route = Routes.Login.route,
    enterTransition = { _, _ ->
      slideInHorizontally(
        initialOffsetX = { 1000 },
        animationSpec = tween(500)
      )
    },
    exitTransition = { _, _ ->
      slideOutHorizontally(
        targetOffsetX = { -1000 },
        animationSpec = tween(500)
      )
    },
    popEnterTransition = { _, _ ->
      slideInHorizontally(
        initialOffsetX = { -1000 },
        animationSpec = tween(500)
      )
    },
    popExitTransition = { _, _ ->
      slideOutHorizontally(
        targetOffsetX = { 1000 },
        animationSpec = tween(500)
      )
    }
  ) {
    LoginScreen()
  }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addRegister(
  navController: NavController
) {
  composable(
    route = Routes.Register.route,
    enterTransition = { _, _ ->
      slideInHorizontally(
        initialOffsetX = { 1000 },
        animationSpec = tween(500)
      )
    },
    exitTransition = { _, _ ->
      slideOutHorizontally(
        targetOffsetX = { -1000 },
        animationSpec = tween(500)
      )
    },
    popEnterTransition = { _, _ ->
      slideInHorizontally(
        initialOffsetX = { -1000 },
        animationSpec = tween(500)
      )
    },
    popExitTransition = { _, _ ->
      slideOutHorizontally(
        targetOffsetX = { 1000 },
        animationSpec = tween(500)
      )
    }
  ) {
    RegisterScreen()
  }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome() {
  composable(
    route = Routes.Register.route,
  ) {
    HomeScreen()
  }
}
