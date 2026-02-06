public class Operacao<T> {
    
    private String tipoAcao; 
    private T dado;        

    public Operacao(String tipoAcao, T dado) {
        this.tipoAcao = tipoAcao;
        this.dado = dado;
    }

    public String getTipoAcao() {
        return this.tipoAcao;
    }

    public T getDado() {
        return this.dado;
    }

}