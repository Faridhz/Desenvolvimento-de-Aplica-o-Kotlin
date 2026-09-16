fun main() {

    val banco = Banco()

    var executando = true

    while (executando) {

        println()
        println("================================")
        println("        BANCO KOTLIN")
        println("================================")
        println("1 - Criar conta")
        println("2 - Depositar")
        println("3 - Sacar")
        println("4 - Consultar saldo")
        println("5 - Fazer transferência")
        println("6 - Mostrar extrato")
        println("7 - Listar contas")
        println("0 - Sair")
        println("================================")

        print("Escolha uma opção: ")

        val opcao = readln().toIntOrNull()

        when (opcao) {

            1 -> {

                println()
                println("===== CRIAR CONTA =====")

                print("Digite o nome do cliente: ")
                val nome = readln()

                print("Digite o CPF: ")
                val cpf = readln()

                val conta = banco.criarConta(nome, cpf)

                println()
                println("Conta criada com sucesso!")
                println("Cliente: ${conta.cliente.nome}")
                println("Número da conta: ${conta.numero}")
            }

            2 -> {

                println()
                println("===== DEPÓSITO =====")

                print("Digite o número da conta: ")
                val numero = readln().toIntOrNull()

                if (numero == null) {
                    println("Número de conta inválido.")
                    return
                }

                val conta = banco.buscarConta(numero)

                if (conta == null) {

                    println("Conta não encontrada.")

                } else {

                    print("Digite o valor do depósito: R$ ")
                    val valor = readln().toDoubleOrNull()

                    if (valor == null) {

                        println("Valor inválido.")

                    } else if (conta.depositar(valor)) {

                        println("Depósito realizado com sucesso!")
                        println("Novo saldo: R$ %.2f".format(conta.saldo))

                    } else {

                        println("Não foi possível realizar o depósito.")
                    }
                }
            }

            3 -> {

                println()
                println("===== SAQUE =====")

                print("Digite o número da conta: ")
                val numero = readln().toIntOrNull()

                if (numero == null) {

                    println("Número de conta inválido.")

                } else {

                    val conta = banco.buscarConta(numero)

                    if (conta == null) {

                        println("Conta não encontrada.")

                    } else {

                        print("Digite o valor do saque: R$ ")
                        val valor = readln().toDoubleOrNull()

                        if (valor == null) {

                            println("Valor inválido.")

                        } else if (conta.sacar(valor)) {

                            println("Saque realizado com sucesso!")
                            println("Novo saldo: R$ %.2f".format(conta.saldo))

                        } else {

                            println("Não foi possível realizar o saque.")
                            println("Verifique o valor e seu saldo.")
                        }
                    }
                }
            }

            4 -> {

                println()
                println("===== CONSULTAR SALDO =====")

                print("Digite o número da conta: ")
                val numero = readln().toIntOrNull()

                if (numero == null) {

                    println("Número inválido.")

                } else {

                    val conta = banco.buscarConta(numero)

                    if (conta == null) {

                        println("Conta não encontrada.")

                    } else {

                        println()
                        println("Cliente: ${conta.cliente.nome}")
                        println("Conta: ${conta.numero}")
                        println("Saldo: R$ %.2f".format(conta.saldo))
                    }
                }
            }

            5 -> {

                println()
                println("===== TRANSFERÊNCIA =====")

                print("Conta de origem: ")
                val numeroOrigem = readln().toIntOrNull()

                print("Conta de destino: ")
                val numeroDestino = readln().toIntOrNull()

                if (numeroOrigem == null || numeroDestino == null) {

                    println("Número de conta inválido.")

                } else {

                    val contaOrigem = banco.buscarConta(numeroOrigem)
                    val contaDestino = banco.buscarConta(numeroDestino)

                    if (contaOrigem == null) {

                        println("Conta de origem não encontrada.")

                    } else if (contaDestino == null) {

                        println("Conta de destino não encontrada.")

                    } else if (contaOrigem == contaDestino) {

                        println("A conta de origem e destino devem ser diferentes.")

                    } else {

                        print("Digite o valor da transferência: R$ ")
                        val valor = readln().toDoubleOrNull()

                        if (valor == null) {

                            println("Valor inválido.")

                        } else if (
                            contaOrigem.transferir(
                                valor,
                                contaDestino
                            )
                        ) {

                            println("Transferência realizada com sucesso!")

                        } else {

                            println("Não foi possível realizar a transferência.")
                            println("Verifique o valor e o saldo disponível.")
                        }
                    }
                }
            }

            6 -> {

                println()
                println("===== EXTRATO =====")

                print("Digite o número da conta: ")
                val numero = readln().toIntOrNull()

                if (numero == null) {

                    println("Número inválido.")

                } else {

                    val conta = banco.buscarConta(numero)

                    if (conta == null) {

                        println("Conta não encontrada.")

                    } else {

                        conta.mostrarExtrato()
                    }
                }
            }

            7 -> {

                banco.listarContas()
            }

            0 -> {

                println()
                println("Obrigado por utilizar o Banco Kotlin!")
                executando = false
            }

            else -> {

                println()
                println("Opção inválida. Tente novamente.")
            }
        }
    }
}
