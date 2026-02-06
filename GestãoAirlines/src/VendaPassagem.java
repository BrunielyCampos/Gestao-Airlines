
public class VendaPassagem {
    private Passageiros passageiro;
    private String destinoViagem;
    private String origemViagem;
    private Avioes aviao;
    private String assento;
    private double preco;


    public VendaPassagem(Passageiros passageiro, Avioes aviao, String assento, double preco, String origemViagem, String destinoViagem) {
        this.setPassageiro(passageiro);
        this.setAviao(aviao);
        this.setAssento(assento);
        this.setPreco(preco);
        this.setOrigemViagem(origemViagem);
        this.setDestinoViagem(destinoViagem);
    }

    public VendaPassagem() {
       
    }

     public void setOrigemViagem(String origemViagem) {
        if (origemViagem != null && !origemViagem.isEmpty()) {
            this.origemViagem = origemViagem;
        } else {
            System.out.println("Origem inválida. Por favor, forneça uma origem válida");
        }
    }
    
    public Passageiros getPassageiro() {
        return this.passageiro;
    } 

    public void setPassageiro(Passageiros passageiro) {
        if (passageiro != null) {
            this.passageiro = passageiro;
        } 
        else {
            System.out.println("Passageiro inválido. Por favor, forneça um passageiro válido");
        }
    }

    public void setDestinoViagem(String destinoViagem) {
        if (destinoViagem != null && !destinoViagem.isEmpty()) {
            this.destinoViagem = destinoViagem;
        } else {
            System.out.println("Destino inválido. Por favor, forneça um destino válido");
        }
    }
    
    public String getDestinoViagem() {
        return this.destinoViagem;
    }

    public String getOrigemViagem() {
        return this.origemViagem;
    }


    public Avioes getAviao() {
        return this.aviao;
    }


    public void setAviao(Avioes aviao) {
        this.aviao = aviao;
    }

    public String getAssento() {
        return this.assento;
    }

    public void setAssento(String assento) {
        if (assento != null && !assento.isEmpty()) {
            this.assento = assento;
        } else {
            System.out.println("Assento inválido. Por   favor, forneça um assento válido");
        }

    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido. O preço não pode ser negativo.");
        }
    }

    public String OrigemDaViagem(){
        if (this.origemViagem != null && !this.origemViagem.isEmpty()) {
            System.out.println("Origem: " + this.origemViagem);
        } else { 
            System.out.println("Origem: Não definida");
        }
        return this.origemViagem;
    }
 
   public void VenderPassagem() {
        if (this.passageiro != null && this.aviao != null && this.assento != null && this.preco >= 0) {
            System.out.println("Passagem vendida com sucesso para " + this.passageiro.getNome() + " no avião " + this.aviao.getModelo() + " com assento " + this.assento + " por R$" + this.preco);
        } 
        else {                
            System.out.println("Não foi possível vender a passagem. Verifique os dados fornecidos.");
        }
   }
 
}