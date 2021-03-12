package br.com.chicorialabs.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.Group
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import br.com.chicorialabs.imc.databinding.ActivityMainBinding

const val TAG = "lifecycle_playground"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBtnGroup.visibility = Group.INVISIBLE

        binding.mainPesoEdt.doAfterTextChanged { text ->
            if (!text.isNullOrEmpty()) {
                binding.mainBtnGroup.visibility = Group.VISIBLE
            } else {
                binding.mainBtnGroup.visibility = Group.INVISIBLE
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