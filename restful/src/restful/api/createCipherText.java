package restful.api;


import org.jboss.resteasy.annotations.Form;
import restful.bean.Ciper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/letter")
public class createCipherText {
    @POST
    @Produces("text/html;charset=UTF-8")
    @Path("/createCipherText")
    public String testQuery(@Form Ciper ciper) {
        ciper.setZh_cipher(XORcipherText.disturbByRadomNum(XORcipherText.Algorithm_B(ciper.getZh_mess(),XORcipherText.Algorithm_A(ciper.getZh_key()))));
        return String.format(ciper.getZh_cipher());
    }
}
