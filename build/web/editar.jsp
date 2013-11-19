<%-- 
    Document   : editar
    Created on : 17/11/2013, 02:55:47
    Author     : Note
--%>
<%

    int    idusuario = 0;
    String nome  = "";
    String login = "";
    String senha = "";

try {
    ws.UsuarioWS_Service service = new ws.UsuarioWS_Service();
    ws.UsuarioWS port = service.getUsuarioWSPort();
     // TODO initialize WS operation arguments here
    idusuario = Integer.parseInt(request.getParameter("idusuario"));
    // TODO process result here
    ws.Usuarios result = port.usuario(idusuario);
    
    nome  = result.getNome();
    login = result.getUsuariosPK().getLogin();
    senha = result.getSenha();
    
} catch (Exception ex) {
    // TODO handle custom exceptions here
}
%>
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
            <h2>Editar Usuário</h2>
            <a href="index.jsp">voltar</a>
            <form action="update" method="POST">
                <fieldset>
                    <legend>Formulário</legend>
                    <label for="nome">
                        <span>Nome:</span> <input type="text" id="nome" name="nome" value="<% out.print(nome); %>" size="50" autofocus /> <br>
                    </label>
                    <label for="login">
                        <span>Login:</span> <input type="text" id="login" name="login" value="<% out.print(login); %>" size="20" readonly="true" /> <br>
                    </label>
                    <label for="senha">
                        <span>Senha:</span> <input type="password" id="senha" name="senha" value="<% out.print(senha); %>" size="20" /> <br>
                    </label>
                    <input type="hidden" name="idusuario" value="<% out.print(idusuario); %>" />
                    <input type="submit" value="Atualizar" />
                </fieldset>
            </form>
        </div>
    </body>
</html>
