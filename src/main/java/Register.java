import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entities.BusLine;

@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("busLines") == null)
			this.context.setAttribute("busLines", new ArrayList<BusLine>());
	}

	private static class Comparador implements Comparator<BusLine> {
		@Override
		public int compare(BusLine o1, BusLine o2) {
			return o1.getId() - o2.getId();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer buffer = new StringBuffer();
		try {
			String inputLine;
			BufferedReader reader = request.getReader();
			while((inputLine = reader.readLine()) != null)
				buffer.append(inputLine);
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<BusLine>>(){}.getType();
		List<BusLine> newBusLines = gson.fromJson(buffer.toString(), listType);

		List<BusLine> busLines = (List<BusLine>) context.getAttribute("busLines");
		busLines.addAll(newBusLines);
		Collections.sort(busLines, new Comparador());
	}

}
