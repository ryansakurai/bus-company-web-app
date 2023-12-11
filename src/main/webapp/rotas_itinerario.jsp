<%@page contentType="text/html; charset=UTF-8" %>

  <!DOCTYPE html>
  <html lang="pt-BR">

  <head>
    <meta charset="UTF-8">
    <title>OinsBus</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="rotas_itinerario.js"></script>
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
          <li class="dropdown"><a href=" " class="active">ROTAS</a>
            <div class="dropdown-content">
              <a href=" ">Itinerários</a>
              <a href="rotas_cadastrar.jsp">Cadastrar Itinerários</a>
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
      <h1 class="titulo_nome">Itinerários</h1>
      <h1 class="titulo_linha"></h1>
    </div>

    <form>
      <label for="regiao">Escolha uma Região:</label>
      <select id="regiao" name="regiao">
        <option value="norte">NORTE</option>
        <option value="sul">SUL</option>
        <option value="leste">LESTE</option>
        <option value="oeste">OESTE</option>
        <option value="centro">CENTRO</option>
      </select>
      <button id="carregar" type="button">Enviar</button>
    </form>

    <footer class="rodape">
      <div class="redes-sociais">
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E"> <img src="img/instagram.png" alt=""></a>
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E"><img src="img/whatsapp.png" alt=""></a>
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