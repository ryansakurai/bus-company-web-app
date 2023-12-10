package entidades;

public enum Terminal {

    WHOLE_CAKE("Terminal Whole Cake"),
    WANO("Terminal Wano"),
    EGG_HEAD("Terminal Egg Head");

    private final String descricao;

    private Terminal(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
