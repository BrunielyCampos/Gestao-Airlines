import java.util.List;
import java.util.Scanner;

public class Avioes {

    private long codigo;
    private String modelo;
    private int capacidadeMaxima;

    public Avioes(long codigo, String modelo, int capacidadeMaxima) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Avioes() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }


    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidade Máxima: " + capacidadeMaxima);
    }

    public boolean dadosValidos() {
        if (codigo <= 0) return false;
        if (modelo == null || modelo.isEmpty()) return false;
        if (capacidadeMaxima <= 0) return false;

        return true;
    }

    public String toString() {
        return "Avião [codigo=" + codigo + ", modelo=" + modelo +
               ", capacidade=" + capacidadeMaxima + "]";
    }
}