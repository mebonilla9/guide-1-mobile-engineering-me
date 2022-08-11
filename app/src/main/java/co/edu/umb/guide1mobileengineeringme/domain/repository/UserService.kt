package co.edu.umb.guide1mobileengineeringme.domain.repository

import co.edu.umb.guide1mobileengineeringme.domain.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

  @POST("users/login")
  suspend fun loginUser(@Body userDto: UserDto): Response<Any>

}