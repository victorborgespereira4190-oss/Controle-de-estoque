public class Produto {
    private final int codigo;
    private final String nome;
    private final double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public boolean vender(int unidades) {
        if (unidades <= 0 || unidades > quantidade) return false;
        quantidade -= unidades;
        return true;
    }

    public double valorEmEstoque() { return preco * quantidade; }

    @Override
    public String toString() {
        return String.format(java.util.Locale.forLanguageTag("pt-BR"),
                "Código: %d | Nome: %s | Preço: R$ %.2f | Quantidade: %d",
                codigo, nome, preco, quantidade);
    }
}
