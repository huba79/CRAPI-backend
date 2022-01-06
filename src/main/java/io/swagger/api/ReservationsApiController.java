package io.swagger.api;

import org.threeten.bp.OffsetDateTime;
import io.swagger.model.Reservations;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.ReservationsRepository;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T18:34:52.032Z[GMT]")
@RestController
public class ReservationsApiController implements ReservationsApi {
    
    private static final String ACCEPTEDAPIKEY="ValidApiKulcs";  //baaaaaaaaasic solution
            
    private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);
    
    private final ReservationsRepository repository;
    
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationsApiController(HttpServletRequest request,ReservationsRepository pRepository) {
        this.request = request;
        this.repository=pRepository;
    }

    @Override
    @RequestMapping(value = "/reservations/",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    public ResponseEntity<Reservations> addReservation(@Parameter(in = ParameterIn.DEFAULT, description = "reservation to add", schema=@Schema()) @Valid @RequestBody Reservations body) {
        String accept = request.getHeader("Accept");
        String key = request.getHeader("X-API-KEY");
        if (accept != null && accept.contains("application/json")) {
            if(key!=null && key.equals(ACCEPTEDAPIKEY)){
                System.out.println("POST a reservation");
                try {
                    //TODO validate the reservation by NewReservationValidator
                    Reservations savedReservation = repository.saveAndFlush(body);
                    return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
                } catch (Exception e) {
                    log.error("Valami hiba tortent a mentesbel. Csekkeld a logokat.", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); //
    }

    /**
     *
     * @param id
     * @return void
     */
    @Override
    @RequestMapping(value = "/reservations/{id}",
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String key = request.getHeader("X-API-KEY");
        if (key != null && key.equals(ACCEPTEDAPIKEY)) {
            System.out.println("DELETE a reservation");
            Optional reservationExists = repository.findById(id);
            if (reservationExists.isPresent()) {        
                    repository.deleteById(id);
                    repository.flush();
                    return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    @Operation(summary = "Gets reservation by id", description = "Queries a reservation from the system", tags={ "users", "operators", "managers" })
    @RequestMapping(value = "/reservations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<Reservations> getReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        String key = request.getHeader("X-API-KEY");
        if (accept != null && accept.contains("application/json")) {
            if(key!=null && key.equals(ACCEPTEDAPIKEY)){  
                System.out.println("GET a reservation by ID");
                try {
                    Optional reservationExists = repository.findById(id);
                    if (reservationExists.isPresent()) {        
                            return new ResponseEntity<>((Reservations) reservationExists.get(), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>((Reservations) reservationExists.get(),HttpStatus.NO_CONTENT);
                    } 
                } catch (Exception e) {
                    log.error("possible error deserializing request body\n", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                } 
            } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    @RequestMapping(value = "/reservations/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    public ResponseEntity<Reservations> updateReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id, @Parameter(in = ParameterIn.DEFAULT, description = "reservation to add", schema=@Schema()) @Valid @RequestBody Reservations body){
        String accept = request.getHeader("Accept");
        String key = request.getHeader("X-API-KEY");
        if (accept != null && accept.contains("application/json")) {
            if (key!=null && key.equals(ACCEPTEDAPIKEY)) {
                System.out.println("PUT a reservation");
                try {
                    Optional found = repository.findById(id);
                    if(found.isPresent()) {
                        Reservations foundReservation = (Reservations)found.get();

                        foundReservation.setId(id);
                        foundReservation.setPondId(body.getPondId());
                        foundReservation.setUserId(body.getUserId());
                        foundReservation.setStageId(body.getStageId());
                        foundReservation.setStatus(body.getStatus());
                        foundReservation.setDateFrom(body.getDateFrom());
                        foundReservation.setDateTo(body.getDateTo());
                        Reservations saved = repository.save(foundReservation);
                        repository.flush();
                        return new ResponseEntity<>(saved,HttpStatus.OK);
                    } else {
                        Reservations saved = repository.save(body);
                        return new ResponseEntity<>(saved,HttpStatus.OK);
                    }
                } catch (Exception e) {
                    log.error("possible error deserializing request body\n", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                } 
            } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Override
    public ResponseEntity<List<Reservations>> getReservationsByUserId(Long userId) {
        String accept = request.getHeader("Accept");
        
        System.out.println("APIKEY:\t"+request.getHeader("X-API-KEY"));
        System.out.println("Accept field:\t"+accept.toString());
        System.out.println("GET reservations by userid");
        
        if (request.getHeader("X-API-KEY").toString().equals(ACCEPTEDAPIKEY)) {
            System.out.println("API key ok");
        if (accept != null && accept.contains("application/json")) {
                System.out.println("Accept heaader ok");
                System.out.println("looking up for data....");
                if(userId !=null){
                    List<Reservations> myReservations=repository.findByUserIdNamedParams(userId);
                    if (myReservations.isEmpty()) {
                        System.out.println("No data found....");
                        return new ResponseEntity<>(myReservations,HttpStatus.NO_CONTENT);
                    } 
                    else{
                        System.out.println("Data found, returning response....");
                        return new ResponseEntity<>(myReservations,HttpStatus.OK);
                    }
                } else {
                    List<Reservations> myReservations= repository.findAll();
                    return new ResponseEntity<>(myReservations,HttpStatus.OK);
                }
                
            } else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);    
    }

}
