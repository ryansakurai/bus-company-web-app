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
          <li><a href="contato.jsp">CONTATO</a></li>
          <li><a href="empresa.jsp">EMPRESA</a></li>
          <li><a href="" class="active">DÚVIDAS</a></li>
        </ul>
      </div>
    </header>
    <div class="titulo">
      <h1 class="titulo_linha"></h1>
      <h1 class="titulo_nome">Duvidas?</h1>
      <h1 class="titulo_linha"></h1>
    </div>
    <div class="duvidas_caixa">
      <p class="duvidas_perguntas">Como posso saber o itinerário do meu ônibus?</p>
      <p class="duvidas_respostas">Para consultar um itinerário basta acessar o página de Rotas.</p>
    </div>
    <div class="duvidas_caixa">
      <p class="duvidas_perguntas">Qual o horario de funcionamento das linhas?</p>
      <p class="duvidas_respostas">Todas as Linhas funcionam das 4:00 AM até 23:30 PM, exceto aos domingos e feriados onde os ônibus funcionam em horários reduzidos das 6:00 AM até 18:00 PM</p>
    </div>
    <div class="duvidas_caixa">
      <p class="duvidas_perguntas">Como obter o benefício para estudantes?</p>
      <p class="duvidas_respostas">Para obter o benefício para estudantes é necessário se apresentar o comprovante de matrícula, comprovante de endereço e um documento com foto (RG ou CPF) em uma central de atendimento da Oinsbus de segunda a sexta entre 14:00 PM às 18:00 PM</p>
    </div>
    <div class="botao_top">
      <p class="texto_center">Não encontrou sua dúvida por aqui? Entre em contato conosco</p>
      <a href="contato.jsp" class="botao">Contato</a>
    </div>
    <footer class="rodape">
      <div class="redes-sociais">
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E" target="_blank"> <img src="img/instagram.png" alt=""></a>
        <a href="https://youtu.be/od_PmtmMDV0?si=Ku77W07P5Ocg4a_E" target="_blank"><img src="img/whatsapp.png" alt=""></a>
      </div>
      <div class="links-uteis">
        <a href="#">
          <p>Dúvidas</p>
        </a>
        <a href="contato.jsp">
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