package mx.com.zitro.almacen.Utils

class ValidateDate {

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}