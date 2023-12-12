const inserirHTML = function(listaLinhas) {
    const div = $("#itinerario_div");
    div.empty();

    $.each(
        listaLinhas,
        function(idx, linha) {
            const itinerario = linha.itinerario;
            const card = $(`<div class="home_linhas">`);
            card.append(`<h1 class="home_titulo">${linha.id} - ${linha.descricao}</h1>`);
            card.append(`<p class="home_subtitulo">Ponto de Saída:</p>`);
            card.append(`<p class="home_info">${linha.terminal}</p>`);
            card.append(`<p class="home_subtitulo">Pontos:</p>`);
            for(let i in itinerario)
                card.append(`<p class="home_info">${itinerario[i].endereco}</p>`);
            div.append(card);
        }
    );
}

const exibirPorRegiao = function(regiao) {
    $.getJSON(
        `recuperarPorRegiao`,
        {regiao: regiao},
        function(listaLinhas, status) {
            console.log(status);
            inserirHTML(listaLinhas);
        }
    );
}


$(document).ready(
    function() {
        $('#carregar').click(
            function() {
                const regiao = $('#regiao').val();
                exibirPorRegiao(regiao);
            }
        );
    }
);
