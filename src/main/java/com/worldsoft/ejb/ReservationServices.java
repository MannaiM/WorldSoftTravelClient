package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Passenger;
import com.worldsoft.domain.PassengerPK;
import com.worldsoft.domain.Reservation;
import com.worldsoft.domain.ReservationId;
import com.worldsoft.model.MvmentPrixHotelResultat;
import com.worldsoft.model.MvmentPrixVolResultat;
import com.worldsoft.model.PassengerModel;

@LocalBean
@Stateless

public class ReservationServices {
	@PersistenceContext
	EntityManager em;

	public void addReservation(MvmentPrixVolResultat vol, BigDecimal idRefTiers) {

		BigDecimal idRes = (BigDecimal) em
				.createQuery("select max(r.id.idReserv) from Reservation r where r.id.idRefTiers =:idRefTiers")
				.setParameter("idRefTiers", idRefTiers).getSingleResult();
		idRes = idRes.add(new BigDecimal(1));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Reservation reservation = new Reservation();
		reservation.setId(new ReservationId(idRefTiers, idRes));
		reservation.setDateReserv(new Date());
		reservation.setPrix(vol.getPrixVenteR());
		reservation.setAirPortArrive(vol.getAirArrR());
		reservation.setAirPortDepart(vol.getAirDepR());
		try {
			reservation.setStartDate(dateFormat.parse(vol.getDateResR()));
			reservation.setEndDate(dateFormat.parse(vol.getDateRetR()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.persist(reservation);

		long i = 0;
		for (PassengerModel passengervol : vol.getPassengers()) {
			i++;
			Passenger passenger = new Passenger();
			PassengerPK passengerPK = new PassengerPK();
			passengerPK.setIdPassenger(i);
			passengerPK.setIdRefTiers(idRefTiers.longValue());
			passengerPK.setIdReserv(idRes.longValue());
			passenger.setId(passengerPK);
			System.out.println("idRes+ " + idRes);
			System.out.println("idRefTiers+ " + idRefTiers);
			try {
				passenger.setDtNais(dateFormat.parse(passengervol.getDtNais()));
				passenger.setExpirDatePass(dateFormat.parse(passengervol.getExpirDatePass()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			passenger.setFirstName(passengervol.getFirstName());
			passenger.setLastName(passengervol.getLastName());
			passenger.setNumPass(passengervol.getNumPass());
			em.persist(passenger);

		}

	}

	public void addReservation(MvmentPrixHotelResultat hotel, BigDecimal idRefTiers) {

		BigDecimal idRes = (BigDecimal) em
				.createQuery("select max(r.id.idReserv) from Reservation r where r.id.idRefTiers =:idRefTiers")
				.setParameter("idRefTiers", idRefTiers).getSingleResult();
		idRes = idRes.add(new BigDecimal(1));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Reservation reservation = new Reservation();
		reservation.setId(new ReservationId(idRefTiers, idRes));
		reservation.setDateReserv(new Date());
		reservation.setPrix(hotel.getPrixVenteR());
		reservation.setHotel(hotel.getNomHotelR());
		reservation.setVilleHotel(hotel.getVilleHotelR());
		reservation.setPays(hotel.getPaysR());
		reservation.setTypeChambre(hotel.getLTypeChambreR());
		try {
			if (hotel.getDateCheckInR() != null) {
				System.out.println("hotel.getDateCheckInR() " + hotel.getDateCheckInR());
				reservation.setStartDate(dateFormat.parse(hotel.getDateCheckInR()));
			}
			if (hotel.getDateCheckInR() != null) {
				reservation.setEndDate(dateFormat.parse(hotel.getDateCheckOutR()));
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.persist(reservation);

		long i = 0;
		for (PassengerModel passengervol : hotel.getPassengers()) {
			i++;
			Passenger passenger = new Passenger();
			PassengerPK passengerPK = new PassengerPK();
			passengerPK.setIdPassenger(i);
			passengerPK.setIdRefTiers(idRefTiers.longValue());
			passengerPK.setIdReserv(idRes.longValue());
			passenger.setId(passengerPK);
			System.out.println("idRes+ " + idRes);
			System.out.println("idRefTiers+ " + idRefTiers);
			try {
				passenger.setDtNais(dateFormat.parse(passengervol.getDtNais()));
				passenger.setExpirDatePass(dateFormat.parse(passengervol.getExpirDatePass()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			passenger.setFirstName(passengervol.getFirstName());
			passenger.setLastName(passengervol.getLastName());
			passenger.setNumPass(passengervol.getNumPass());
			em.persist(passenger);

		}
	}

	public void editReservation(Reservation reservation) {
		em.merge(reservation);
	}

	public Reservation findReservation(long idReserv) {
		return (Reservation) em.createQuery("select u from Reservation u where u.id.idReserv =:p1")
				.setParameter("p1", idReserv).getResultList();
	}

	public void deletReservation(Reservation reservation) {
		em.remove(em.merge(reservation));
	}

	public List<Reservation> findAllReservation() {
		Query query = em.createQuery("select u from Reservation u");
		return query.getResultList();
	}

}
