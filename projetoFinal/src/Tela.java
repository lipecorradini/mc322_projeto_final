
public abstract class Tela{
    public boolean mostrarBarraNavegacao;
    public BarraNavegacao barraNavegacao;
    public String titulo;

    public Tela(boolean mostrarBarraNavegacao, 
                BarraNavegacao barraNavegacao) {
        this.mostrarBarraNavegacao = true;
        this.barraNavegacao = new BarraNavegacao();
    }

    public boolean getMostrarBarraNavegacao() {
        return mostrarBarraNavegacao;
    }

    public void setMostrarBarraNavegacao(boolean mostrarBarraNavegacao) {
        this.mostrarBarraNavegacao = mostrarBarraNavegacao;
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

    public BarraNavegacao getBarraNavegacao() {
        return this.barraNavegacao;
    }

    public void setBarraNavegacao(BarraNavegacao barraNavegacao) {
        this.barraNavegacao = barraNavegacao;
    }

}
