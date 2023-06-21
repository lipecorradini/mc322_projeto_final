import java.awt.*;
import javax.swing.*;

public class TelaEssentials extends Tela {
    public JLayeredPane essentialsPane;
    public JButton buttonBlackTee;
    public JButton buttonOffwhiteTee;
    public JButton buttonWhiteTee;
    public JButton buttonBrownTee;

    //Construtor
    public TelaEssentials(boolean mostrarBarraNavegacao, Color backgroundColor){
        super(mostrarBarraNavegacao, backgroundColor);
        // Definção de Layout
		essentialsPane = new JLayeredPane();
		essentialsPane.setPreferredSize(new Dimension(390, 844));

		// Painel da imagem de fundo
		JPanel painelImagem = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image imagem = new ImageIcon(
						"mc322_projeto_final/projetoFinal/lib/Essentials.jpg")
						.getImage();
				g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
			}
		};

		// Painel para o tamanho da imagem
		painelImagem.setBounds(0, 0, 390, 844);

        // Cria o botão
		ImageIcon imageIcon = new ImageIcon(
            "mc322_projeto_final/projetoFinal/lib/Botao Essential.jpg");
        buttonBlackTee = new JButton(imageIcon);
        buttonBrownTee = new JButton(imageIcon);
        buttonOffwhiteTee = new JButton(imageIcon);
        buttonWhiteTee = new JButton(imageIcon);
        

        // Posiciona o botao
        buttonBlackTee.setBounds(72, 361, 75, 19);
        buttonBrownTee.setBounds(262, 361, 75, 19);
        buttonOffwhiteTee.setBounds(72, 573, 75, 19);
        buttonWhiteTee.setBounds(262, 573, 75, 19);

        //Retira borda botao
        buttonBlackTee.setBorderPainted(false);
        buttonBrownTee.setBorderPainted(false);
        buttonOffwhiteTee.setBorderPainted(false);
        buttonWhiteTee.setBorderPainted(false);

        // Adiciona o painel da imagem e o botão ao JLayeredPane em diferentes camadas
		essentialsPane.add(painelImagem, Integer.valueOf(0)); // Camada mais baixa
		essentialsPane.add(buttonBlackTee, Integer.valueOf(1));
        essentialsPane.add(buttonBrownTee, Integer.valueOf(1));
        essentialsPane.add(buttonOffwhiteTee, Integer.valueOf(1));
        essentialsPane.add(buttonWhiteTee, Integer.valueOf(1)); // Camada mais alta
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
