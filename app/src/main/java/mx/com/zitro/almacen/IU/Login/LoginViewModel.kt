package mx.com.zitro.almacen.IU.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import mx.com.zitro.almacen.DataCloudLocal.DataSharedPreference
import mx.com.zitro.almacen.Network.Request.LogInRequest
import mx.com.zitro.almacen.Network.ResponseDataLogin
import mx.com.zitro.almacen.core.ConnectionRetrofit

class LoginViewModel : ViewModel() {

    suspend fun LogIn(usuario: String, password: String, context: LoginActivity): ResponseDataLogin {
        var response = CompletableDeferred<ResponseDataLogin>()

       viewModelScope.launch(Dispatchers.IO) {
            val request = LogInRequest(usuario, password)
            val autService = ConnectionRetrofit(context).getAuthService()
            val responseService = autService.login(request)
            response.complete(responseService.body()!!)
           if (responseService.body()!!.ok!!){
               DataSharedPreference(context).saveUserInfo(usuario, password, responseService.body()!!)
           }
        }
        return response.await()
    }


}