import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaEssentials extends Tela implements ActionListener {
    public JLayeredPane essentialsPane;
    public JButton buttonBlackTee;
    public JButton ButtonOffWhiteTee;
    public JButton buttonWhiteTee;
    public JButton buttonBrownTee;
    public BarraNavegacao barraNavegacao;
    public BarraNavegacaoLogado barraNavegacaoLogado;
    public Main app;

    // Construtor
    public TelaEssentials(boolean mostrarBarraNavegacao,
            Main app) {
        super(mostrarBarraNavegacao);
        this.app = app;
        // Definção de Layout
        barraNavegacaoLogado = new BarraNavegacaoLogado(app);
        barraNavegacao = new BarraNavegacao(app);
        essentialsPane = new JLayeredPane();
        essentialsPane.setPreferredSize(new Dimension(390, 844));

        // Painel da imagem de fundo
        JPanel painelImagemFundo = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image imagem = new ImageIcon("lib/Essentials.jpg").getImage();
                g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Painel para elementos de preview
        JPanel painelImagemPreview = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image imagem = new ImageIcon("lib/tees preview.png").getImage();
                g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelImagemPreview.setBackground(new Color(0, 0, 0, 0));

        // Config para o tamanho da imagem
        painelImagemFundo.setBounds(0, 0, 390, 844);
        painelImagemPreview.setBounds(28, 245, 334, 354);

        // Cria o botão
        ImageIcon imageIcon = new ImageIcon("lib/botao essential.png");
        buttonBlackTee = new JButton(imageIcon);
        buttonBrownTee = new JButton(imageIcon);
        ButtonOffWhiteTee = new JButton(imageIcon);
        buttonWhiteTee = new JButton(imageIcon);

        // Posiciona o botao
        buttonBlackTee.setBounds(65, 358, 75, 20);
        buttonBrownTee.setBounds(251, 358, 75, 20);
        ButtonOffWhiteTee.setBounds(65, 565, 75, 20);
        buttonWhiteTee.setBounds(251, 565, 75, 20);

        buttonBlackTee.setBorderPainted(false);
        buttonBrownTee.setBorderPainted(false);
        ButtonOffWhiteTee.setBorderPainted(false);
        buttonWhiteTee.setBorderPainted(false);

        buttonBlackTee.setBackground(new Color(0, 0, 0, 0));
        buttonBrownTee.setBackground(new Color(0, 0, 0, 0));
        ButtonOffWhiteTee.setBackground(new Color(0, 0, 0, 0));
        buttonWhiteTee.setBackground(new Color(0, 0, 0, 0));

        buttonBlackTee.addActionListener(this);
        buttonBrownTee.addActionListener(this);
        ButtonOffWhiteTee.addActionListener(this);
        buttonWhiteTee.addActionListener(this);

        // Adiciona o painel da imagem e o botão ao JLayeredPane em diferentes camadas
        essentialsPane.add(painelImagemFundo, Integer.valueOf(0)); // Camada mais baixa
        essentialsPane.add(painelImagemPreview, Integer.valueOf(1));
        essentialsPane.add(buttonBlackTee, Integer.valueOf(2));
        essentialsPane.add(buttonBrownTee, Integer.valueOf(2));
        essentialsPane.add(ButtonOffWhiteTee, Integer.valueOf(2));
        essentialsPane.add(buttonWhiteTee, Integer.valueOf(2));
        essentialsPane.add(barraNavegacao.getBarraNavPanel(), Integer.valueOf(3));
    }

    public JLayeredPane getEssentialsPane() {
        return this.essentialsPane;
    }

    public void setEssentialsPane(JLayeredPane essentialsPane) {
        this.essentialsPane = essentialsPane;
    }

    public JButton getButtonBlackTee() {
        return this.buttonBlackTee;
    }

    public void setButtonBlackTee(JButton buttonBlackTee) {
        this.buttonBlackTee = buttonBlackTee;
    }

    public JButton getButtonOffWhiteTee() {
        return this.ButtonOffWhiteTee;
    }

    public void setButtonOffWhiteTee(JButton ButtonOffWhiteTee) {
        this.ButtonOffWhiteTee = ButtonOffWhiteTee;
    }

    public JButton getButtonWhiteTee() {
        return this.buttonWhiteTee;
    }

    public void setButtonWhiteTee(JButton buttonWhiteTee) {
        this.buttonWhiteTee = buttonWhiteTee;
    }

    public JButton getButtonBrownTee() {
        return this.buttonBrownTee;
    }

    public void setButtonBrownTee(JButton buttonBrownTee) {
        this.buttonBrownTee = buttonBrownTee;
    }

    public void atualizarTelaEssentials() {
        essentialsPane.add(barraNavegacaoLogado.getBarraNavPanel(), Integer.valueOf(4));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getButtonBlackTee()) {
            app.mostrarTela("Preta");
        } else if (e.getSource() == getButtonBrownTee()) {
            app.mostrarTela("Marrom");
        } else if (e.getSource() == getButtonOffWhiteTee()) {
            app.mostrarTela("OffWhite");
        } else if (e.getSource() == getButtonWhiteTee()) {
            app.mostrarTela("Branca");
        }
    }

}
