<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <title>OinsBus</title>
  <link rel="stylesheet" href="style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>

<body>
  <header>
    <div class="navbar">
      <div class="icone-direita">
        <a href="#icone"><img src="img/logo.png" alt="Ícone"></a>
      </div>
      <ul class="menu">
        <li><a href="index.jsp">HOME</a></li>
        <li class="dropdown"><a href="rotas_itinerario.jsp" class="active">ROTAS</a>
          <div class="dropdown-content">
            <a href="rotas_itinerario.jsp">Itinerários</a>
            <a href=" ">Cadastrar Itinerários</a>
          </div>
        </li>
        <li><a href="contato.jsp">CONTATO</a></li>
        <li><a href="empresa.jsp">EMPRESA</a></li>
        <li><a href="duvidas.jsp">DÚVIDAS</a></li>
      </ul>

    </div>
  </header>

  <div class="titulo">
    <h1 class="titulo_linha"></h1>
    <h1 class="titulo_nome">Cadastrar itinerários</h1>
    <h1 class="titulo_linha"></h1>
  </div>

  <div class="cadastro"></div>
  <div class="titulo">
    <h1 class="titulo_linha"></h1>
    <h1 class="titulo_nome">Entre em contato conosco</h1>
    <h1 class="titulo_linha"></h1>
  </div>




  <form id="itinerarioForm">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" required><br>

    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao" required><br>

    <label for="terminal">Terminal:</label>
    <input type="text" id="terminal" name="terminal" required><br>

    <label for="pontosParada">Pontos de Parada (id,nome separados por vírgula, conjuntos separados por ponto e vírgula):</label>
    <textarea id="pontosParada" name="pontosParada" rows="4" required></textarea><br>

    <button type="button" onclick="enviarFormulario()">Enviar</button>
  </form>

  <script>
    function enviarFormulario() {
      // Coletar dados do formulário
      var formData = {
        "id": parseInt($("#id").val(), 10),
        "descricao": $("#descricao").val(),
        "terminal": $("#terminal").val(),
        "pontosParada": parsePontosParada($("#pontosParada").val())
      };

      // Enviar dados via AJAX
      $.ajax({
        type: "POST",
        url: "CaminhoDoSeuServlet",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(formData),
        success: function (data) {
          alert("Dados enviados com sucesso!");
        },
        error: function (error) {
          console.error("Erro ao enviar dados:", error);
        }
      });
    }

    function parsePontosParada(pontosParadaString) {
      // Função para converter a string de pontos de parada em um array de objetos
      var pontosParadaArray = [];
      var pontosParadaPairs = pontosParadaString.split(';');

      for (var i = 0; i < pontosParadaPairs.length; i++) {
        var pair = pontosParadaPairs[i].split(',');
        if (pair.length === 2) {
          pontosParadaArray.push({ "id": parseInt(pair[0], 10), "nome": pair[1] });
        }
      }

      return pontosParadaArray;
    }
  </script>



  <footer class="rodape">
    <div class="redes-sociais">
      <a href="#instagram"> <img src="img/instagram.png" alt=""></a>
      <a href="#whatsapp"><img src="img/whatsapp.png" alt=""></a>
    </div>
    <div class="links-uteis">
      <a href="#duvidas">
        <p>Dúvidas</p>
      </a>
      <a href="#contato">
        <p>Contato</p>
      </a>
      <a href="#empresa">
        <p>Empresa</p>
      </a>
    </div>
    <div class="logo-direita">
      <a href="#home"><img src="img/logo.png" alt="Logo"></a>
    </div>
  </footer>

</body>

</html>
</body>

</html>