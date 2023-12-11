import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidades.Linha;

@WebServlet("/recuperarPorRegiao")
public class RecuperarPorRegiao extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("linhas") == null)
			this.context.setAttribute("linhas", new ArrayList<Linha>());
	}
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String REGIAO = request.getParameter("regiao");

        List<Linha> linhas = (ArrayList<Linha>) context.getAttribute("linhas");
        List<Linha> linhasFiltradas = linhas.stream()
            .filter(linha -> linha.passaPelaRegiao(REGIAO))
            .collect(Collectors.toList());

		Gson gson = new Gson();
		String linhasJson = gson.toJson(linhasFiltradas);
		response.setContentType("application/json");
		response.getWriter().write(linhasJson);
	}

}
