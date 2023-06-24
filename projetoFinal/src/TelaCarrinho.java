import java.awt.*;
import javax.swing.*;

public class TelaCarrinho extends Tela {

    public JLayeredPane layeredPane;
    public JButton botaoAdicionarCompra;
    public Main app;

    // Construtor
    public TelaCarrinho(boolean mostrarBarraNavegacao, Main app) {
        super(mostrarBarraNavegacao);
        this.app = app;
        // Definção de Layout
        barraNavegacao = new BarraNavegacao(app);
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(390, 844));

        // Painel da imagem de fundo
        JPanel painelImagem = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image imagem = new ImageIcon(
                        "lib/Login.jpg")
                        .getImage();
                g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Adicionando o ícone do botão
        ImageIcon imagemFinalizarCompra = new ImageIcon("lib/botao_finalizar_compra.jpg");

        // Criando o botão
        JButton botaoFinalizarCompra = new JButton(imagemFinalizarCompra);

        // Ajustando o tamanho e características do botão
        botaoFinalizarCompra.setBounds(91, 667, imagemFinalizarCompra.getIconWidth(),
                imagemFinalizarCompra.getIconHeight());
        botaoFinalizarCompra.setBorderPainted(false);

        // Criando a imagem da palavra total
        ImageIcon imagemPalavraTotal = new ImageIcon("lib/Total.jpg");
        JLabel labelImagemSobreposta = new JLabel(imagemPalavraTotal);
        labelImagemSobreposta.setBounds(41, 594, imagemPalavraTotal.getIconWidth(), imagemPalavraTotal.getIconHeight());

        // Painel para o tamanho da imagem de fundo
        painelImagem.setBounds(0, 0, 390, 844);

        // Adiciona o painel da imagem e o botão ao JLayeredPane em diferentes camadas
        layeredPane.add(painelImagem, Integer.valueOf(0)); // Camada mais baixa
        layeredPane.add(botaoFinalizarCompra, Integer.valueOf(1));
        layeredPane.add(labelImagemSobreposta, Integer.valueOf(1));

    }

    public JLayeredPane getLayeredPane() {
        return this.layeredPane;
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

}
