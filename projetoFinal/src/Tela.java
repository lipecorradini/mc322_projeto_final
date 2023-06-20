import java.awt.*;

public abstract class Tela{
    public boolean mostrarBarraNavegacao;
    public Color backgroundColor;
    public String titulo;

    public Tela(boolean mostrarBarraNavegacao, 
                Color backgroundColor) {
        this.mostrarBarraNavegacao = true;
        this.backgroundColor = backgroundColor;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isMostrarBarraNavegacao() {
        return this.mostrarBarraNavegacao;
    }
}
