package totemAutoAtendimento.produtos

import totemAutoAtendimento.utilitarias.DIVISOR

abstract class Produto(val tipoProduto: String = "", private val nome: String, val preco: Double) {
    var precoFinal = 0.0
    private var quantidade = 0

    fun calcularQuantidade(qtd: Int, preco: Double){
        precoFinal = preco * qtd.toDouble()
        quantidade = qtd
    }

    fun mostrarProduto(){
        println("Qtd $quantidade: $nome = R$$precoFinal")
    }

    fun editarQuantidade(){
        println(DIVISOR)
        print("Digite a nova quantidade de $nome: ")
        val novaQtd = readln().toInt()
        calcularQuantidade(novaQtd, preco)
    }
}