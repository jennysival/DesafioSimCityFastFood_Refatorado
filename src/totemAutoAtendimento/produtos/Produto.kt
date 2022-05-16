package totemAutoAtendimento.produtos

abstract class Produto(val tipoProduto: String = "", val nome: String, val preco: Double) {
    var precoFinal = 0.0
    private var quantidade = 0.0

    abstract fun escolherProduto()

    fun calcularQuantidade(qtd: Double, preco: Double){
        precoFinal = preco*qtd
        quantidade = qtd
    }

    fun mostrarProduto(){
        println("Qtd $quantidade: $nome = R$$precoFinal")
    }

    fun editarQuantidade(){
        print("Digite a nova quantidade de $nome: ")
        val novaQtd = readln().toDouble()
        calcularQuantidade(novaQtd, preco)
    }



}