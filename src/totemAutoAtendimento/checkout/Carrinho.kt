package totemAutoAtendimento.checkout

import totemAutoAtendimento.produtos.Produto
import totemAutoAtendimento.produtos.bebidas.Refrigerante
import totemAutoAtendimento.produtos.bebidas.Suco
import totemAutoAtendimento.produtos.lanches.XBurger
import totemAutoAtendimento.produtos.lanches.XSalada
import totemAutoAtendimento.utilitarias.*
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.pedirQuantidade
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.solicitarCodigo

class Carrinho {
    val mapProdutos = mutableMapOf<Int, Produto>()
    var codigoProduto = 120
    var totalCarrinho = 0.0

    fun escolherLanche(){
        try {
            println(DIVISOR)
            println("Escolha seu lanche:")
            println("[1] X-BURGER: R$10")
            println("[2] X-SALADA: R$12")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    val novoXBurger = XBurger()
                    inserirProduto(novoXBurger)
                }
                2 -> {
                    val novoXSalada = XSalada()
                    inserirProduto(novoXSalada)

                }
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    escolherLanche()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(ITEM_INVALIDO)
            escolherLanche()
        }
    }

    fun escolherBebida(){
        try {
            println(DIVISOR)
            println("Escolha sua bebida:")
            println("[1] REFRIGERANTE: R$8")
            println("[2] SUCO: R$6")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    val novoRefri = Refrigerante()
                    inserirProduto(novoRefri)
                }
                2 -> {
                    val novoSuco = Suco()
                    inserirProduto(novoSuco)
                }
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    escolherBebida()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(ITEM_INVALIDO)
            escolherBebida()
        }
    }

    fun inserirProduto(novoProduto: Produto){
        novoProduto.calcularQuantidade(pedirQuantidade(), novoProduto.preco)
        salvarProdutoNoCarrinho(novoProduto)
    }

    fun salvarProdutoNoCarrinho(produto: Produto): Int{
        codigoProduto += 1
        mapProdutos[codigoProduto] = produto
        return codigoProduto
    }

    fun calcularPrecoFinal(){
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