const exibirMaisUsadas = function () {
    $.getJSON(
        'http://localhost:8080/mp1/recuperarMaisUsadas',
        { quantidade: 8 },
        function (data) {
            exibirItinerarios(data);
        }
    );
}

$(document).ready(exibirMaisUsadas);


function exibirItinerarios(textoItinerarios) {
    var div = $("#home_home");
    div.empty();

    $.each(textoItinerarios, function (index, linha) {
        var itinerario = linha['itinerario'];
        var card = $('<div class="home_linhas">');
        card.append('<h1 class="home_titulo">' + linha['id'] + ' - ' + linha['descricao'] + '</h1>');
        card.append('<p class="home_subtitulo">Ponto de Saída:</p>');
        card.append('<p class="home_info">' + linha['terminal'] + '</p>');
        card.append('<p class="home_subtitulo">Ponto Final:</p>');
        card.append('<p class="home_info">' + itinerario[itinerario.length - 1].endereco + '</p>');
        div.append(card);

    }
    );
}

