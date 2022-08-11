package co.edu.umb.guide1mobileengineeringme.domain.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
  @SerializedName("email") val email: String,
  @SerializedName("password") val password: String,
)
