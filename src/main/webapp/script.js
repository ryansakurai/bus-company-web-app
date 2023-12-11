const parsePontosDeParada = function(stringBruta) {
    const listaDeStrings = stringBruta.split(';');
    const listaDeObj = [];
    for(let pontoStr in listaDeStrings) {
        const tupla = pontoStr.split(',');
        listaDeObj.push({
            "endereco": tupla[0],
            "regiao": tupla[1]
        });
    }
    return listaDeObj;
}

const cadastrarLinha = function() {
    const dado = [{
        "id": parseInt( $("#id").val() ),
        "descricao": $("#descricao").val(),
        "terminal": $("#terminal").val(),
        "usuariosDiarios": parseInt( $("#usuariosDiarios").val() ),
        "itinerario": parsePontosDeParada( $("#itinerario").val() )
    }];

    $.ajax({
        type: "POST",
        url: "/cadastrar",
        data: JSON.stringify(dado),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){
            console.log("Success!", data);
        },
        error: function(error) {
            console.log("Error!", error);
        }
    });
}
