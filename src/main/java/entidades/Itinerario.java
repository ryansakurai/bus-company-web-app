package entidades;

import java.util.List;

public class Itinerario {

    private final int id;
    private final String descricao;
    private final String terminal;
    private final List<PontoDeParada> pontosDeParada;

    public Itinerario(int id, String descricao, String terminal, List<PontoDeParada> pontosDeParada) {
        this.id = id;
        this.descricao = descricao;
        this.terminal = terminal;
        this.pontosDeParada = pontosDeParada;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTerminal() {
        return terminal;
    }

    public List<PontoDeParada> getPontosDeParada() {
        return pontosDeParada;
    }

    @Override
    public String toString() {
        return String.format("Itinerario [id=%s, descricao=%s, terminal=%s, pontosDeParada=%s]", id, descricao,
                terminal, pontosDeParada);
    }

}
