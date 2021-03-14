package br.com.chicorialabs.imc.model

import android.graphics.Color
import br.com.chicorialabs.imc.R

enum class Classificacao(val texto: String, val cor: Int) {

    ABAIXO_DO_PESO("Abaixo do peso", R.color.resultado_abaixo_peso),
    PESO_NORMAL("Peso normal", R.color.resultado_peso_normal),
    ACIMA_DO_PESO("Acima do peso", R.color.resultado_excesso_peso),
    OBESIDADE_I("Obesidade grau I", R.color.resultado_obesidade_i),
    OBESIDADE_II("Obesidade grau II", R.color.resultado_obesidade_ii),
    OBESIDADE_MORBIDA("Obesidade mórbida", R.color.resultado_obesidade_morbida);

    fun corFromResource() : Int {
        return Color.parseColor(this.cor.toString())

    }
}