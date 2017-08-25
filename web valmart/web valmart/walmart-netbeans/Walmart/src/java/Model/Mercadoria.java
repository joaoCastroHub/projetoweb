package Model;

public class Mercadoria {
    
    private int id;
    private String nome;
    private int parcela;
    private float preco;

    public Mercadoria() {
    }

    public Mercadoria(String nome, int parcela, float preco) {
        this.nome = nome;
        this.parcela = parcela;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Mercadoria{" + "id=" + id + ", nome=" + nome + ", parcela=" + parcela + ", preco=" + preco + '}';
    }
    
    
    
}
