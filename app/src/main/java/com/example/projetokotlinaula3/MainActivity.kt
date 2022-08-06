package com.example.projetokotlinaula3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encontrando o botão pelo ID
        val btn_rodarNumero = findViewById<Button>(R.id.btn_rodar)


        //Quando clica no botao, altera o texto e inclui um número randomico
        btn_rodarNumero.setOnClickListener {

            //Encontrando o input pelo ID
            val input_numero = findViewById<EditText>(R.id.input_numero)

            val Numero = input_numero.text.toString()
            val NumeroInt = Numero.toIntOrNull()

            //Encontra o texto pelo ID
            val texto = findViewById<TextView>(R.id.text_numero)

            val validaCampo = validarCampo(Numero)

            //Seleciona um número randomico de 0 a 10
            val numeroSorteado = Random().nextInt(11)

            if(validaCampo){
                //verifica se o numero selecionado é o mesmo que foi inserido
                if(numeroSorteado == NumeroInt){
                    texto.text = "Voce acertou o número é: " + numeroSorteado
                } else {
                    texto.text = "Voce errou o número é: " + numeroSorteado
                }
            } else{
                //Exibindo o resultado
                texto.text = "Preencha com um número valido de 0 a 10"
            }

        }

    }

    private fun validarCampo(inputNumero: String): Boolean {
        var campoValidado : Boolean = true

        //Transforma o string em numero
        val numeroFinal = inputNumero.toIntOrNull()

        //faz as validacoes se o campo esta vazio ou o numero é valido
        if(inputNumero == null || inputNumero == ("")) {
            campoValidado = false
        } else if (numeroFinal != null) {
            if(numeroFinal > 10 || numeroFinal < 0){
                campoValidado = false
            }
        }
        return campoValidado
    }
}