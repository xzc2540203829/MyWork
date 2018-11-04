package restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.awt.image.BufferedImage;

@Path("/monaLisa")
public class MonaLisa_Decode_API {
    @POST
    @Consumes("monaLisa/input")
    @Produces("monaLisa/output")
    @Path("/uncover")
    public BufferedImage uncover(BufferedImage MonaLisa_Bmp24Bit) {
        return MonaLisa_Bmp24Bit;
    }
}
