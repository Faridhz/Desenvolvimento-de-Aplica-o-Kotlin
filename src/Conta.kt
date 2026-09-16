class Conta(
    val numero: Int,
    val cliente: Cliente
) {

    var saldo: Double = 0.0

    private val extrato = mutableListOf<String>()

    fun depositar(valor: Double): Boolean {

        if (valor <= 0) {
            return false
        }

        saldo += valor

        extrato.add("Depósito: + R$ %.2f".format(valor))

        return true
    }

    fun sacar(valor: Double): Boolean {

        if (valor <= 0) {
            return false
        }

        if (valor > saldo) {
            return false
        }

        saldo -= valor

        extrato.add("Saque: - R$ %.2f".format(valor))

        return true
    }

    fun transferir(valor: Double, contaDestino: Conta): Boolean {

        if (valor <= 0) {
            return false
        }

        if (valor > saldo) {
            return false
        }

        saldo -= valor
        contaDestino.saldo += valor

        extrato.add(
            "Transferência enviada para conta ${contaDestino.numero}: - R$ %.2f"
                .format(valor)
        )

        contaDestino.extrato.add(
            "Transferência recebida da conta ${numero}: + R$ %.2f"
                .format(valor)
        )

        return true
    }

    fun mostrarExtrato() {

        println()
        println("========== EXTRATO ==========")
        println("Cliente: ${cliente.nome}")
        println("Conta: $numero")
        println()

        if (extrato.isEmpty()) {
            println("Nenhuma movimentação.")
        } else {
            for (movimentacao in extrato) {
                println(movimentacao)
            }
        }

        println()
        println("Saldo atual: R$ %.2f".format(saldo))
        println("=============================")
    }
}
