const inserirHTML = function(listaLinhas) {
    const div = $(`#home_home`);
    div.empty();

    $.each(
        listaLinhas,
        function(idx, linha) {
            const itinerario = linha.itinerario;
            const card = $(`<div class="home_linhas">`);
            card.append(`<h1 class="home_titulo">${linha.id} - ${linha.descricao}</h1>`);
            card.append(`<p class="home_subtitulo">Ponto de Saída:</p>`);
            card.append(`<p class="home_info">${linha.terminal}</p>`);
            card.append(`<p class="home_subtitulo">Ponto Final:</p>`);
            card.append(`<p class="home_info">${itinerario[itinerario.length-1].endereco}</p>`);
            div.append(card);
        }
    );
}

const exibirMaisUsadas = function() {
    $.getJSON(
        `recuperarMaisUsadas`,
        {quantidade: 8},
        function(linhasLista, status) {
            console.log(status);
            inserirHTML(linhasLista);
        }
    );
}

$(document).ready(exibirMaisUsadas);
