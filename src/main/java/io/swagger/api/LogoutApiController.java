package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.UsersRepository;
import io.swagger.model.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-30T08:17:32.900Z[GMT]")
@RestController
public class LogoutApiController implements LogoutApi {
    
    private static final String ACCEPTEDAPIKEY ="ValidApiKulcs";  //baaaaaaaaasic solution
 
    private final UsersRepository usersrepo;
    
    private static final Logger log = LoggerFactory.getLogger(LogoutApiController.class);

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LogoutApiController(HttpServletRequest request,UsersRepository pUsersRepo) {

        this.request = request;
        this.usersrepo =pUsersRepo;
    }

    @Override
    public ResponseEntity<Void> logout(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String apikey = request.getHeader("X-API-KEY");
        if( apikey !=null && apikey.equals(ACCEPTEDAPIKEY) ) {
            Optional foundUser = usersrepo.findById(id);
            if(foundUser.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }  else {
                Users user = (Users) foundUser.get();
                user.setStatus(0);
                usersrepo.save(user);
                ResponseEntity response = new ResponseEntity<>( HttpStatus.OK);
                return response;
            }
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        
    }

}
