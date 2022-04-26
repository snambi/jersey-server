package org.github.api.test.jerseyserver;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Component
@Path("/")
public class ImageController {

    @Context
    private Configuration configuration;

    // @QueryParam("k") int k,
    @POST
    @Path("/image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadImage( @FormDataParam("image") InputStream fileInputStream )
            throws Exception{

        BufferedImage image = ImageIO.read(fileInputStream);
        System.out.println("uploaded image");

        return Response.ok("done").build();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(){
        return Response.ok("Hello").build();
    }

}
