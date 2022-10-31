package mx.com.zitro.almacen.DataCloudLocal

import android.content.Context
import android.content.SharedPreferences
import mx.com.zitro.almacen.Network.ResponseDataLogin

class DataSharedPreference(context: Context) {
    private val PREFSH = "AlamcenMexico"
    val sharedPref : SharedPreferences = context!!.getSharedPreferences(PREFSH, Context.MODE_PRIVATE)
    val editor : SharedPreferences.Editor = sharedPref.edit()

    val PREF_LOGIN_INICIO = "login_inicio_share"
    val PREF_LOGIN_USER =   "login_user_share"
    val PREF_LOGIN_PASS =   "login_pass_share"

    /** SAVE INFOLOGIN **/

    val PREF_USUID = "usuID"
    val PREF_USU = "usu"
    val PREF_DEP = "dep"
    val PREF_IDSUBCENTRO = "IdSubcentro"
    val PREF_SUBCENTRO = "subcentro"
    val PREF_TIPOACCESO = "tipoAcceso"
    val PREF_SESION = "sesion"
    val PREF_TIPOUSUARIO = "tipoUsuario"

    fun saveinicio(inicio:Boolean?){
        if (inicio!!){
            editor.putString(PREF_LOGIN_INICIO, "true")
        }else{
            editor.putString(PREF_LOGIN_INICIO, "false")
        }
        editor.commit()
    }

    fun saveUserInfo(user:String,pwd:String,Login:ResponseDataLogin){
        editor.putString(PREF_LOGIN_USER, user)
        editor.putString(PREF_LOGIN_PASS, pwd )
        editor.putString(PREF_USUID, Login.msg[0].usuID)
        editor.putString(PREF_USU, Login.msg[0].usu)
        editor.putString(PREF_DEP, Login.msg[0].dep)
        editor.putString(PREF_IDSUBCENTRO, Login.msg[0].IdSubcentro)
        editor.putString(PREF_SUBCENTRO, Login.msg[0].subcentro)
        editor.putString(PREF_TIPOACCESO, Login.msg[0].tipoAcceso)
        editor.putString(PREF_SESION, Login.msg[0].sesion)
        editor.putString(PREF_TIPOUSUARIO, Login.msg[0].tipoUsuario)
        editor.commit()
    }

    fun clearSharedPreference(){
        editor.clear()
        editor.commit()
    }
}