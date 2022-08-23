package co.edu.umb.guide1mobileengineeringme.domain.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
  @SerializedName("token") val token: String
)
