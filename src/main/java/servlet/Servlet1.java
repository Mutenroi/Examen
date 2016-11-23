package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Servlet1() {
        super();

    }
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String name = req.getParameter("name");
			String idioma = req.getParameter("idioma");
			String insertidioma = req.getParameter("insertidioma");

			req.setAttribute("nom",name);
			req.setAttribute("idio",idioma);
			req.setAttribute("insertidio",insertidioma);

			Repositorio.crearTablaPaises();
			Repositorio.crearTablaIdiomas();
			//Servicios.insertarTabla(name,idioma);
			//Servicios.insertarTabla(name, insertidioma);
			if(idioma == ""){
				Repositorio.insertarTablaPaises(name,idioma);

			}else
			{
				Repositorio.insertarTablaPaises(name, insertidioma);
				Repositorio.insertarTablaIdiomas(insertidioma);
			}

			req.getRequestDispatcher("mostrar.jsp").forward(req, resp);
			//redirect(resp);
			super.doPost(req, resp);
		}


	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("fin.jsp");
	}

}
