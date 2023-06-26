import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarrinho extends Tela implements ActionListener {

    public JLayeredPane layeredPane;
    public JButton botaoFinalizarCompra;
    public Main app;
    public BarraNavegacao barraNavegacao;
    public JButton botaoVoltar;
    private int heightComponentCarrinho;
    private int numeroPedidos;

    // Construtor
    public TelaCarrinho(boolean mostrarBarraNavegacao, Main app) {
        super(mostrarBarraNavegacao);
        this.app = app;
        this.numeroPedidos = 0;
        this.heightComponentCarrinho = 289;
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
        botaoFinalizarCompra = new JButton(imagemFinalizarCompra);

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
        botaoFinalizarCompra.addActionListener(this);

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

    public void setHeightComponentCarrinho(int heightComponentCarrinho) {
        this.heightComponentCarrinho = heightComponentCarrinho;
    }

    public void atualizarPedido() {
        if (app.getListaPedidos().size() > numeroPedidos && numeroPedidos < 3) {

            // Recebendo o pedido e a imagem do item do carrinho
            Pedido pedidoAdicionado = app.getListaPedidos().get(numeroPedidos);
            ImageIcon imagemPedidoCarrinho = new ImageIcon("lib/carrinhoBlackTee.jpg"); // filtrar para cores diferentes
            JLabel labelImagemPedidoCarrinho = new JLabel(imagemPedidoCarrinho);

            // Definindo tamanho para o item do carrinho
            labelImagemPedidoCarrinho.setBounds(38, heightComponentCarrinho, imagemPedidoCarrinho.getIconWidth(),
                    imagemPedidoCarrinho.getIconHeight());

            // Definindo o texto e a fonte
            JLabel textoTamanhoSelecionado = new JLabel("Size: " + pedidoAdicionado.getTamanhoProduto());
            textoTamanhoSelecionado.setBounds(48 + labelImagemPedidoCarrinho.getWidth() / 2, heightComponentCarrinho,
                    100,
                    80);

            // Mostrando o valor total da compra do cliente
            JLabel labelPrecoCompra = new JLabel(Integer.toString(app.getListaPedidos().size() * 10) + "0,00 R$");
            labelPrecoCompra.setBounds(120, 560,
                    100,
                    80);

            // Colocando o fundo do total da compra
            ImageIcon fundoTotalCompra = new ImageIcon("lib/espaco_total_compra.jpg");
            JLabel labelEspacoTotal = new JLabel(fundoTotalCompra);
            labelEspacoTotal.setBounds(110, 560, 100, 80);

            // Atualizando a altura para o próximo componente
            setHeightComponentCarrinho(heightComponentCarrinho + labelImagemPedidoCarrinho.getHeight() + 2);

            // Adicionando todos os itens ao layeredPane
            this.layeredPane.add(labelImagemPedidoCarrinho, Integer.valueOf(3));
            this.layeredPane.add(textoTamanhoSelecionado, Integer.valueOf(4));
            this.layeredPane.add(labelPrecoCompra, Integer.valueOf(app.getListaPedidos().size() + 3));
            this.layeredPane.add(labelEspacoTotal, Integer.valueOf(app.getListaPedidos().size() + 3));

            numeroPedidos++;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            app.mostrarTela("Essentials");
        } else if (e.getSource() == botaoFinalizarCompra) {
            if (app.getStatusLogin() == false) {
                JOptionPane.showMessageDialog(null, "Por favor, crie uma conta ou faça login antes de finalizar sua compra.", "Faça Login", JOptionPane.INFORMATION_MESSAGE);
                app.mostrarTela("Login");
            } else {
                JOptionPane.showMessageDialog(null, "Pedido realizado com Sucesso! Informações de pagamento no email.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                app.mostrarTela("Home");
            }
        }
    }

}
