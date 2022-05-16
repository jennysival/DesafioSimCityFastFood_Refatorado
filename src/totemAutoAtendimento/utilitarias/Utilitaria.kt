package totemAutoAtendimento.utilitarias

class Utilitaria {

    companion object {
        fun pedirQuantidade(nomeProduto: String): Double{
            return try {
                print("Digite a quantidade de $nomeProduto: ")
                val qtd = readln().toDouble()
                qtd
            }catch (ex: IllegalArgumentException){
                println(FORMATO_INVALIDO)
                pedirQuantidade(nomeProduto)
            }
        }

        fun solicitarCodigo(): Int{
            return try {
                print("Digite o código do item desejado: ")
                val codigoDigitado = readln().toInt()
                codigoDigitado
            }catch (ex: IllegalArgumentException){
                println(FORMATO_INVALIDO)
                solicitarCodigo()
            }
        }
    }

}