package totemAutoAtendimento.checkout

import totemAutoAtendimento.utilitarias.*

class Pagamento(val totalCompra: Double) {

    fun escolherFormaPagto() {
        try {
            println("Escolha a forma de pagamento:")
            println("[1] Cartão de Crédito")
            println("[2] Cartão de Débito")
            println("[3] Vale Refeição")
            println("[4] Dinheiro")
            println(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    println(PAGTO_FINALIZADO)
                }
                2 -> {
                    println(PAGTO_FINALIZADO)
                }
                3 -> {
                    println(PAGTO_FINALIZADO)
                }
                4 -> {
                    pagtoDinheiro()
                }
                else -> {
                    println(OPC_INVALIDA)
                    escolherFormaPagto()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(FORMATO_INVALIDO)
            escolherFormaPagto()
        }
    }

    fun pagtoDinheiro(){
        println(DIVISOR)
        print("Digite o valor em dinheiro: ")
        val dinheiro = readln().toDouble()

        if(dinheiro < totalCompra){
            println(DIVISOR)
            print("        * Dinheiro insuficiente, tente novamente *      ")
            pagtoDinheiro()
        }
        else if(dinheiro > totalCompra){
            val troco = dinheiro - totalCompra
            println(DIVISOR)
            println("                O seu troco é de R$$troco               ")
            println(DIVISOR)
            println(PAGTO_FINALIZADO)
        }
        else{
            println(PAGTO_FINALIZADO)
        }
    }
}