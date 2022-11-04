package mx.com.zitro.almacen.IU.Dashbord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import mx.com.zitro.almacen.DataCloudLocal.DataSharedPreference
import mx.com.zitro.almacen.IU.Login.LoginViewModel
import mx.com.zitro.almacen.R
import mx.com.zitro.almacen.databinding.ActivityDashbordBinding

class DashbordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashbordBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashbordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.primary_color)); //Define color blanco.

        binding.toolbalDashboard.txtNameUser.text = DataSharedPreference(this).getUsu()
    }
}