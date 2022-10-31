package mx.com.zitro.almacen.IU.Login

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import mx.com.zitro.almacen.DataCloudLocal.RedSharePreferences
import mx.com.zitro.almacen.Utils.Constants
import mx.com.zitro.almacen.databinding.DialogSettingsRedBinding

class SettingsDialog: DialogFragment(), View.OnClickListener{
    
    private lateinit var binding: DialogSettingsRedBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogSettingsRedBinding.inflate(inflater)
        val url = RedSharePreferences(requireActivity()).getRedURL().toString()
        if (url.equals(Constants.BASE_URL_INTERNA)){
            binding.rbLocal.isChecked = true
        }else if (url.equals(Constants.BASE_URL_EXTERNA)){
            binding.rbExterno.isChecked = true
        }else if (url.equals(Constants.BASE_URLPRUEBAS)){
            binding.rbPruebas.isChecked = true
        }
        binding.btnClose.setOnClickListener { dismiss() }
        binding.btnGuardad.setOnClickListener{
            if (binding.rbLocal.isChecked){
                RedSharePreferences(requireActivity()).saveInfoRed(Constants.BASE_URL_INTERNA)
                dismiss()
            }else if( binding.rbExterno.isChecked){
                RedSharePreferences(requireActivity()).saveInfoRed(Constants.BASE_URL_EXTERNA)
                dismiss()
            }else if (binding.rbPruebas.isChecked){
                RedSharePreferences(requireActivity()).saveInfoRed(Constants.BASE_URLPRUEBAS)
                dismiss()
            }
        }
        return binding.root
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}