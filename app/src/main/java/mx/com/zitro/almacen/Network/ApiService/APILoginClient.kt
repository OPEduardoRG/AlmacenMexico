package mx.com.zitro.almacen.Network.ApiService


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.zitro.almacen.Network.Request.LogInRequest
import mx.com.zitro.almacen.Network.ResponseDataLogin
import mx.com.zitro.almacen.Utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APILoginClient {
    @POST(Constants.API_LOGIN)
    suspend fun login(@Body body: LogInRequest): Response<ResponseDataLogin>
}