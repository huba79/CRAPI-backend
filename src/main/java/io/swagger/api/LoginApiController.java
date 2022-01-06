package io.swagger.api;

import io.swagger.UsersRepository;
import io.swagger.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Login;
import io.swagger.model.LoginResponse;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-30T08:17:32.900Z[GMT]")
@RestController
public class LoginApiController implements LoginApi {
    
    private static final String ACCEPTEDAPIKEY ="ValidApiKulcs";  //baaaaaaaaasic solution
 
    private final UsersRepository usersrepo;

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(HttpServletRequest request,UsersRepository pUsersRepo) {
        this.request = request;
        this.usersrepo = pUsersRepo;
    }

    @Override
    public ResponseEntity<LoginResponse> login(@Parameter(in = ParameterIn.DEFAULT, description = "Login data", schema=@Schema()) @Valid @RequestBody Login body) {
        String apikey = request.getHeader("X-API-KEY");
        if( apikey !=null && apikey.equals(ACCEPTEDAPIKEY) ) {
            System.out.println("loginname:\t"+body.getLoginname()+"\npassword:\t"+body.getPassword()+"\n"+"client:\t"+request.getHeader("sender"));
            ArrayList<Users> foundusers= usersrepo.findUsersByLoginname(body.getLoginname());
            if(foundusers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if(foundusers.size()>1){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } else { //found exactly 1 user
                Users foundUser = foundusers.get(0);
                if ( body.getPassword().equals(foundUser.getPassword()) ) {
                    foundUser.setStatus(1);
                    usersrepo.save(foundUser);
                    //return appropiate response
                    return new ResponseEntity<>(new LoginResponse(foundUser.getId(),foundUser.getDisplayname()), HttpStatus.OK);
                 
                } else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        
    }

}
