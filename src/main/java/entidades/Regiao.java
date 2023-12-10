package entidades;

public enum Regiao {

    NORTE("Norte"),
    SUL("Sul"),
    LESTE("Leste"),
    OESTE("Oeste");

    private final String descricao;

    private Regiao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
