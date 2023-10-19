abstract class Produto implements IProduto {
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;

    public Produto(String nome, String descricao, double preco, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + ", Descrição: " + descricao + ", Preço: " + preco + ", Categoria: " + categoria);
    }
    private int quantidadeEmEstoque;

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            System.out.println("Quantidade em estoque não pode ser negativa.");
            return;
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Quantidade não pode ser negativa.");
            return;
        }
        this.quantidadeEmEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > this.quantidadeEmEstoque) {
            System.out.println("Não há quantidade suficiente em estoque.");
            return;
        }
        this.quantidadeEmEstoque -= quantidade;
    }
}