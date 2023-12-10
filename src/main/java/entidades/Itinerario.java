package entidades;

import java.util.List;

public record Itinerario(int id, String descricao, Terminal terminal, List<PontoDeParada> pontosDeParada) {

}
