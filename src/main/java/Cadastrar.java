import java.io.BufferedReader;
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

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {

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
			return o1.getId() - o2.getId();
		}
	}
	
	@SuppressWarnings("unchecked")
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

		Gson gson = new Gson();
		Linha novo = gson.fromJson(buffer.toString(), Linha.class);
		System.out.printf("Novo: %s", novo);

		List<Linha> linhas = (List<Linha>) context.getAttribute("linhas");
		linhas.add(novo);
		Collections.sort(linhas, new Comparador());
		context.setAttribute("linhas", linhas);
	}

}
