package br.com.chicorialabs.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.Group
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import br.com.chicorialabs.imc.databinding.ActivityMainBinding

const val TAG = "IMC"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainResultado.setColorFilter(resources.getColor(R.color.indigo_dark))

//        binding.mainBtnGroup.visibility = Group.INVISIBLE
//
//        binding.mainPesoEdt.doAfterTextChanged { text ->
//            if (!text.isNullOrEmpty()) {
//                binding.mainBtnGroup.visibility = Group.VISIBLE
//            } else {
//                binding.mainBtnGroup.visibility = Group.INVISIBLE
//            }
//        }

        binding.mainCalcularBtn.setOnClickListener {
            Toast.makeText(this, "Clicou!", Toast.LENGTH_SHORT).show()
            with(binding) {
                mainResultado.setColorFilter(resources.getColor(R.color.resultado_obesidade_ii))
                root.setBackgroundColor(resources.getColor(R.color.resultado_obesidade_ii))
            }
        }


        Log.i(TAG, "CREATE: estou criando a tela")


    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "START: deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "RESUME: agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "PAUSE: a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "STOP: a tela não está mais visível mas ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "RESTART: a tela está recuperando o foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "DESTROY: a tela foi destruída")
    }


}