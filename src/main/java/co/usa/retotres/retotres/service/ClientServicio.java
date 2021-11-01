package co.usa.retotres.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Client;
import co.usa.retotres.retotres.reportes.ContadorClient;
import co.usa.retotres.retotres.reportes.StatusReservation;
import co.usa.retotres.retotres.repository.ClientRepositorio;
import co.usa.retotres.retotres.repository.ReservationRepositorio;
import co.usa.retotres.retotres.repository.crud.ReservationCrudRepositorio;


@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio;

    public List<Client>getAll(){
        return clientRepositorio.getALL();
    }

    public Optional<Client>getClient(int id){
        return clientRepositorio.getClient(id);
    }

    public Client save(Client clt) {
        //Verificamos si el Client es nuevo y de ser asi se guarda
        if (clt.getIdClient()==null){
            return clientRepositorio.save(clt);
        }else{//si el objeto viene con un Id verificamos si existe o no
            Optional<Client> consulta=clientRepositorio.getClient(clt.getIdClient());
            if (consulta.isEmpty()){
                return clientRepositorio.save(clt);

            }else{
                return clt;

            }
        }
    }

    public Client update (Client client){
        if(client.getIdClient()!=null){
            Optional<Client> consulta= clientRepositorio.getClient(client.getIdClient());
            if(!consulta.isEmpty()){
                if(client.getName()!=null){
                    consulta.get().setName(client.getName());
                 }
                 if(client.getAge()!=null){
                    consulta.get().setAge(client.getAge());
                 }
                if(client.getPassword()!=null){
                    consulta.get().setPassword(client.getPassword());
                 }
                 clientRepositorio.save(consulta.get());
                 return consulta.get();
            }else{
                return client;
        }
    }else{
        return client;
    }
    

    }
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepositorio.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    
}

