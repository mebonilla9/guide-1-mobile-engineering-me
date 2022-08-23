package co.edu.umb.guide1mobileengineeringme.domain.repository

import co.edu.umb.guide1mobileengineeringme.domain.dto.TokenDto
import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

  @POST("auth/login")
  suspend fun loginUser(@Body userDto: UserDto): Response<TokenDto>

  @POST("auth/register")
  suspend fun registerUser(@Body userDto: UserDto): Response<Unit>
}