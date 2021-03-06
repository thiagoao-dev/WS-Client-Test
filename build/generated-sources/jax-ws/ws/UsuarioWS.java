
package ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UsuarioWS", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UsuarioWS {


    /**
     * 
     * @param login
     * @param nome
     * @param senha
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://ws/", className = "ws.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://ws/", className = "ws.AddResponse")
    @Action(input = "http://ws/UsuarioWS/addRequest", output = "http://ws/UsuarioWS/addResponse")
    public int add(
        @WebParam(name = "nome", targetNamespace = "")
        String nome,
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "senha", targetNamespace = "")
        String senha);

    /**
     * 
     * @param idusuario
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "remove", targetNamespace = "http://ws/", className = "ws.Remove")
    @ResponseWrapper(localName = "removeResponse", targetNamespace = "http://ws/", className = "ws.RemoveResponse")
    @Action(input = "http://ws/UsuarioWS/removeRequest", output = "http://ws/UsuarioWS/removeResponse")
    public int remove(
        @WebParam(name = "idusuario", targetNamespace = "")
        int idusuario);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://ws/", className = "ws.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://ws/", className = "ws.CountResponse")
    @Action(input = "http://ws/UsuarioWS/countRequest", output = "http://ws/UsuarioWS/countResponse")
    public int count();

    /**
     * 
     * @return
     *     returns java.util.List<ws.Usuarios>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "list", targetNamespace = "http://ws/", className = "ws.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://ws/", className = "ws.ListResponse")
    @Action(input = "http://ws/UsuarioWS/listRequest", output = "http://ws/UsuarioWS/listResponse")
    public List<Usuarios> list();

    /**
     * 
     * @param idusuario
     * @param nome
     * @param senha
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://ws/", className = "ws.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://ws/", className = "ws.UpdateResponse")
    @Action(input = "http://ws/UsuarioWS/updateRequest", output = "http://ws/UsuarioWS/updateResponse")
    public int update(
        @WebParam(name = "idusuario", targetNamespace = "")
        int idusuario,
        @WebParam(name = "nome", targetNamespace = "")
        String nome,
        @WebParam(name = "senha", targetNamespace = "")
        String senha);

    /**
     * 
     * @param idusuario
     * @return
     *     returns ws.Usuarios
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "usuario", targetNamespace = "http://ws/", className = "ws.Usuario")
    @ResponseWrapper(localName = "usuarioResponse", targetNamespace = "http://ws/", className = "ws.UsuarioResponse")
    @Action(input = "http://ws/UsuarioWS/usuarioRequest", output = "http://ws/UsuarioWS/usuarioResponse")
    public Usuarios usuario(
        @WebParam(name = "idusuario", targetNamespace = "")
        int idusuario);

}
