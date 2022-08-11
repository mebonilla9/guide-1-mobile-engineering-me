package co.edu.umb.guide1mobileengineeringme.application.service

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto
import co.edu.umb.guide1mobileengineeringme.domain.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

  val isSuccessLoading = mutableStateOf(value = false)
  val imageErrorAuth = mutableStateOf(value = false)
  val progressBar = mutableStateOf(value = false)
  private val loginRequestLiveData = MutableLiveData<Boolean>()

  fun login(email: String, password: String) {
    viewModelScope.launch(Dispatchers.IO) {
      try {
        progressBar.value = true
        val userService = RetrofitHelper.getUserService()
        val responseService = userService.loginUser(UserDto(email = email, password = password))
        progressBar.value = false
        if (responseService.isSuccessful) {
          delay(1500L)
          isSuccessLoading.value = true
          responseService.body()?.let { any ->
            Log.d("User Logging", "Response Any $any")
          }
          loginRequestLiveData.postValue(responseService.isSuccessful)
          return@launch
        }
        responseService.errorBody()?.let { error ->
          imageErrorAuth.value = true
          delay(1500L)
          imageErrorAuth.value = false
          error.close()
        }
      } catch (e: Exception) {
        Log.d("Logging", "Error Authentication", e)
        progressBar.value = false
      }
    }
  }

}