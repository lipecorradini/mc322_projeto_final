import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BarraNavegacaoLogado implements BarraNavegacaoInterface, ActionListener {
    public JPanel barraNavPanel;
    public JButton botaoHome;
    public JButton botaoPerfil;
    public JButton botaoCarrinho;
    public Main app;

    public BarraNavegacaoLogado(Main app) {
        this.app = app;
        // Definição da dimensão da Layared Pane
        barraNavPanel = new JPanel();
        barraNavPanel.setBounds(44, 738, 300, 45);
        barraNavPanel.setBackground(new Color(0, 0, 0, 0));

        // Definição dos botões
        ImageIcon homeIcon = new ImageIcon("lib/iconeHome.jpg");
        botaoHome = new JButton(homeIcon);
        botaoHome.setBackground(new Color(0, 0, 0, 0));
        botaoHome.setBorderPainted(false);

        ImageIcon carrinhoIcon = new ImageIcon("lib/iconeCarrinho.jpg");
        botaoCarrinho = new JButton(carrinhoIcon);
        botaoCarrinho.setBackground(new Color(0, 0, 0, 0));
        botaoCarrinho.setBorderPainted(false);

        // Definição das posições dos botões
        botaoHome.setBounds(34, 760, 29, 29);
        botaoCarrinho.setBounds(308, 760, 29, 29);

        // Seta action listneres
        botaoHome.addActionListener(this);
        botaoCarrinho.addActionListener(this);

        // Adicionar aos paineis
        barraNavPanel.add(botaoHome);
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
    public JButton getBotaoCarrinho() {
        return this.botaoCarrinho;
    }
    
    @Override
    public void setBotaoCarrinho(JButton botaoCarrinho) {
        this.botaoCarrinho = botaoCarrinho;
    }
    
    //Nâo utilizado, porém necessário para a interface
    @Override
    public JButton getBotaoPerfil() {
        return this.botaoPerfil;
    }

    @Override
    public void setBotaoPerfil(JButton botaoPerfil) {
        this.botaoPerfil = botaoPerfil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoHome) {
            app.mostrarTela("Home");
        } else if (e.getSource() == botaoCarrinho) {
            app.mostrarTela("Carrinho");
        }

    }

}
