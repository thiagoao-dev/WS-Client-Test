package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.UsuarioWS_Service;

public class addServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServerWS/UsuarioWS.wsdl")
    private UsuarioWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Trabalho de Programação</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String nome  = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            if( add(nome, login, senha) == 1 ) {
                out.println("Cadastro feito com sucesso.");
            } else {
                out.println("Erro ao cadastrar, login["+login+"] já existe no sistema.");
            }
            
            out.println("<a href=\"index.jsp\">voltar</a>");
            out.println("</body>");
            out.println("</html>");
        
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

    private int add(java.lang.String nome, java.lang.String login, java.lang.String senha) {
        // Observe que a referência de javax.xml.ws.Service injetada, bem como os objetos da porta não são threads seguros.
        // Se a chamada das operações da porta puderem conduzir à condição de agilidade, alguma sincronização será necessária.
        ws.UsuarioWS port = service.getUsuarioWSPort();
        return port.add(nome, login, senha);
    }

}
