import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BarraNavegacao implements BarraNavegacaoInterface, ActionListener {
    public JPanel barraNavPanel;
    public JButton botaoHome;
    public JButton botaoPerfil;
    public JButton botaoCarrinho;
    public Main app;

    public BarraNavegacao(Main app) {
        this.app = app;
        // Definição da dimensão da Layared Pane
        barraNavPanel = new JPanel();
        barraNavPanel.setBounds(44, 778, 300, 45);
        barraNavPanel.setBackground(new Color(0, 0, 0, 0));

        // Definição dos botões
        ImageIcon homeIcon = new ImageIcon("lib/iconeHome.jpg");
        botaoHome = new JButton(homeIcon);
        botaoHome.setBackground(new Color(0, 0, 0, 0));
        botaoHome.setBorderPainted(false);

        ImageIcon perfilIcon = new ImageIcon("lib/iconePerfil.jpg");
        botaoPerfil = new JButton(perfilIcon);
        botaoPerfil.setBackground(new Color(0, 0, 0, 0));
        botaoPerfil.setBorderPainted(false);

        ImageIcon carrinhoIcon = new ImageIcon("lib/iconeCarrinho.jpg");
        botaoCarrinho = new JButton(carrinhoIcon);
        botaoCarrinho.setBackground(new Color(0, 0, 0, 0));
        botaoCarrinho.setBorderPainted(false);

        // Definição das posições dos botões
        botaoHome.setBounds(44, 778, 29, 29);
        botaoPerfil.setBounds(181, 778, 29, 29);
        botaoCarrinho.setBounds(317, 778, 29, 29);

        // Seta action listneres
        botaoHome.addActionListener(this);
        botaoPerfil.addActionListener(this);
        botaoCarrinho.addActionListener(this);

        // Adicionar aos paineis
        barraNavPanel.add(botaoHome);
        barraNavPanel.add(botaoPerfil);
        barraNavPanel.add(botaoCarrinho);

    }

    @Override
    public JPanel getBarraNavPanel() {
        return this.barraNavPanel;
    }

    @Override
    public void setBarraNavPanel(JPanel barraNavPanel) {
        this.barraNavPanel = barraNavPanel;
    }

    @Override
    public JButton getBotaoHome() {
        return this.botaoHome;
    }

    @Override
    public void setBotaoHome(JButton botaoHome) {
        this.botaoHome = botaoHome;
    }

    @Override
    public JButton getBotaoPerfil() {
        return this.botaoPerfil;
    }

    @Override
    public void setBotaoPerfil(JButton botaoPerfil) {
        this.botaoPerfil = botaoPerfil;
    }

    @Override
    public JButton getBotaoCarrinho() {
        return this.botaoCarrinho;
    }

    @Override
    public void setBotaoCarrinho(JButton botaoCarrinho) {
        this.botaoCarrinho = botaoCarrinho;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoHome) {
            app.mostrarTela("Home");
        } else if (e.getSource() == botaoPerfil) {
            app.mostrarTela("Login");
        } else if (e.getSource() == botaoCarrinho) {
            app.mostrarTela("Carrinho");
        }

    }

}
