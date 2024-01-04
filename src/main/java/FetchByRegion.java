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

import entities.BusLine;

@WebServlet("/fetchByRegion")
public class FetchByRegion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletContext context;

	@Override
	public void init() throws ServletException {
		super.init();
		this.context = getServletContext();

		if(context.getAttribute("busLines") == null)
			this.context.setAttribute("busLines", new ArrayList<BusLine>());
	}
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String REGION = request.getParameter("region");

        List<BusLine> busLines = (ArrayList<BusLine>) context.getAttribute("busLines");
        List<BusLine> filteredBusLines = busLines.stream()
            .filter(busLine -> busLine.serves(REGION))
            .collect(Collectors.toList());

		Gson gson = new Gson();
		String busLinesJson = gson.toJson(filteredBusLines);
		response.setContentType("application/json");
		response.getWriter().write(busLinesJson);
	}

}
