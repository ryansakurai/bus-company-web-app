const insertHtml = function(busLinesList) {
    const div = $(`#home_home`);
    div.empty();

    $.each(
        busLinesList,
        function(idx, busLine) {
            const itinerary = busLine.itinerary;
            const card = $(`<div class="home_linhas">`);
            card.append(`<h1 class="home_titulo">${busLine.id} - ${busLine.name}</h1>`);
            card.append(`<p class="home_subtitulo">Ponto de Saída:</p>`);
            card.append(`<p class="home_info">${busLine.terminal}</p>`);
            card.append(`<p class="home_subtitulo">Ponto Final:</p>`);
            card.append(`<p class="home_info">${itinerary[itinerary.length-1].address}</p>`);
            div.append(card);
        }
    );
}

const showMostUsed = function() {
    $.getJSON(
        `fetchMostUsed`,
        {quantity: 8},
        function(busLinesList, status) {
            console.log(status);
            insertHtml(busLinesList);
        }
    );
}

$(document).ready(showMostUsed);
