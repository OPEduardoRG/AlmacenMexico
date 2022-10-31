package mx.com.zitro.almacen

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class HelpersDialogs {

    companion object {
        @SuppressLint("MissingInflatedId")
        fun LogionCase(title: String, message: String, activity: Activity): AlertDialog.Builder {
            val builder = AlertDialog.Builder(activity)
            builder.setCancelable(false)
            val view = activity.layoutInflater.inflate(R.layout.dialog_alert_generic, null)
            val titleText = view.findViewById(R.id.titleG) as TextView
            titleText.text = title
            val subText = view.findViewById(R.id.subtitle) as TextView
            subText.text = message
            builder.setCustomTitle(view)

            view.findViewById<ImageView>(R.id.btnClosed).setOnClickListener {
                Toast.makeText(activity, "Hola", Toast.LENGTH_SHORT).show()
                val alerta: Dialog = builder.show()
                alerta.dismiss()

            }
            return builder
        }
    }
}