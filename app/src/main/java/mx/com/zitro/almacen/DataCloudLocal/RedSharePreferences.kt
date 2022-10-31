package mx.com.zitro.almacen.DataCloudLocal

import android.content.Context
import android.content.SharedPreferences
import mx.com.zitro.almacen.IU.Login.SettingsDialog
import mx.com.zitro.almacen.Network.ResponseDataLogin

class RedSharePreferences(context: Context){
    private val PREFSH = "ConexionRed"
    val sharedPref : SharedPreferences = context!!.getSharedPreferences(PREFSH, Context.MODE_PRIVATE)
    val editor : SharedPreferences.Editor = sharedPref.edit()

    val PREF_RED_IP = "redIP"

    fun saveInfoRed(IPConexion: String){
        editor.putString(PREF_RED_IP, IPConexion)
        editor.commit()
    }

    fun getRedURL(): String? {return sharedPref.getString(PREF_RED_IP,"")}
}