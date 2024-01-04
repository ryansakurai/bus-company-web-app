const insertHtml = function(busLinesList) {
    const div = $("#itinerario_div");
    div.empty();

    $.each(
        busLinesList,
        function(idx, busLine) {
            const itinerary = busLine.itinerary;
            const card = $(`<div class="home_linhas">`);
            card.append(`<h1 class="home_titulo">${busLine.id} - ${busLine.name}</h1>`);
            card.append(`<p class="home_subtitulo">Ponto de Saída:</p>`);
            card.append(`<p class="home_info">${busLine.terminal}</p>`);
            card.append(`<p class="home_subtitulo">Pontos:</p>`);
            for(let i in itinerary)
                card.append(`<p class="home_info">${itinerary[i].address}</p>`);
            div.append(card);
        }
    );
}

const showBusLines = function(region) {
    $.getJSON(
        `fetchByRegion`,
        {region: region},
        function(busLinesList, status) {
            console.log(status);
            insertHtml(busLinesList);
        }
    );
}


$(document).ready(
    function() {
        $('#carregar').click(
            function() {
                const region = $('#regiao').val();
                showBusLines(region);
            }
        );
    }
);
