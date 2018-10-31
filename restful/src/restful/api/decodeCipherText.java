package restful.api;

import org.jboss.resteasy.annotations.Form;
import restful.bean.Ciper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/letter")
public class decodeCipherText {
    @POST
    @Produces("text/html;charset=UTF-8")
    @Path("/decodeCipherText")
    public String testQuery(@Form Ciper ciper) {
        ciper.setZh_mess(XORcipherText.Algorithm_B(XORcipherText.Algorithm_A(ciper.getZh_cipher()),XORcipherText.Algorithm_A(ciper.getZh_key())));
        return String.format(ciper.getZh_mess());
    }
}

