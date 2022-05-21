package totemAutoAtendimento.checkout

import totemAutoAtendimento.produtos.Produto
import totemAutoAtendimento.utilitarias.*
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.pedirQuantidade
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.solicitarCodigo

class Carrinho {
    private val mapProdutos = mutableMapOf<Int, Produto>()
    private var codigoProduto = 120
    private var totalCarrinho = 0.0

    fun escolherProduto(tipoDeProduto: String, produto1: Produto, produto2: Produto){
        try {
            println(DIVISOR)
            println("Escolha $tipoDeProduto:")
            println("[1] ${produto1.nome.uppercase()}: R$${produto1.preco}")
            println("[2] ${produto2.nome.uppercase()}: R$${produto2.preco}")
            println(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> inserirProdutoNoCarrinho(produto1)
                2 -> inserirProdutoNoCarrinho(produto2)
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    escolherProduto(tipoDeProduto, produto1, produto2)
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(ITEM_INVALIDO)
            escolherProduto(tipoDeProduto, produto1, produto2)
        }
    }

    private fun inserirProdutoNoCarrinho(novoProduto: Produto){
        novoProduto.calcularQuantidade(pedirQuantidade(), novoProduto.preco)
        salvarProdutoNoCarrinho(novoProduto)
    }

    private fun salvarProdutoNoCarrinho(produto: Produto): Int{
        codigoProduto += 1
        mapProdutos[codigoProduto] = produto
        return codigoProduto
    }

    private fun calcularPrecoFinal(){
        var total = 0.0
        mapProdutos.forEach { (codigo, produto) ->
            total += produto.precoFinal
        }
        totalCarrinho = total
    }

    fun mostrarCarrinho(){
        calcularPrecoFinal()
        println("------------------- C A R R I N H O --------------------")
        mapProdutos.forEach { (codigo, produto) ->
            print("$codigo | ")
            produto.mostrarProduto()
        }
        println("TOTAL NO CARRINHO = R$$totalCarrinho")
    }

    fun editarItem(){
        val codigo = solicitarCodigo()
        if(codigo in mapProdutos){
            mapProdutos[codigo]?.editarQuantidade()
            mostrarCarrinho()
        }
        else{
            println(DIVISOR)
            println(CODIGO_INVALIDO)
            editarItem()
        }
    }

    fun removerItem(){
        val codigo = solicitarCodigo()
        if(codigo in mapProdutos){
            mapProdutos.remove(codigo)
            println(DIVISOR)
            println("             * Item removido com sucesso! *             ")
            println(DIVISOR)
            mostrarCarrinho()
        }
        else{
            println(DIVISOR)
            println(CODIGO_INVALIDO)
            removerItem()
        }
    }

    fun finalizarPedido(){
        println(DIVISOR)
        println("            Total do Pedido = $totalCarrinho            ")

        val checkout = Pagamento(totalCarrinho)
        checkout.escolherFormaPagto()
    }
}