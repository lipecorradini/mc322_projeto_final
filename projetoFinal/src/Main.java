import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // TelaHome telaHome = new TelaHome(
            // false,
            // null,
            // new BarraNavegacao(),
            // false,
            // "null",
            // new JFrame());
            // configuracao frame exibicao
            JFrame frameExibicao = new JFrame();
            frameExibicao.setSize(390, 844);
            frameExibicao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // frameExibicao.add(telaHome.getLayeredPane());
            frameExibicao.setVisible(true);

            TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro(false, null);
            // frameExibicao.add(telaLoginCadastro.getPainelLoginCadastro());

            TelaCarrinho telaCarrinho = new TelaCarrinho(false, null);
            frameExibicao.add(telaCarrinho.getLayeredPane());
        });

    }
}
