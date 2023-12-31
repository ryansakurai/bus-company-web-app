<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8">
    <title>OinsBus</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
  </head>
  <body>
    <header>
      <div class="navbar">
        <div class="icone-direita">
          <a href="index.jsp"><img src="img/logo.png" alt="Ícone"></a>
        </div>
        <ul class="menu">
          <li><a href="index.jsp">HOME</a></li>
          <li class="dropdown"><a href=" ">ROTAS</a>
            <div class="dropdown-content">
              <a href="consulta-itinerario.jsp">Itinerários</a>
              <a href="cadastro-itinerario.jsp">Cadastrar Itinerários</a>
            </div>
          </li>
          <li><a href="" class="active">CONTATO</a></li>
          <li><a href="empresa.jsp">EMPRESA</a></li>
          <li><a href="duvidas.jsp">DÚVIDAS</a></li>
        </ul>
      </div>
    </header>
    <div class="titulo">
      <h1 class="titulo_linha"></h1>
      <h1 class="titulo_nome">Entre em contato conosco</h1>
      <h1 class="titulo_linha"></h1>
    </div>
    <div class="contato">
      <label class="input_texto">Nome Completo:<br></label>
      <input type="text" class="input">
    </div>
    <div class="contato">
      <label class="input_texto">Email:<br></label>
      <input type="email" class="input">
    </div>
    <div class="contato">
      <label class="input_texto">Mensagem:<br></label>
      <input type="text" class="input mensagem">
    </div>
    <div class="contato botao_right">
      <button type="submit" class="botao">Enviar</button>
    </div>
    <footer class="rodape">
      <div class="redes-sociais">
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E" target="_blank"> <img src="img/instagram.png" alt=""></a>
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E" target="_blank"><img src="img/whatsapp.png" alt=""></a>
      </div>
      <div class="links-uteis">
        <a href="duvidas.jsp">
          <p>Dúvidas</p>
        </a>
        <a href="#">
          <p>Contato</p>
        </a>
        <a href="empresa.jsp">
          <p>Empresa</p>
        </a>
      </div>
      <div class="logo-direita">
        <a href="index.jsp"><img src="img/logo.png" alt="Logo"></a>
      </div>
    </footer>
  </body>
</html>