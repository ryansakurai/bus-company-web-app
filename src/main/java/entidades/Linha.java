package entidades;

import java.util.List;

public class Linha {

    private int id;
    private String descricao;
    private String terminal;
    private int usuariosDiarios;
    private List<PontoDeParada> itinerario;

    public Linha() {

    }

    public Linha(int id, String descricao, String terminal, List<PontoDeParada> itinerario, int usuariosDiarios) {
        this.id = id;
        this.descricao = descricao;
        this.terminal = terminal;
        this.itinerario = itinerario;
        this.usuariosDiarios = usuariosDiarios;
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
    
    public int getUsuariosDiarios() {
        return usuariosDiarios;
    }

    public List<PontoDeParada> getItinerario() {
        return itinerario;
    }

    @Override
    public String toString() {
        return String.format("Linha [id=%s, descricao=%s, terminal=%s, itinerario=%s]", id, descricao,
                terminal, itinerario);
    }

}
