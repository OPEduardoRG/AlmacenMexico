package mx.com.zitro.almacen.IU.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import kotlinx.coroutines.runBlocking
import mx.com.zitro.almacen.HelpersDialogs
import mx.com.zitro.almacen.IU.Dashbord.DashbordActivity
import mx.com.zitro.almacen.Network.ResponseDataLogin
//import androidx.activity.viewModels
import mx.com.zitro.almacen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getSupportActionBar()?.hide()

        binding.btnSettings.setOnClickListener { view ->
            Toast.makeText(this, "Ajustes de Red", Toast.LENGTH_SHORT).show()
        }
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (binding.edtUsuario.text!!.toString().isEmpty() && s!!.length < 1) {
                    binding.btnIngresar.isEnabled = false
                    binding.edtPasswordUser.error = "Ingresa contraseña"
                } else if (binding.edtUsuario.text!!.toString().isNotEmpty() && s!!.length > 1) {
                    binding.btnIngresar.isEnabled = true
                } else {
                    binding.btnIngresar.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        val textWatcherUser = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!!.isEmpty() && binding.edtPasswordUser.text.toString()!!.length < 1) {
                    binding.btnIngresar.isEnabled = false
                    binding.edtUsuario.error = "Ingresa tu usuario"
                } else if (s!!.isNotEmpty() && binding.edtPasswordUser.text.toString()!!.length > 1) {
                    binding.btnIngresar.isEnabled = true
                } else {
                    binding.btnIngresar.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.edtUsuario.addTextChangedListener(textWatcherUser)
        binding.edtPasswordUser.addTextChangedListener(textWatcher)

        binding.btnIngresar.setOnClickListener {
            var response: ResponseDataLogin
            runBlocking() {
                viewModel.LogIn(
                    binding.edtUsuario.text.toString(),
                    binding.edtPasswordUser.text.toString(),
                    this@LoginActivity
                ).let {
                        response = it
                }
            }
            if (response.ok!!){
            val intent = Intent(this, DashbordActivity::class.java)
            startActivity(intent)
            }else{
                val builder = HelpersDialogs.LogionCase("Error - Login", "El usuario y/o contraseña ingresados son incorrectos. Intenta de nuevo", this)

                builder.show()
            }
        }
        binding.btnSettings.setOnClickListener {
            val dialog = SettingsDialog()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, SettingsDialog::class.java.simpleName)
        }


    }
}