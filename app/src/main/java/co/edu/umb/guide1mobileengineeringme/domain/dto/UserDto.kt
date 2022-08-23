package co.edu.umb.guide1mobileengineeringme.domain.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
  @SerializedName("id") val id: Int? = null,
  @SerializedName("fullName") val fullName: String? = null,
  @SerializedName("email") val email: String? = null,
  @SerializedName("password") val password: String? = null,
  @SerializedName("active") val active: Boolean? = null
)
