import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidades.Itinerario;

@WebServlet("/recuperarTodosItinerarios")
public class RecuperarTodosItinerarios extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("itinerarios") == null)
			this.context.setAttribute("itinerarios", new ArrayList<Itinerario>());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Itinerario> itinerarios = (ArrayList<Itinerario>) context.getAttribute("itinerarios");
		Gson gson = new Gson();
		String itinerariosJson = gson.toJson(itinerarios);
		response.setContentType("application/json");
		response.getWriter().write(itinerariosJson);
	}

} 
