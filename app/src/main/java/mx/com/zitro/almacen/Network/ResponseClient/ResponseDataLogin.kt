package mx.com.zitro.almacen.Network

import com.google.gson.annotations.SerializedName

data class ResponseDataLogin(
    @SerializedName("ok") var ok: Boolean?,
    @SerializedName("msg") var msg: ArrayList<Msg> = arrayListOf(),
)


data class Msg(

    @SerializedName("usuID") val usuID: String? = null,
    @SerializedName("usu") var usu: String? = null,
    @SerializedName("dep") var dep: String? = null,
    @SerializedName("IdSubcentro") var IdSubcentro: String? = null,
    @SerializedName("subcentro") var subcentro: String? = null,
    @SerializedName("tipoAcceso") var tipoAcceso: String? = null,
    @SerializedName("sesion") var sesion: String? = null,
    @SerializedName("tipoUsuario") var tipoUsuario: String? = null,
    @SerializedName("error") var error: String? = null

)
