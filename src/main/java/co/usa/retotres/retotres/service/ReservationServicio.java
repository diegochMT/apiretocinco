package co.usa.retotres.retotres.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Reservation;
import co.usa.retotres.retotres.reportes.ContadorClient;
import co.usa.retotres.retotres.reportes.StatusReservation;
import co.usa.retotres.retotres.repository.ReservationRepositorio;


@Service 
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio;
    public List<Reservation>getALL(){
        return reservationRepositorio.getAll();
    }

   
    public Optional<Reservation>getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    public Reservation save(Reservation rsv){
        if(rsv.getIdReservation()==null){
            return reservationRepositorio.save(rsv);
        }else{
            Optional<Reservation> e= reservationRepositorio.getReservation(rsv.getIdReservation());
            if(e.isEmpty()){
                return reservationRepositorio.save(rsv);
            }else{
                return rsv;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepositorio.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepositorio.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservation reporteStatusServicio (){
        List<Reservation>completed= reservationRepositorio.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepositorio.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservation(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepositorio.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorClient> reporteClientesServicio(){
            return reservationRepositorio.getClientRepositorio();
        } 
}



