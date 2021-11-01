package co.usa.retotres.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retotres.retotres.model.Client;
import co.usa.retotres.retotres.repository.crud.ClientCrudRepositorio;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientCrudRepositorio clientCrudRepositorio;
    public List<Client> getALL() {
        return (List<Client>)clientCrudRepositorio.findAll();        
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepositorio.findById(id);
    }

    public Client save(Client clt){
        return clientCrudRepositorio.save(clt);
    }
    public void delete(Client clt){
        clientCrudRepositorio.delete(clt);
    }
}
