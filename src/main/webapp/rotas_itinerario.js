const exibirPorRegiao = function (regiao) {
    $.getJSON(
        'http://localhost:8080/mp1/recuperarPorRegiao',
        { regiao: regiao },
        function (data) {
            console.log(data);
        }
    );
}

$(document).ready(
    function() {
        $('#carregar').click(
            function () {
                const regiao = $('#regiao').val();
                exibirPorRegiao(regiao);
            }
        );
    }
);
 