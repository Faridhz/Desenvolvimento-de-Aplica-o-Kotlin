class Banco {

    private val contas = mutableListOf<Conta>()

    private var proximoNumero = 1001

    fun criarConta(nome: String, cpf: String): Conta {

        val cliente = Cliente(nome, cpf)

        val conta = Conta(
            numero = proximoNumero,
            cliente = cliente
        )

        contas.add(conta)

        proximoNumero++

        return conta
    }

    fun buscarConta(numero: Int): Conta? {

        return contas.find {
            it.numero == numero
        }
    }

    fun listarContas() {

        println()
        println("========== CONTAS ==========")

        if (contas.isEmpty()) {
            println("Nenhuma conta cadastrada.")
        } else {

            for (conta in contas) {

                println(
                    "Conta: ${conta.numero} | " +
                            "Cliente: ${conta.cliente.nome} | " +
                            "Saldo: R$ %.2f".format(conta.saldo)
                )
            }
        }

        println("============================")
    }
}
