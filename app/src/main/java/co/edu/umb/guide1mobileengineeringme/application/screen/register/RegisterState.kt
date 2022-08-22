package co.edu.umb.guide1mobileengineeringme.application.screen.register

import androidx.annotation.StringRes

data class RegisterState(
  val successRegister: Boolean = false,
  val displayProgressBar: Boolean = false,
  @StringRes val errorMessage: Int? = null
){

}