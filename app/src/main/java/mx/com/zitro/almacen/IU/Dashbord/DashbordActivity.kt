package mx.com.zitro.almacen.IU.Dashbord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.zitro.almacen.R
import mx.com.zitro.almacen.databinding.ActivityDashbordBinding

class DashbordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashbordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashbordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}