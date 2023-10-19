abstract class Produto implements IProduto {
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private boolean isFragil;
    private double peso;
    private String marca;
    private String cor;

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
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public double calcularFrete() {
        return 0;
    }
    public void aplicarDesconto(double percentual) {

    }

    public boolean verificarDisponibilidadeEmEstoque() {
        return false;
    }

    public void registrarSaidaDeEstoque(int quantidade) {

    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + ", Descrição: " + descricao + ", Preço: " + preco + ", Categoria: " + categoria);
    }
}