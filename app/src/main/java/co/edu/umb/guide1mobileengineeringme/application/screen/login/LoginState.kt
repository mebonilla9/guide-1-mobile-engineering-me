package co.edu.umb.guide1mobileengineeringme.application.screen.login

import androidx.annotation.StringRes
import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto

data class LoginState(
  val email: String = "",
  val password: String = "",
  val successLogin: Boolean = false,
  val displayProgressBar: Boolean = false,
  @StringRes val errorMessage: Int? = null
)
