import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.Itinerario;

@WebServlet("/cadastroDeItinerario")
public class CadastroDeItinerario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("itinerarios") == null)
			this.context.setAttribute("itinerarios", new ArrayList<Itinerario>());
	}

	private static class Comparador implements Comparator<Itinerario> {
		@Override
		public int compare(Itinerario o1, Itinerario o2) {
			return o1.getId() - o2.getId();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer buffer = new StringBuffer();
		try {
			String line;
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null)
				buffer.append(line);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		Itinerario novo = mapper.readValue(buffer.toString(), Itinerario.class);
		System.out.printf("Novo: %s", novo);

		ArrayList<Itinerario> itinerarios = (ArrayList<Itinerario>) context.getAttribute("itinerarios");
	
		itinerarios.add(novo);
		Collections.sort(itinerarios, new Comparador());
		context.setAttribute("itinerarios", itinerarios);
	}

}
