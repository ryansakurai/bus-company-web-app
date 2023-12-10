package entidades;

import java.util.List;

public record Itinerario(int id, String descricao, String terminal, List<PontoDeParada> pontosDeParada) {

}
