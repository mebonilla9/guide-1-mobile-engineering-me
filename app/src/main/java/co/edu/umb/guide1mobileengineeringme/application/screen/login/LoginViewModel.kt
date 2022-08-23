package co.edu.umb.guide1mobileengineeringme.application.screen.login

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.umb.guide1mobileengineeringme.R
import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto
import co.edu.umb.guide1mobileengineeringme.domain.repository.RetrofitHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

  val state: MutableState<LoginState> = mutableStateOf(LoginState())
  private val loginRequestLiveData = MutableLiveData<Boolean>()

  fun login(email: String, password: String) {
    val errorMessage = if (email.isBlank() || password.isBlank()) {
      R.string.error_input_empty
    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
      R.string.error_not_a_valid_email
    } else null

    errorMessage?.let {
      state.value = state.value.copy(errorMessage = it)
    }

    viewModelScope.launch {
      state.value = state.value.copy(displayProgressBar = true)
      state.value = state.value.copy(email = email, password = password)

      val response = RetrofitHelper.getAuthService().loginUser(
        UserDto(
          email = state.value.email,
          password = state.value.password
        )
      )

      if (response.isSuccessful) {
        delay(1500L)
        response.body()?.let { tokenDto ->
          {
            Log.d("LoginViewModel", tokenDto.token)
            loginRequestLiveData.postValue(response.isSuccessful)

          }
        }
      }
      state.value = state.value.copy(token = response.body())
      state.value = state.value.copy(successLogin = true)

    }
  }

  fun hideErrorDialog() {
    state.value = state.value.copy(errorMessage = null)
  }
}