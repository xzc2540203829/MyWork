package restful.api;

import org.jboss.resteasy.annotations.Form;
import restful.bean.Ciper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/letter")
public class createCipherKey {
    @POST
    @Produces("text/html;charset=UTF-8")
    @Path("/createCipherKey")
    public String testQuery(@Form Ciper ciper) {
        ciper.setZh_key(XORcipherText.disturbByRadomNum(XORcipherText.Algorithm_B(ciper.getMess_cipher1(), ciper.getStudentNum())));
        return String.format(ciper.getZh_key());
    }
}