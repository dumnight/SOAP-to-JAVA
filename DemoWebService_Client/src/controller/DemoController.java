package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.DemoStub;
import ws.DemoStub.Hello;
import ws.DemoStub.Sum;
import ws.ProductWSStub;
import ws.ProductWSStub.Find;
import ws.ProductWSStub.FindAll;
import ws.ProductWSStub.Product;

/**
 * Servlet implementation class DemoController
 */
@WebServlet("/test")
public class DemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			DemoStub ds = new DemoStub();
			ProductWSStub ps = new ProductWSStub();
			
			String inputA = request.getParameter("inputA");
			String inputB = request.getParameter("inputB");
			
			int A = Integer.parseInt(inputA);
			int B = Integer.parseInt(inputB);
			
			//Call Hello Web Service
			out.print(ds.hello(new Hello()).get_return());
			
			//Call Sum Web Service
			Sum s = new Sum();
			s.setA(A);
			s.setB(B);
			out.print("<br>Sum : " + ds.sum(s).get_return());
			
			//Call Find  Web Service
			Product p = ps.find(new Find()).get_return();
			out.print("<h3>Product Information<h3>");
			out.print("<br>Id : " + p.getId());
			out.print("<br>Name : " + p.getName());
			out.print("<br>Price : " + p.getPrice());
			out.print("<h3>List Product Information<h3>");
			
			for(Product pr : ps.findAll(new FindAll()).get_return()){
				out.print("<br>Id : " + pr.getId());
				out.print("<br>Name : " + pr.getName());
				out.print("<br>Price : " + pr.getPrice());
				out.print("<br>================");
			}
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
