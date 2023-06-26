import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    public CardLayout layoutTelas;
    public JPanel painelPrincipal;
    public JFrame framePrincipal;

    public TelaHome telaHome;
    public TelaLoginCadastro telaLoginCadastro;
    public TelaEssentials telaEssentials;
    public TelaProduto telaCamisetaPreta;
    public TelaProduto telaCamisetaMarrom;
    public TelaProduto telaCamisetaOffWhite;
    public TelaProduto telaCamisetaBranca;
    public BarraNavegacao barraNavegacao;
    public TelaCarrinho telaCarrinho;

    public ArrayList<Pedido> listaPedidos;

    public Main() {
        // instanciando layout e panel
        layoutTelas = new CardLayout();
        painelPrincipal = new JPanel(layoutTelas);
        framePrincipal = new JFrame();

        // Criando a lista dos pedidos
        listaPedidos = new ArrayList<Pedido>();

        // instanciando telas
        barraNavegacao = new BarraNavegacao(this);
        telaHome = new TelaHome(false, this);
        telaLoginCadastro = new TelaLoginCadastro(false, this);
        telaEssentials = new TelaEssentials(true, this);
        telaCamisetaPreta = new TelaProduto(false, "preta", this);
        telaCamisetaMarrom = new TelaProduto(false, "marrom", this);
        telaCamisetaOffWhite = new TelaProduto(false, "offwhite", this);
        telaCamisetaBranca = new TelaProduto(false, "branca", this);
        telaCarrinho = new TelaCarrinho(false, this);

        // Adicionando telas ao painel
        painelPrincipal.add(telaHome.getLayeredPane(), "Home");
        painelPrincipal.add(telaLoginCadastro.getPainelLoginCadastro(), "Login");
        painelPrincipal.add(telaEssentials.getEssentialsPane(), "Essentials");
        painelPrincipal.add(telaCamisetaPreta.getLayeredPane(), "Preta");
        painelPrincipal.add(telaCamisetaMarrom.getLayeredPane(), "Marrom");
        painelPrincipal.add(telaCamisetaOffWhite.getLayeredPane(), "OffWhite");
        painelPrincipal.add(telaCamisetaBranca.getLayeredPane(), "Branca");
        painelPrincipal.add(barraNavegacao.getBarraNavPanel(), "Barra");
        painelPrincipal.add(telaCarrinho.getLayeredPane(), "Carrinho");

        // Settando frame do aplicativo
        framePrincipal.getContentPane().add(painelPrincipal);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(390, 844);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);

    }

    public void mostrarTela(String nomeTela) {
        layoutTelas.show(painelPrincipal, nomeTela);
    }

    public ArrayList<Pedido> getListaPedidos() {
        return this.listaPedidos;
    }

    public TelaCarrinho getTelaCarrinho() {
        return this.telaCarrinho;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }
}
