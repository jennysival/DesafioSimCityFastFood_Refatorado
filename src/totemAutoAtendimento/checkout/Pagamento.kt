package totemAutoAtendimento.checkout

import totemAutoAtendimento.utilitarias.*

class Pagamento(private val totalCompra: Double) {

    fun escolherFormaPagto() {
        try {
            println(DIVISOR)
            println("Escolha a forma de pagamento:")
            println("[1] Cartão de Crédito")
            println("[2] Cartão de Débito")
            println("[3] Vale Refeição")
            println("[4] Dinheiro")
            print(ESCOLHA_OPC)
            when(readln().toInt()){
                1 -> {
                    println(DIVISOR)
                    println(PAGTO_FINALIZADO)
                    println(DIVISOR)
                }
                2 -> {
                    println(DIVISOR)
                    println(PAGTO_FINALIZADO)
                    println(DIVISOR)
                }
                3 -> {
                    println(DIVISOR)
                    println(PAGTO_FINALIZADO)
                    println(DIVISOR)
                }
                4 -> {
                    pagtoDinheiro()
                }
                else -> {
                    println(DIVISOR)
                    println(OPC_INVALIDA)
                    escolherFormaPagto()
                }
            }
        }catch (ex: IllegalArgumentException){
            println(DIVISOR)
            println(FORMATO_INVALIDO)
            escolherFormaPagto()
        }
    }

    private fun pagtoDinheiro(){
        println(DIVISOR)
        print("Digite o valor em dinheiro: ")
        val dinheiro = readln().toDouble()

        if(dinheiro < totalCompra){
            println(DIVISOR)
            println("        * Dinheiro insuficiente, tente novamente *      ")
            pagtoDinheiro()
        }
        else if(dinheiro > totalCompra){
            val troco = dinheiro - totalCompra
            println(DIVISOR)
            println("                O seu troco é de R$$troco               ")
            println(DIVISOR)
            println(PAGTO_FINALIZADO)
            println(DIVISOR)
        }
        else{
            println(DIVISOR)
            println(PAGTO_FINALIZADO)
            println(DIVISOR)
        }
    }
}