package totemAutoAtendimento.menus

import totemAutoAtendimento.checkout.Carrinho
import totemAutoAtendimento.utilitarias.*
import kotlin.system.exitProcess

class Menu {

    private val carrinho = Carrinho()

    fun menuInicial(){
        try {
            println(DIVISOR)
            println("Faça sua escolha:")
            println("[1] LANCHE")
            println("[2] BEBIDA")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    carrinho.escolherLanche()
                    carrinho.mostrarCarrinho()
                    menuNovoProduto()
                }
                2 -> {
                    carrinho.escolherBebida()
                    carrinho.mostrarCarrinho()
                    menuNovoProduto()
                }
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    menuInicial()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(ITEM_INVALIDO)
            menuInicial()
        }
    }

    private fun menuNovoProduto(){
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
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    menuNovoProduto()
                }
            }

        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(FORMATO_INVALIDO)
            menuNovoProduto()
        }
    }

    private fun opcoesCarrinho(){
        try {
            println(DIVISOR)
            println("O que deseja fazer agora?")
            println("[1] Adicionar mais itens")
            println("[2] Editar qtd de um item")
            println("[3] Remover item")
            println("[4] Finalizar Pedido")
            println("[5] Cancelar e Sair")
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
                5 -> {
                    println(DIVISOR)
                    println("              * Seu pedido foi cancelado *              ")
                    println(DIVISOR)
                    exitProcess(0)
                }
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    opcoesCarrinho()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(FORMATO_INVALIDO)
            opcoesCarrinho()
        }


    }

}