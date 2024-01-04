const parseItinerary = function(rawString) {
    const busStopStrList = rawString.split('; ');
    const busStopObjList = [];
    for(let i in busStopStrList) {
        const busStopTuple = busStopStrList[i].split(', ');
        if(busStopTuple[0] && busStopTuple[1])
            busStopObjList.push({
                "address": busStopTuple[0],
                "region": busStopTuple[1]
            });
    }
    return busStopObjList;
}

const register = function () {
    const id = parseInt( $('#id').val() );
    const name = $('#descricao').val();
    const terminal = $('#terminal').val();
    const dailyUsers = parseInt( $('#usuariosDiarios').val() );
    const itinerary = $('#itinerario').val();
    const itineraryRegex = /(.+ - \d+, .+; )*(.+ - \d+, .+)/;

    if(isNaN(id)) {
        alert(`'ID' precisa ser um número!`);
        return;
    }
    if(isNaN(dailyUsers)) {
        alert(`'Usuários Diários' precisa ser um número!`);
        return;
    }
    if(!itineraryRegex.test(itinerary)) {
        alert(`'Itinerário' precisa ser uma lista de pontos de parada no formato '<endereço> - <número>, <região>', separados por quebra de linha`);
        return;
    }

    const busLine = [{
        "id": id,
        "name": name,
        "terminal": terminal,
        "dailyUsers": dailyUsers,
        "itinerary": parseItinerary(itinerary)
    }];

    $.post(
        `register`,
        JSON.stringify(busLine),
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
                register();
            }
        );
    }
);
