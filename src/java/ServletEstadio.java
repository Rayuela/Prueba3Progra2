import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Estadio;

public class ServletEstadio extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("guardar") != null){
               String nombre=request.getParameter("nombre");
               Estadio stad=new Estadio();
               stad.setNombre(nombre);
               stad.save();
               response.sendRedirect("estadios/index.jsp");
               
           }else if(request.getParameter("editar") != null){
               int estadio_id=Integer.parseInt(request.getParameter("estadio_id"));
               String nombre=request.getParameter("nombre"); 
               Estadio stad=new Estadio();
               stad.setEstadio_id(estadio_id);
               stad.setNombre(nombre);
               stad.update();
               response.sendRedirect("estadios/index.jsp");
               
           }else if(request.getParameter("eliminar") !=null){
               int estadio_id=Integer.parseInt(request.getParameter("eliminar"));
               out.println("Eliminar ID:"+estadio_id);
               Estadio stad=new Estadio();
               stad.setEstadio_id(estadio_id);
               stad.delete();
               response.sendRedirect("estadios/index.jsp");
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
