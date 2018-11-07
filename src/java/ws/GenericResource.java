/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.client.ClientBuilder;

/**
 * REST Web Service
 *
 * @author Aluno
 */
@Path("logon")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Pessoa getXml() {
        Pessoa p = new Pessoa();
        p.setId(1);
        p.setNome("Metodo 1 ");
      return p;
    }
        
    @GET
    @Path("/{id}/{nome}")
    @Produces("application/json")
    public Pessoa getPessoa(
            @PathParam("id") int id, 
            @PathParam("nome") String nome) {
        
        Pessoa p = new Pessoa();
        p.setId(id);
        p.setNome(nome);
      return p;
    }
    
    @GET
    @Path("/soma/{id1}/{id2}/")
    public String getSoma(
            @PathParam("id1") int id1, 
            @PathParam("id2") int id2) {

        return String.valueOf(id1 * id2);
    }
    
    
    @GET
    @Path("/cep/{c}/")
    public String getEndereco(@PathParam("c") String cep) 
    {

            return ClientBuilder.newClient()
                 .target("https://viacep.com.br/ws/")
                 .path(cep)
                 .path("json")
                 .request()
                  .get(String.class);
    }
    
    
    @GET
    @Path("/pessoa/")
    public String getPessoa() 
    {
            return ClientBuilder.newClient()
                 .target("https://randomuser.me/api/")
                 .request()
                  .get(String.class);
    }
    
    @GET
    @Path("/pessoa/{nacionalidade}")
    public String getPessoa(
            @PathParam("nacionalidade") String nacionalidade ) 
    {
            return ClientBuilder.newClient()
                 .target("https://randomuser.me/api/")
                 .queryParam("nat", nacionalidade)
                 .queryParam("gender", "male")
                 .request()
                  .get(String.class);
    }
    
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putXml(String content) {
    }
}
