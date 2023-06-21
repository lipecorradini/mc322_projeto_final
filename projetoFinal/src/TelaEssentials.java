import java.awt.*;
import javax.swing.*;

public class TelaEssentials extends Tela {
    public JLayeredPane essentialsPane;
    public JButton buttonBlackTee;
    public JButton buttonOffwhiteTee;
    public JButton buttonWhiteTee;
    public JButton buttonBrownTee;

    //Construtor
    public TelaEssentials(boolean mostrarBarraNavegacao, BarraNavegacao barraNavegacao){
        super(mostrarBarraNavegacao, barraNavegacao);
        // Definção de Layout
        barraNavegacao = new BarraNavegacao();
		essentialsPane = new JLayeredPane();
		essentialsPane.setPreferredSize(new Dimension(390, 844));

		// Painel da imagem de fundo
		JPanel painelImagemFundo = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image imagem = new ImageIcon(
						"projetoFinal/lib/Essentials.jpg")
						.getImage();
				g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
			}
		};

        //Painel para elementos de preview
        JPanel painelImagemPreview = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image imagem = new ImageIcon(
						"projetoFinal/lib/tees preview.png")
						.getImage();
				g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
			}
		};
        painelImagemPreview.setBackground(new Color(0,0,0,0));

		// Config para o tamanho da imagem
		painelImagemFundo.setBounds(0, 0, 390, 844);
        painelImagemPreview.setBounds(28, 245, 334, 354);


        // Cria o botão
		ImageIcon imageIcon = new ImageIcon(
            "projetoFinal/lib/botao essential.png");
        buttonBlackTee = new JButton(imageIcon);
        buttonBrownTee = new JButton(imageIcon);
        buttonOffwhiteTee = new JButton(imageIcon);
        buttonWhiteTee = new JButton(imageIcon);
        

        // Posiciona o botao
        buttonBlackTee.setBounds(65, 358, 75, 20);
        buttonBrownTee.setBounds(251, 358, 75, 20);
        buttonOffwhiteTee.setBounds(65, 565, 75, 20);
        buttonWhiteTee.setBounds(251, 565, 75, 20);


        // Adiciona o painel da imagem e o botão ao JLayeredPane em diferentes camadas
		essentialsPane.add(painelImagemFundo, Integer.valueOf(0)); // Camada mais baixa
        essentialsPane.add(painelImagemPreview, Integer.valueOf(1));
		essentialsPane.add(buttonBlackTee, Integer.valueOf(2));
        essentialsPane.add(buttonBrownTee, Integer.valueOf(2));
        essentialsPane.add(buttonOffwhiteTee, Integer.valueOf(2));
        essentialsPane.add(buttonWhiteTee, Integer.valueOf(2)); 
        if (mostrarBarraNavegacao) {
            essentialsPane.add(barraNavegacao.getBarraNavPanel(), Integer.valueOf(2));
        }// Camada mais alta
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

    public JButton getButtonOffwhiteTee() {
        return this.buttonOffwhiteTee;
    }

    public void setButtonOffwhiteTee(JButton buttonOffwhiteTee) {
        this.buttonOffwhiteTee = buttonOffwhiteTee;
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

}
