class ProdutoFisico extends Produto {
    private String dimensoes;

    public ProdutoFisico(String nome, String descricao, double preco, String categoria, String dimensoes) {
        super(nome, descricao, preco, categoria);
        this.dimensoes = dimensoes;
    }

    public String getDimensoes() { return dimensoes; }
    public void setDimensoes(String dimensoes) { this.dimensoes = dimensoes; }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Dimensões: " + dimensoes);
    }
}