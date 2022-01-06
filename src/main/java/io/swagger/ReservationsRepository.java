/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger;
import io.swagger.model.Reservations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.threeten.bp.OffsetDateTime;
/**
 *
 * @author huba.tanczos
 */

public interface ReservationsRepository extends JpaRepository<Reservations, Long>{

        @Query("SELECT r FROM Reservations r WHERE stageId =:pStageId and (dateTo > :pDateFrom OR dateFrom < :pDateTo )")
            ArrayList<Reservations> findByStageIdAndDateFromAndDateToNamedParams(
                @Param("pStageId") Long pStageId,
                @Param("pDateFrom") OffsetDateTime pDateFrom, 
                @Param("pDateTo") OffsetDateTime pDateTo
            );
    
        @Query("SELECT r FROM Reservations r WHERE r.userId = :pUserId")
            ArrayList<Reservations> findByUserIdNamedParams(
            @Param("pUserId") Long pUserId );
        
  //      ArrayList<Reservations> getReservationsByFilter(Long id, Integer status, OffsetDateTime dateFrom, OffsetDateTime dateTo);
   
}
