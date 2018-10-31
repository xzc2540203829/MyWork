package restful.api;


import org.jboss.resteasy.annotations.Form;
import restful.bean.Ciper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/letter")
public class getCipherKey {
    @POST
    @Produces("text/html;charset=UTF-8")
    @Path("/getCipherKey")
    public String testQuery(@Form Ciper ciper){
        System.out.println(ciper.getCipher1());
        ciper.setMess_cipher1(XORcipherText.Algorithm_A(ciper.getCipher1()));
        return String.format(ciper.getMess_cipher1());
    }
}
