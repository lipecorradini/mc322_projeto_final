import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarrinho extends Tela implements ActionListener {

    public JLayeredPane layeredPane;
    public JButton botaoAdicionarCompra;
    public Main app;
    public BarraNavegacao barraNavegacao;
    public JButton botaoVoltar;

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

        // Criando o botão de voltar
        ImageIcon iconVoltar = new ImageIcon("lib/icon _arrow left_.png");
        botaoVoltar = new JButton(iconVoltar);
        botaoVoltar.addActionListener(this);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setBackground(new Color(0, 0, 0, 0));
        botaoVoltar.setBounds(45, 50, 25, 18);

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
        layeredPane.add(botaoVoltar, Integer.valueOf(1));
        if (mostrarBarraNavegacao) {
            painelImagem.add(barraNavegacao.getBarraNavPanel(), Integer.valueOf(3));
        }

    }

    public JLayeredPane getLayeredPane() {
        return this.layeredPane;
    }

    public void setLayeredPane(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            app.mostrarTela("Essentials");
        }
    }

}
