import java.awt.*;

import javax.swing.*;

public class BarraNavegacao {
    public JPanel barraNavPanel;
    public JButton botaoHome;
    public JButton botaoPerfil;
    public JButton botaoCarrinho;
    
    public BarraNavegacao(){
        // Definição da dimensão da Layared Pane
        barraNavPanel = new JPanel();
        barraNavPanel.setPreferredSize(new Dimension(300, 29));
        barraNavPanel.setBackground(new Color(0, 0, 0, 0));

        // Definição dos botões
        ImageIcon homeIcon = new ImageIcon("lib/iconeHome.jpg");
        botaoHome = new JButton(homeIcon);
        ImageIcon perfilIcon = new ImageIcon("lib/iconePerfil.jpg");
        botaoPerfil = new JButton(perfilIcon);
        ImageIcon carrinhoIcon = new ImageIcon("lib/iconeCarrinho.jpg");
        botaoCarrinho = new JButton(carrinhoIcon);

        //Definição das posições dos botões
        botaoHome.setBounds(44, 778, 29, 29);
        botaoPerfil.setBounds(181, 778, 29, 29);
        botaoCarrinho.setBounds(317, 778, 29, 29);

        //Adicionar aos paineis
        barraNavPanel.add(botaoHome);
        barraNavPanel.add(botaoPerfil);
        barraNavPanel.add(botaoCarrinho);
    }

    public JPanel getBarraNavPanel() {
        return this.barraNavPanel;
    }

    public void setBarraNavPanel(JPanel barraNavPanel) {
        this.barraNavPanel = barraNavPanel;
    }

    public JButton getBotaoHome() {
        return this.botaoHome;
    }

    public void setBotaoHome(JButton botaoHome) {
        this.botaoHome = botaoHome;
    }

    public JButton getBotaoPerfil() {
        return this.botaoPerfil;
    }

    public void setBotaoPerfil(JButton botaoPerfil) {
        this.botaoPerfil = botaoPerfil;
    }

    public JButton getBotaoCarrinho() {
        return this.botaoCarrinho;
    }

    public void setBotaoCarrinho(JButton botaoCarrinho) {
        this.botaoCarrinho = botaoCarrinho;
    }
}

