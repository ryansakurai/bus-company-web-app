import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidades.Linha;

@WebServlet("/recuperarTodas")
public class RecuperarTodas extends HttpServlet {

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
		List<Linha> linhas = (List<Linha>) context.getAttribute("linhas");
		Gson gson = new Gson();
		String linhasJson = gson.toJson(linhas);
		response.setContentType("application/json");
		response.getWriter().write(linhasJson);
	}

} 
