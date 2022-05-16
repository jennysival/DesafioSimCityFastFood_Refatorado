package totemAutoAtendimento.utilitarias

class Utilitaria {

    companion object {
        var qtd = 0
            set(value) {
                if (value > 0){
                    field = value
                }
                else{
                    println(DIVISOR)
                    println("   * Não pode ser zero ou negativo, tente novamente *   ")
                    println(DIVISOR)
                    pedirQuantidade()
                }
            }

        fun pedirQuantidade(): Int{
            return try {
                print("Digite a quantidade: ")
                qtd = readln().toInt()
                qtd
            }catch (ex: IllegalArgumentException){
                println(DIVISOR)
                println(FORMATO_INVALIDO)
                println(DIVISOR)
                pedirQuantidade()
            }
        }

        fun solicitarCodigo(): Int{
            return try {
                println(DIVISOR)
                print("Digite o código do item desejado: ")
                val codigoDigitado = readln().toInt()
                codigoDigitado
            }catch (ex: IllegalArgumentException){
                println(DIVISOR)
                println(FORMATO_INVALIDO)
                solicitarCodigo()
            }
        }
    }

}