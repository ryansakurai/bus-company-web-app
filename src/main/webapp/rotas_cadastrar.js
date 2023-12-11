const parseItinerario = function(stringBruta) {
    const listaDeStrings = stringBruta.split(';');
    console.log(listaDeStrings);
    const listaDeObj = [];
    for(let i=0; i<listaDeStrings.length; i+=1) {
        console.log(listaDeStrings[i]);
        const tupla = listaDeStrings[i].split(',');
        listaDeObj.push({
            "endereco": tupla[0],
            "regiao": tupla[1]
        });
    }
    return listaDeObj;
}

const cadastrar = function() {
    const dado = [
        {
            "id": parseInt( $('#id').val() ),
            "descricao": $('#descricao').val(),
            "terminal": $('#terminal').val(),
            "usuariosDiarios": parseInt( $('#usuariosDiarios').val() ),
            "itinerario": parseItinerario( $('#itinerario').val() )
        }
    ]

    $.ajax({
        url: 'http://localhost:8080/mp1/cadastrar',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(dado),
        success: function() {
            console.log("deu");
        },
        error: function() {
            console.error("nao deu");
        }
     });
}

$(document).ready(
    function() {
        $('#cadastrar').click(
            function () {
                cadastrar();
            }
        );
    }
);
