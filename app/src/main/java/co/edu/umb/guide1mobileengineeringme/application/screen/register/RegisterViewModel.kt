package co.edu.umb.guide1mobileengineeringme.application.screen.register

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.umb.guide1mobileengineeringme.R
import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto
import co.edu.umb.guide1mobileengineeringme.domain.repository.RetrofitHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

  val state: MutableState<RegisterState> = mutableStateOf(RegisterState())

  fun register(
    email: String,
    fullName: String,
    password: String,
    confirmPassword: String
  ) {
    var errorMessage =
      if (email.isBlank() || fullName.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
        R.string.error_input_empty
      } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        R.string.error_not_a_valid_email
      } else if (password != confirmPassword) {
        R.string.error_incorrectly_repeated_password
      } else null

    errorMessage?.let {
      state.value = state.value.copy(errorMessage = errorMessage)
      return
    }

    viewModelScope.launch {
      state.value = state.value.copy(displayProgressBar = true)

      val response = RetrofitHelper.getAuthService().registerUser(
        UserDto(
          email = email,
          fullName = fullName,
          password = password
        )
      )
      if (response.isSuccessful){
        delay(1500L)
        state.value = state.value.copy(successRegister = true)
      } else {
        errorMessage = R.string.user_not_created
      }

      state.value = state.value.copy(displayProgressBar = false)
    }
  }

  fun hideErrorDialog() {
    state.value = state.value.copy(
      errorMessage = null
    )
  }
}