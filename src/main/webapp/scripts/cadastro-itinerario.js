const parseItinerario = function(stringBruta) {
    const pontosDeParadaStrLista = stringBruta.split('; ');
    const pontosDeParadaObjLista = [];
    for(let i in pontosDeParadaStrLista) {
        const pontoDeParadaTupla = pontosDeParadaStrLista[i].split(', ');
        if(pontoDeParadaTupla[0] && pontoDeParadaTupla[1])
            pontosDeParadaObjLista.push({
                "endereco": pontoDeParadaTupla[0],
                "regiao": pontoDeParadaTupla[1]
            });
    }
    return pontosDeParadaObjLista;
}

const cadastrar = function () {
    const id = parseInt( $('#id').val() );
    const descricao = $('#descricao').val();
    const terminal = $('#terminal').val();
    const usuariosDiarios = parseInt( $('#usuariosDiarios').val() );
    const itinerario = $('#itinerario').val();
    const padraoItinerario = /(.+ - \d+, .+; )*(.+ - \d+, .+)/;

    if(isNaN(id)) {
        alert(`'ID' precisa ser um número!`);
        return;
    }
    if(isNaN(usuariosDiarios)) {
        alert(`'Usuários Diários' precisa ser um número!`);
        return;
    }
    if(!padraoItinerario.test(itinerario)) {
        alert(`'Itinerário' precisa ser uma lista de pontos de parada no formato '<endereço> - <número>, <região>', separados por quebra de linha`);
        return;
    }

    const dado = [
        {
            "id": id,
            "descricao": descricao,
            "terminal": terminal,
            "usuariosDiarios": usuariosDiarios,
            "itinerario": parseItinerario(itinerario)
        }
    ]

    $.post(
        `cadastrar`,
        JSON.stringify(dado),
        function(data, status) {
            console.log(status);
            if(status === `success`)
                alert(`Linha cadastrada com sucesso!`);
        }
    );
}

$(document).ready(
    function() {
        $('#cadastrar').click(
            function() {
                cadastrar();
            }
        );
    }
);
