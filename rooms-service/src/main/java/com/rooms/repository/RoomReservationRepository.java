package com.rooms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rooms.model.RoomReservation;

import javax.transaction.Transactional;

/**
 * Room reservation entity repository
 * @author Adijata
 *
 */
@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
	 @Query("select id, reservationTime from RoomReservation " + 
	 		"where reservationTime <= :date")
	public List<RoomReservation> getReservationsOnSelectedDate(@Param("date") Date date);

	@Transactional
	@Query(value = "SELECT * from room_reservation where room_reservation.user_id = ?1",
			nativeQuery = true)
	List<RoomReservation> findReservationsByUser(String userId);

}
