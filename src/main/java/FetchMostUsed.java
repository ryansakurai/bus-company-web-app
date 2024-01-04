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

import entities.BusLine;

@WebServlet("/fetchMostUsed")
public class FetchMostUsed extends HttpServlet {

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
			int resultUsers = o2.getDailyUsers() - o1.getDailyUsers();
            int resultId = o2.getId() - o1.getId();
            return resultUsers != 0 ? resultUsers : resultId;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int QT_BUS_LINES_PARAM = Integer.parseInt(request.getParameter("quantity"));

		List<BusLine> busLines = (ArrayList<BusLine>) context.getAttribute("busLines");
        List<BusLine> orderedBusLines = new ArrayList<>(busLines);
        Collections.sort(orderedBusLines, new Comparador());
		int qtBusLinesOutput = QT_BUS_LINES_PARAM <= orderedBusLines.size() ? QT_BUS_LINES_PARAM : orderedBusLines.size();
        List<BusLine> busLinesOutput = orderedBusLines.subList(0, qtBusLinesOutput);

		Gson gson = new Gson();
		String busLinesJson = gson.toJson(busLinesOutput);
		response.setContentType("application/json");
		response.getWriter().write(busLinesJson);
	}

}
