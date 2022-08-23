package co.edu.umb.guide1mobileengineeringme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import co.edu.umb.guide1mobileengineeringme.application.navigation.Routes
import co.edu.umb.guide1mobileengineeringme.application.screen.home.HomeScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.login.LoginViewModel
import co.edu.umb.guide1mobileengineeringme.application.screen.register.RegisterScreen
import co.edu.umb.guide1mobileengineeringme.application.screen.register.RegisterViewModel
import co.edu.umb.guide1mobileengineeringme.ui.theme.Guide1MobileEngineeringMETheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
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
            addHome(navController)
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
    val viewModel: LoginViewModel = hiltViewModel()
    val email = viewModel.state.value.email
    val token = viewModel.state.value.token?.token

    if (viewModel.state.value.successLogin) {
      LaunchedEffect(
        key1 = Unit
      ) {
        navController.navigate(
          Routes.Home.route + "/$email" + "/$token"
        ) {
          popUpTo(Routes.Login.route) {
            inclusive = true
          }
        }
      }
    } else {

      LoginScreen(
        state = viewModel.state.value,
        onLogin = viewModel::login,
        onNavigateToRegister = {
          navController.navigate(Routes.Register.route)
        },
        onDismissDialog = viewModel::hideErrorDialog
      )

    }
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
    val viewModel: RegisterViewModel = hiltViewModel()

    if (viewModel.state.value.successRegister) {
      LaunchedEffect(
        key1 = Unit
      ) {
        navController.navigate(
          Routes.Login.route
        )/* {
          popUpTo(Routes.Login.route) {
            inclusive = true
          }
        }*/
      }
    } else {
      RegisterScreen(
        state = viewModel.state.value,
        onRegister = viewModel::register,
        onBack = {
          navController.popBackStack()
        },
        onDismissDialog = viewModel::hideErrorDialog
      )
    }
  }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addHome(
  navController: NavController
) {
  composable(
    route = Routes.Home.route + "/{email}" + "/{token}",
    arguments = Routes.Home.arguments
  ) { backStackEntry ->

    val email = backStackEntry.arguments?.getString("email") ?: ""
    val token = backStackEntry.arguments?.getString("token") ?: ""
    HomeScreen(
      email, token, onBack = { navController.navigate(Routes.Login.route) }
    )
  }
}
