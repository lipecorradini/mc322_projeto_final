import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // configuracao frame exibicao
            JFrame frameExibicao = new JFrame();
            frameExibicao.setSize(390, 844);
            frameExibicao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameExibicao.setVisible(true);

            TelaHome telaHome = new TelaHome(false, null);
            // frameExibicao.add(telaHome.getLayeredPane());

            TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro(false, null);
            // frameExibicao.add(telaLoginCadastro.getPainelLoginCadastro());

            TelaCarrinho telaCarrinho = new TelaCarrinho(false, null);
            // frameExibicao.add(telaCarrinho.getLayeredPane());

            TelaEssentials telaEssentials = new TelaEssentials(true, null);
            frameExibicao.add(telaEssentials.getEssentialsPane());
        });

    }
}
