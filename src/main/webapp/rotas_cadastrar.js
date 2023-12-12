const parseItinerario = function (stringBruta) {
    const listaDeStrings = stringBruta.split('; ');
    const listaDeObj = [];
    for(let i = 0; i < listaDeStrings.length; i += 1) {
        const tupla = listaDeStrings[i].split(', ');
        if(tupla[0] && tupla[1])
        listaDeObj.push({
            "endereco": tupla[0],
            "regiao": tupla[1]
        });
    }
    return listaDeObj;
}

const cadastrar = function () {
    const id = parseInt($('#id').val());
    const descricao = $('#descricao').val();
    const terminal = $('#terminal').val();
    const usuariosDiarios = parseInt($('#usuariosDiarios').val());
    const itinerario = $('#itinerario').val();

    if(isNaN(id)) {
        alert(`'ID' precisa ser um número!`);
        return;
    }
    if(isNaN(usuariosDiarios)) {
        alert(`'Usuários Diários' precisa ser um número!`);
        return;
    }
    const padraoItinerario = /(.+ - \d+, .+; )*(.+ - \d+, .+)/;
    if(!padraoItinerario.test(itinerario)) {
        alert(`'Itinerário' precisa ser uma lista de pontos de parada no formato '<endereço> - <número>, <região>', separados por quebra de linha`);
        return;
    }

    const dado = [
        {
            "id": id,
            "descricao": descricao,
            "terminal": terminal,
            "usuariosDiarios": usuariosDiarios,
            "itinerario": parseItinerario(itinerario)
        }
    ]

    $.ajax({
        url: 'http://localhost:8080/mp1/cadastrar',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(dado),
        success: function () {
            console.log(dado);
            alert(`Enviado com sucesso!`);
        },
        error: function () {
            console.error("Erro ao enviar!");
        }
    });
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

