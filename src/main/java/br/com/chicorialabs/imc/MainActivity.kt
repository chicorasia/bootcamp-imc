package br.com.chicorialabs.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.Group
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import br.com.chicorialabs.imc.databinding.ActivityMainBinding
import br.com.chicorialabs.imc.databinding.ResultadoBinding
import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.math.roundToLong

const val TAG = "IMC"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val includeResultado = binding.mainInclude
        setContentView(binding.root)

        // Faça o setup inicial da tela
        aplicaValoresPadraoNosCampos()
        aplicaValoresPadraoNosResultados(includeResultado)
        inicializaSliders()


        // Inicialize o botão
        binding.mainCalcularBtn.setOnClickListener {

            val df = DecimalFormat("#.##")
            val peso = binding.mainPesoSld.value
            val altura = binding.mainAlturaSld.value
            val imcCalculado = calculaImc(altura = altura, peso = peso)

            includeResultado.resultadoImc.text = df.format(imcCalculado)
            includeResultado.resultadoClassificacao.visibility = View.VISIBLE

            with(binding) {
                mainResultado.setColorFilter(resources.getColor(R.color.resultado_obesidade_ii))
                root.setBackgroundColor(resources.getColor(R.color.resultado_obesidade_ii))
            }

        }

    }

    private fun inicializaSliders() {
        binding.mainAlturaSld.addOnChangeListener { slider, value, fromUser ->
            val df = DecimalFormat("#.##")
            binding.mainAlturaEdt.setText(df.format(value).toString())

        }

        binding.mainPesoSld.addOnChangeListener { slider, value, fromUser ->
            val df = DecimalFormat("#.#")
            binding.mainPesoEdt.setText(df.format(value).toString())
        }
    }

    internal fun aplicaValoresPadraoNosResultados(includeResultado: ResultadoBinding) {
        binding.mainResultado.setColorFilter(resources.getColor(R.color.indigo_dark))
        includeResultado.resultadoImc.setText("--")
        includeResultado.resultadoClassificacao.visibility = View.GONE
    }

    private fun aplicaValoresPadraoNosCampos() {
        binding.mainAlturaSld.value = 1.65.toFloat()
        binding.mainPesoSld.value = 65.toFloat()
        binding.mainPesoEdt.setText("65,0")
        binding.mainAlturaEdt.setText("1,65")
    }



    fun calculaImc(altura: Float, peso: Float) : Float = peso.div (altura * altura)

}