package totemAutoAtendimento.produtos.lanches

import totemAutoAtendimento.produtos.Produto

open class Lanche(nomeLanche: String, precoLanche: Double): Produto("lanche", nomeLanche, precoLanche) {
    override fun escolherProduto() {
        print("Escolha seu $tipoProduto:")
    }
}