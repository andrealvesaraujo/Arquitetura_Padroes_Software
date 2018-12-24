import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MeuServlet")
public class MeuServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;

	public MeuServlet(){
		System.out.println("Construiu");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("iniciou");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Foi");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destruiu");
	}
}
