package screens;

import java.awt.*;

public abstract class Tela {

    public boolean mostrarBarraNavegacao;
    public Color backgroundColor;
    public BarraNavegacao barraNavegacao;
    public boolean estaLogado;
    public String titulo;

    public Tela(boolean mostrarBarraNavegacao, Color backgroundColor, BarraNavegacao barraNavegacao,
            boolean estaLogado, String titulo) {
        this.mostrarBarraNavegacao = true;
        this.backgroundColor = backgroundColor;
        this.barraNavegacao = barraNavegacao;
        this.estaLogado = estaLogado;
        this.titulo = titulo;
    }

    public boolean getMostrarBarraNavegacao() {
        return mostrarBarraNavegacao;
    }

    public void setMostrarBarraNavegacao(boolean mostrarBarraNavegacao) {
        this.mostrarBarraNavegacao = mostrarBarraNavegacao;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public BarraNavegacao getBarraNavegacao() {
        return barraNavegacao;
    }

    public void setBarraNavegacao(BarraNavegacao barraNavegacao) {
        this.barraNavegacao = barraNavegacao;
    }

    public boolean getEstaLogado() {
        return estaLogado;
    }

    public void setEstaLogado(boolean estaLogado) {
        this.estaLogado = estaLogado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
