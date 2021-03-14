package br.com.chicorialabs.imc.model

class CalculadorImc {

    fun calculaImc(altura: Float, peso: Float) : Float = peso.div (altura * altura)

    fun classifica(imc: Float): Classificacao{
        when(imc){
            in 0f..21.9.toFloat() -> return Classificacao.ABAIXO_DO_PESO
            in 22f..27.0f -> return Classificacao.PESO_NORMAL
            in 27.1f..32.0f -> return Classificacao.ACIMA_DO_PESO
            in 32.1f..37.0f -> return Classificacao.OBESIDADE_I
            in 37.1f..41.9f -> return Classificacao.OBESIDADE_II
            else -> return Classificacao.OBESIDADE_MORBIDA
        }
    }



}