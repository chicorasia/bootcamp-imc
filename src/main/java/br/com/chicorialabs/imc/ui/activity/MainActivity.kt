package br.com.chicorialabs.imc.ui.activity

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.chicorialabs.imc.model.CalculadorImc
import br.com.chicorialabs.imc.R
import br.com.chicorialabs.imc.databinding.ActivityMainBinding
import br.com.chicorialabs.imc.databinding.ResultadoBinding
import java.text.DecimalFormat

const val TAG = "IMC"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val includeResultado = binding.mainInclude
        setContentView(binding.root)

        aplicaValoresPadraoNosCampos()
        aplicaValoresPadraoNosResultados(includeResultado)
        inicializaSliders()
        inicializaBtnCalcular(includeResultado)

    }

    private fun inicializaBtnCalcular(includeResultado: ResultadoBinding) {

        var ultimaCor = R.color.indigo_900

        binding.mainCalcularBtn.setOnClickListener {

            val calculadorImc = CalculadorImc()

            val df = DecimalFormat("#.##")
            val peso = binding.mainPesoSld.value
            val altura = binding.mainAlturaSld.value
            val imcCalculado = calculadorImc.calculaImc(altura = altura, peso = peso)
            val classificacao = calculadorImc.classifica(imcCalculado)

            includeResultado.resultadoImc.text = df.format(imcCalculado)
            with(includeResultado.resultadoClassificacao) {
                this.visibility = View.VISIBLE
                this.text = classificacao.texto

            }

            with(binding) {

                mainResultado.run {
                    val corInicial = ultimaCor
                    val corFinal = (resources.getColor(classificacao.cor))
                    ultimaCor = corFinal
                    val colorAnimation = ValueAnimator.ofObject(
                            ArgbEvaluator(), corInicial, corFinal)
                    colorAnimation.duration = 1000
                    colorAnimation.addUpdateListener {
                        this.setColorFilter(it.animatedValue as Int,
                                PorterDuff.Mode.MULTIPLY)
                        root.setBackgroundColor(it.animatedValue as Int)
                    }
                    colorAnimation.start()
                }
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





}