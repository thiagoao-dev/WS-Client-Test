package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP/WebServer</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilo.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"div-form\">\n");
      out.write("            <form action=\"add\" method=\"POST\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <legend>Cadastro de Usuário</legend>\n");
      out.write("                    <label for=\"nome\">\n");
      out.write("                        <span>Nome:</span> <input type=\"text\" id=\"nome\" name=\"nome\" value=\"\" size=\"50\" autofocus /> <br>\n");
      out.write("                    </label>\n");
      out.write("                    <label for=\"login\">\n");
      out.write("                        <span>Login:</span> <input type=\"text\" id=\"login\" name=\"login\" value=\"\" size=\"20\" /> <br>\n");
      out.write("                    </label>\n");
      out.write("                    <label for=\"senha\">\n");
      out.write("                        <span>Senha:</span> <input type=\"password\" id=\"senha\" name=\"senha\" value=\"\" size=\"20\" /> <br>\n");
      out.write("                    </label>\n");
      out.write("                    <input type=\"submit\" value=\"Cadastrar\" />\n");
      out.write("                    <input type=\"reset\" value=\"Limpar\" />\n");
      out.write("                </fieldset>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"div-list\">\n");
      out.write("            ");

            try {
                ws.UsuarioWS_Service service = new ws.UsuarioWS_Service();
                ws.UsuarioWS port = service.getUsuarioWSPort();
                // TODO process result here
                java.util.List<ws.Usuarios> result = port.list();
                
                out.println("<small> Total de registros: "+result.size()+"</small>");
                
                out.println("<table>");
                    out.println("<tr>");
                        out.println("<th>Nome</th>");
                        out.println("<th>Login</th>");
                        out.println("<th>Ação</th>");
                    out.println("</tr>");
                
                for (int i = 0; i < result.size(); i++ ){
                    out.println("<tr>");
                    out.println("<td>"+result.get(i).getNome()+"</td>");
                    out.println("<td>"+result.get(i).getUsuariosPK().getLogin()+"</td>");
                    out.println("<td><a href=\"editar.jsp?idusuario="+result.get(i).getUsuariosPK().getIdusuario()+"\">Editar<a/></br>");
                    out.println("<a href=\"remove?idusuario="+result.get(i).getUsuariosPK().getIdusuario()+"\">Excluir<a/></td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
