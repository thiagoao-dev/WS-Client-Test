<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP/WebServer</title>
    </head>
    <body>
        <h1>Trabalho de Programação</h1>
        <div>
            <h2>Cadastro de Usuários</h2>
            <form action="add" method="POST">
                <fieldset>
                    <legend>Formulário</legend>
                    <label for="nome">
                        <span>Nome:</span> <input type="text" id="nome" name="nome" value="" size="50" autofocus /> <br>
                    </label>
                    <label for="login">
                        <span>Login:</span> <input type="text" id="login" name="login" value="" size="20" /> <br>
                    </label>
                    <label for="senha">
                        <span>Senha:</span> <input type="password" id="senha" name="senha" value="" size="20" /> <br>
                    </label>
                    <input type="submit" value="Cadastrar" />
                    <input type="reset" value="Limpar" />
                </fieldset>
            </form>
        </div>
        <div>
            <%-- start web service invocation --%><hr/>
            <%
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
                    out.println("<td><a href=\"editar.jsp?idusuario="+result.get(i).getUsuariosPK().getIdusuario()+"\">Editar<a/></td>");
                    out.println("<td><a href=\"remove?idusuario="+result.get(i).getUsuariosPK().getIdusuario()+"\">Excluir<a/></td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
            <%-- end web service invocation --%><hr/>
        </div>
    </body>
</html>
