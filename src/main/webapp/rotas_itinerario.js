const exibirPorRegiao = function (regiao) {
    $.getJSON(
        'http://localhost:8080/mp1/recuperarPorRegiao',
        { regiao: regiao },
        function (data) {
            console.log(data);
            exibirItinerariosRegiao(data);
        }
    );
}

$(document).ready(
    function () {
        $('#carregar').click(
            function () {
                const regiao = $('#regiao').val();
                exibirPorRegiao(regiao);
            }
        );
    }
);

function exibirItinerariosRegiao(textoItinerarios) {
    var div = $("#itinerario_div");
    div.empty();

    $.each(textoItinerarios, function (index, linha) {
        var itinerario = linha['itinerario'];
        var card = $('<div class="home_linhas">');
        card.append('<h1 class="home_titulo">' + linha['id'] + ' - ' + linha['descricao'] + '</h1>');
        card.append('<p class="home_subtitulo">Ponto de Saída:</p>');
        card.append('<p class="home_info">' + linha['terminal'] + '</p>');
        card.append('<p class="home_subtitulo">Pontos:</p>');
        for (let i = 0; i < itinerario.length; i++) {
            card.append('<p class="home_info">' + itinerario[i].endereco + '</p>');
        }
        //card.append('<p class="home_info">' + itinerario[itinerario.length - 1].endereco + '</p>');
        div.append(card);

    }
    );
}