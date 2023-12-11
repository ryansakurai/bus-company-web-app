const parseItinerario = function (stringBruta) {
    let stringSemQuebras = stringBruta.replace(/\n/g, '');
    const listaDeStrings = stringSemQuebras.split(';');
    //console.log(listaDeStrings);
    const listaDeObj = [];
    for (let i = 0; i < listaDeStrings.length - 1; i += 1) {
        //console.log(listaDeStrings[i]);
        const tupla = listaDeStrings[i].split(',');
        listaDeObj.push({
            "endereco": tupla[0],
            "regiao": tupla[1]
        });
    }
    //console.log(listaDeObj);
    return listaDeObj;
}

const cadastrar = function () {
    if (!validarNumeroInteiro(document.getElementById('id').value) || !validarNumeroInteiro(document.getElementById('usuariosDiarios').value)) {
        return;
    }
    const dado = [
        {
            "id": parseInt($('#id').val()),
            "descricao": $('#descricao').val(),
            "terminal": $('#terminal').val(),
            "usuariosDiarios": parseInt($('#usuariosDiarios').val()),
            "itinerario": parseItinerario($('#itinerario').val())
        }
    ]
    console.log(dado);
    $.ajax({
        url: 'http://localhost:8080/mp1/cadastrar',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(dado),
        success: function () {
            console.log("deu");
        },
        error: function () {
            console.error("nao deu");
        }
    });
}

function validarNumeroInteiro(num) {
    var numero = num;
    if (Number.isInteger(Number(numero))) {
        return true;
    } else {
        alert('Número inteiro inválido!');
        return false
    }
}

$(document).ready(
    function () {
        $('#cadastrar').click(
            function () {
                cadastrar();
            }
        );
    }
);

