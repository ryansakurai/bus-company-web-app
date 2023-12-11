const exibirMaisUsadas = function() {
    $.getJSON(
        'http://localhost:8080/mp1/recuperarMaisUsadas',
        { quantidade: 10 },
        function(data) {
            console.log(data);
        }
    );
}

$(document).ready(exibirMaisUsadas);
