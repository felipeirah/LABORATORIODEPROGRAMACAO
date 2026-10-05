/**
 * Modelo da atividade: reúne os dados de uma conta e de seu titular.
 * A combinação agência + número identifica uma conta durante a execução.
 *
 * @author Felipe Junior
 */
public class ContaBancaria {
    private final String agencia;
    private final String numero;
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private String tipo;

    public ContaBancaria(String agencia, String numero, String nome,
            String endereco, String telefone, String cpf, String tipo) {
        this.agencia = agencia;
        this.numero = numero;
        atualizarDados(nome, endereco, telefone, cpf, tipo);
    }

    /** Atualiza apenas os dados que podem ser alterados pelo cliente. */
    public void atualizarDados(String nome, String endereco, String telefone,
            String cpf, String tipo) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public String getAgencia() { return agencia; }
    public String getNumero() { return numero; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
    public String getCpf() { return cpf; }
    public String getTipo() { return tipo; }
}
