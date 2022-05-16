package totemAutoAtendimento.menus

import totemAutoAtendimento.checkout.Carrinho
import totemAutoAtendimento.utilitarias.*

class Menu {

    val carrinho = Carrinho()

    fun menuInicial(){
        try {
            DIVISOR
            println("Faça sua escolha:")
            println("[1] LANCHE")
            println("[2] BEBIDA")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    carrinho.escolherLanche()
                    menuNovoProduto()
                }
                2 -> {
                    carrinho.escolherBebida()
                    menuNovoProduto()
                }
                else -> {
                    println(OPC_INVALIDA)
                    menuInicial()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(ITEM_INVALIDO)
            menuInicial()
        }
    }

    fun menuNovoProduto(){
        try {
            println(DIVISOR)
            println("Adicionar novo item?")
            println(" [1] SIM  |  [2] NÃO")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> menuInicial()
                2 -> {
                    carrinho.mostrarCarrinho()
                    opcoesCarrinho()
                }
                else -> {
                    println(OPC_INVALIDA)
                    menuNovoProduto()
                }
            }

        }catch (ex: IllegalArgumentException){
            println(FORMATO_INVALIDO)
            menuNovoProduto()
        }
    }

    fun opcoesCarrinho(){
        try {
            println(DIVISOR)
            println("O que deseja fazer agora?")
            println("[1] Adicionar mais itens")
            println("[2] Editar um item")
            println("[3] Remover item")
            println("[4] Finalizar Pedido")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    menuInicial()
                }
                2 -> {
                    carrinho.editarItem()
                    opcoesCarrinho()
                }
                3 -> {
                    carrinho.removerItem()
                    opcoesCarrinho()
                }
                4 -> {
                    carrinho.finalizarPedido()
                }
                else -> {
                    println(OPC_INVALIDA)
                    opcoesCarrinho()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(FORMATO_INVALIDO)
            opcoesCarrinho()
        }


    }

}