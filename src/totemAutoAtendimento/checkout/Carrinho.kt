package totemAutoAtendimento.checkout

import totemAutoAtendimento.produtos.Produto
import totemAutoAtendimento.produtos.bebidas.Refrigerante
import totemAutoAtendimento.produtos.bebidas.Suco
import totemAutoAtendimento.produtos.lanches.XBurger
import totemAutoAtendimento.produtos.lanches.XSalada
import totemAutoAtendimento.utilitarias.CODIGO_INVALIDO
import totemAutoAtendimento.utilitarias.ESCOLHA_OPC
import totemAutoAtendimento.utilitarias.ITEM_INVALIDO
import totemAutoAtendimento.utilitarias.OPC_INVALIDA
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.pedirQuantidade
import totemAutoAtendimento.utilitarias.Utilitaria.Companion.solicitarCodigo

class Carrinho {
    val mapProdutos = mutableMapOf<Int, Produto>()
    var codigoProduto = 120
    var totalCarrinho = 0.0

    fun escolherLanche(){
        try {
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
                    println(OPC_INVALIDA)
                    escolherLanche()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(ITEM_INVALIDO)
            escolherLanche()
        }
    }

    fun escolherBebida(){
        try {
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
                    println(OPC_INVALIDA)
                    escolherBebida()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(ITEM_INVALIDO)
            escolherBebida()
        }
    }

    fun inserirProduto(novoProduto: Produto){
        novoProduto.calcularQuantidade(pedirQuantidade(novoProduto.nome), novoProduto.preco)
        salvarProdutoNoCarrinho(novoProduto)
    }

    fun salvarProdutoNoCarrinho(produto: Produto): Int{
        codigoProduto += 1
        mapProdutos[codigoProduto] = produto
        return codigoProduto
    }

    fun calcularPrecoFinal(){
        mapProdutos.forEach { codigo, produto ->
            totalCarrinho += produto.precoFinal
        }
    }

    fun mostrarCarrinho(){
        calcularPrecoFinal()
        println("CARRINHO")
        mapProdutos.forEach { codigo, produto ->
            print("$codigo | ")
            println(produto.mostrarProduto())
        }
        println("TOTAL = R$$totalCarrinho")
    }

    fun editarItem(){
        if(solicitarCodigo() in mapProdutos){
            mapProdutos[solicitarCodigo()]?.editarQuantidade()
            mostrarCarrinho()
        }
        else{
            println(CODIGO_INVALIDO)
            editarItem()
        }
    }

    fun removerItem(){
        if(solicitarCodigo() in mapProdutos){
            mapProdutos.remove(solicitarCodigo())
            println("Item removido com sucesso!")
            mostrarCarrinho()
        }
        else{
            println(CODIGO_INVALIDO)
            removerItem()
        }
    }

    fun finalizarPedido(){

    }
}