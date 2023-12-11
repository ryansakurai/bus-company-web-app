import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidades.Linha;

@WebServlet("/recuperarMaisUsadas")
public class RecuperarMaisUsadas extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("linhas") == null)
			this.context.setAttribute("linhas", new ArrayList<Linha>());
	}

	private static class Comparador implements Comparator<Linha> {
		@Override
		public int compare(Linha o1, Linha o2) {
			int resultadoUsuarios = o2.getUsuariosDiarios() - o1.getUsuariosDiarios();
            int resultadoId = o2.getId() - o1.getId();
            return resultadoUsuarios != 0 ? resultadoUsuarios : resultadoId;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int QT_LINHAS = Integer.parseInt(request.getParameter("quantidade"));

		List<Linha> linhas = (ArrayList<Linha>) context.getAttribute("linhas");
        List<Linha> linhasOrdenadas = new ArrayList<>(linhas);
        Collections.sort(linhasOrdenadas, new Comparador());
        List<Linha> primeirosOito = linhasOrdenadas.subList(0, QT_LINHAS);

		Gson gson = new Gson();
		String linhasJson = gson.toJson(primeirosOito);
		response.setContentType("application/json");
		response.getWriter().write(linhasJson);
	}

}
