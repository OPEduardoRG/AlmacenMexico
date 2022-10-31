package mx.com.zitro.almacen.Network.Request

import com.google.gson.annotations.SerializedName

class LogInRequest(
    @SerializedName("user") val user: String,
    @SerializedName("pass") val pass: String
)