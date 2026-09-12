import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class ContaBancaria {
    private final String agencia;
    private final String banco;
    private final String tipo;
    private BigDecimal saldo;
    private boolean ativa;

    public ContaBancaria(String agencia, String banco, String tipo) {
        this.agencia = agencia;
        this.banco = banco;
        this.tipo = tipo;
        this.saldo = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        this.ativa = true;
    }

    public void creditar(BigDecimal valor) {
        validarConta();
        validarValor(valor);
        saldo = saldo.add(valor);
    }

    public void debitar(BigDecimal valor) {
        validarConta();
        validarValor(valor);
        if (valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo = saldo.subtract(valor);
    }

    public BigDecimal consultarSaldo() {
        validarConta();
        return saldo;
    }

    public void encerrar() {
        validarConta();
        ativa = false;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getBanco() {
        return banco;
    }

    public String getTipo() {
        return tipo;
    }

    private void validarConta() {
        if (!ativa) {
            throw new IllegalStateException("A conta esta encerrada.");
        }
    }

    private void validarValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }
}

public class Main {
    private static final Scanner ENTRADA = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCARIO ===");
        System.out.println("Criacao de conta");

        String banco = lerTexto("Informe o banco: ");
        String agencia = lerTexto("Informe a agencia: ");
        String tipo = lerTipoConta();

        ContaBancaria conta = new ContaBancaria(agencia, banco, tipo);

        System.out.println("\nConta criada com sucesso!");
        exibirDados(conta);

        while (conta.isAtiva()) {
            exibirMenu();
            int opcao = lerInteiro("Escolha uma opcao: ", 1, 4);

            try {
                switch (opcao) {
                    case 1:
                        BigDecimal credito = lerValor("Valor a creditar: R$ ");
                        conta.creditar(credito);
                        System.out.println("Credito realizado com sucesso.");
                        System.out.println("Saldo atual: " + formatarMoeda(conta.consultarSaldo()));
                        break;
                    case 2:
                        BigDecimal debito = lerValor("Valor a debitar: R$ ");
                        conta.debitar(debito);
                        System.out.println("Debito realizado com sucesso.");
                        System.out.println("Saldo atual: " + formatarMoeda(conta.consultarSaldo()));
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + formatarMoeda(conta.consultarSaldo()));
                        break;
                    case 4:
                        conta.encerrar();
                        System.out.println("Conta encerrada com sucesso.");
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Operacao nao realizada: " + e.getMessage());
            }
        }

        ENTRADA.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Creditar");
        System.out.println("2 - Debitar");
        System.out.println("3 - Consultar saldo");
        System.out.println("4 - Encerrar conta");
    }

    private static void exibirDados(ContaBancaria conta) {
        System.out.println("Banco: " + conta.getBanco());
        System.out.println("Agencia: " + conta.getAgencia());
        System.out.println("Tipo: " + conta.getTipo());
        System.out.println("Saldo inicial: " + formatarMoeda(conta.consultarSaldo()));
    }

    private static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = ENTRADA.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Entrada invalida. O campo nao pode ficar vazio.");
        }
    }

    private static String lerTipoConta() {
        System.out.println("Tipos de conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupanca");
        int opcao = lerInteiro("Escolha o tipo: ", 1, 2);
        return opcao == 1 ? "Conta Corrente" : "Conta Poupanca";
    }

    private static int lerInteiro(String mensagem, int minimo, int maximo) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(ENTRADA.nextLine().trim());
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
                System.out.println("Opcao invalida. Digite um numero entre " + minimo + " e " + maximo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite apenas numeros inteiros.");
            }
        }
    }

    private static BigDecimal lerValor(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String texto = ENTRADA.nextLine().trim().replace(",", ".");
                BigDecimal valor = new BigDecimal(texto).setScale(2, RoundingMode.HALF_EVEN);
                if (valor.compareTo(BigDecimal.ZERO) > 0) {
                    return valor;
                }
                System.out.println("Valor invalido. Digite um valor maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um valor numerico.");
            }
        }
    }

    private static String formatarMoeda(BigDecimal valor) {
        return "R$ " + valor.setScale(2, RoundingMode.HALF_EVEN).toPlainString().replace(".", ",");
    }
}
