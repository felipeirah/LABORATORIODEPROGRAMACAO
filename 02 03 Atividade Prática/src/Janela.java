import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Interface do Sistema Bancário. Ela consulta e atualiza contas armazenadas
 * em memória; a classe ContaBancaria representa o modelo usado pela tela.
 *
 * @author Felipe Junior
 */
public class Janela extends JFrame {
    private final Map<String, ContaBancaria> contas = new HashMap<>();
    private final JTextField agencia = new JTextField(8);
    private final JTextField numero = new JTextField(10);
    private final JTextField nome = new JTextField(24);
    private final JTextField endereco = new JTextField(24);
    private final JTextField telefone = new JTextField(16);
    private final JTextField cpf = new JTextField(16);
    private final JRadioButton corrente = new JRadioButton("Conta corrente", true);
    private final JRadioButton poupanca = new JRadioButton("Conta poupança");
    private final JButton atualizar = new JButton("Atualizar / cadastrar");

    public Janela() {
        super("Sistema Bancário — Atividade Prática 03");
        criarContaExemplo();
        montarTela();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 365);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void criarContaExemplo() {
        ContaBancaria exemplo = new ContaBancaria("001", "12345", "Cliente Exemplo",
                "Rua Principal, 100", "(00) 00000-0000", "000.000.000-00", "Corrente");
        contas.put(chave(exemplo.getAgencia(), exemplo.getNumero()), exemplo);
    }

    private void montarTela() {
        JPanel conteudo = new JPanel(new BorderLayout(10, 10));
        conteudo.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));
        conteudo.add(criarCabecalho(), BorderLayout.NORTH);
        conteudo.add(criarFormulario(), BorderLayout.CENTER);
        conteudo.add(criarAcoes(), BorderLayout.SOUTH);
        setContentPane(conteudo);
        atualizar.setEnabled(false);
    }

    private JPanel criarCabecalho() {
        JPanel painel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Consulta e atualização de contas");
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        painel.add(titulo, BorderLayout.NORTH);
        painel.add(new JLabel("Consulte uma conta existente ou informe novos dados para cadastrá-la."), BorderLayout.SOUTH);
        return painel;
    }

    private JPanel criarFormulario() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createTitledBorder("Dados da conta"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;

        adicionarLinha(painel, c, 0, "Agência:", agencia);
        adicionarLinha(painel, c, 1, "Número da conta:", numero);
        adicionarLinha(painel, c, 2, "Nome:", nome);
        adicionarLinha(painel, c, 3, "Endereço:", endereco);
        adicionarLinha(painel, c, 4, "Telefone:", telefone);
        adicionarLinha(painel, c, 5, "CPF:", cpf);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Tipo:"), c);
        JPanel tipos = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(corrente);
        grupo.add(poupanca);
        tipos.add(corrente);
        tipos.add(poupanca);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        painel.add(tipos, c);
        return painel;
    }

    private void adicionarLinha(JPanel painel, GridBagConstraints c, int linha,
            String rotulo, JTextField campo) {
        c.gridx = 0;
        c.gridy = linha;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;
        painel.add(new JLabel(rotulo), c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        painel.add(campo, c);
    }

    private JPanel criarAcoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton consultar = new JButton("Consultar");
        JButton fechar = new JButton("Fechar");
        consultar.addActionListener(e -> consultarConta());
        atualizar.addActionListener(e -> salvarConta());
        fechar.addActionListener(e -> dispose());
        painel.add(consultar);
        painel.add(atualizar);
        painel.add(fechar);
        return painel;
    }

    private void consultarConta() {
        if (!identificacaoPreenchida()) {
            mensagem("Informe a agência e o número da conta para consultar.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ContaBancaria conta = contas.get(chave(agencia.getText(), numero.getText()));
        if (conta == null) {
            limparDadosCliente();
            atualizar.setEnabled(true);
            mensagem("Conta não encontrada. Preencha os dados e clique em Atualizar / cadastrar.", JOptionPane.INFORMATION_MESSAGE);
            nome.requestFocusInWindow();
            return;
        }
        nome.setText(conta.getNome());
        endereco.setText(conta.getEndereco());
        telefone.setText(conta.getTelefone());
        cpf.setText(conta.getCpf());
        corrente.setSelected("Corrente".equals(conta.getTipo()));
        poupanca.setSelected("Poupança".equals(conta.getTipo()));
        atualizar.setEnabled(true);
        mensagem("Conta localizada. Altere os dados desejados e clique em Atualizar / cadastrar.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void salvarConta() {
        if (!identificacaoPreenchida() || algumDadoDoClienteVazio()) {
            mensagem("Preencha todos os campos antes de salvar.", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String chave = chave(agencia.getText(), numero.getText());
        String tipo = corrente.isSelected() ? "Corrente" : "Poupança";
        ContaBancaria conta = contas.get(chave);
        if (conta == null) {
            contas.put(chave, new ContaBancaria(texto(agencia), texto(numero), texto(nome),
                    texto(endereco), texto(telefone), texto(cpf), tipo));
            mensagem("Conta cadastrada com sucesso.", JOptionPane.INFORMATION_MESSAGE);
        } else {
            conta.atualizarDados(texto(nome), texto(endereco), texto(telefone), texto(cpf), tipo);
            mensagem("Dados da conta atualizados com sucesso.", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean identificacaoPreenchida() {
        return !texto(agencia).isEmpty() && !texto(numero).isEmpty();
    }

    private boolean algumDadoDoClienteVazio() {
        return texto(nome).isEmpty() || texto(endereco).isEmpty()
                || texto(telefone).isEmpty() || texto(cpf).isEmpty();
    }

    private void limparDadosCliente() {
        nome.setText("");
        endereco.setText("");
        telefone.setText("");
        cpf.setText("");
        corrente.setSelected(true);
    }

    private String chave(String codigoAgencia, String numeroConta) {
        return codigoAgencia.trim() + "-" + numeroConta.trim();
    }

    private String texto(JTextField campo) {
        return campo.getText().trim();
    }

    private void mensagem(String texto, int tipo) {
        JOptionPane.showMessageDialog(this, texto, "Sistema Bancário", tipo);
    }
}
