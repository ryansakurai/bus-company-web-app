const parsePontosParada = function(pontosParadaString) {
    const pontosDeParadaStr = pontosParadaString.split(';');
    
    const pontosDeParadaObj = [];
    for(let pontodeParadaStr in pontosDeParadaStr) {
        let tupla = pontodeParadaStr.split(',');
        if(tupla.length === 2) {
            pontosDeParadaObj.push({
                "id": parseInt(tupla[0]),
                "nome": tupla[1]
            });
        }
    }

    return pontosDeParadaObj;
}

const enviarFormulario = function() {
    console.log("Chamado");
    // Coletar dados do formulário
    var formData = {
        "id": parseInt($("#id").val()),
        "descricao": $("#descricao").val(),
        "terminal": $("#terminal").val(),
        "pontosParada": parsePontosParada($("#pontosParada").val())
    };

    // Enviar dados via AJAX
    $.ajax({
        type: "POST",
        url: "/cadastroDeItinerario",
        data: JSON.stringify(yourData),
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
