package co.usa.retotres.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retotres.retotres.model.Message;
import co.usa.retotres.retotres.repository.crud.MessageCrudRepositorio;

@Repository

public class MessageRepositorio {
    @Autowired
    private MessageCrudRepositorio messageCrudRepositorio;

    public List<Message> getALL(){
        return(List<Message>)messageCrudRepositorio.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepositorio.findById(id);
        
    }

    public Message save(Message mse) {
        return messageCrudRepositorio.save(mse);
        
    }
    public void delete(Message mse){
        messageCrudRepositorio.delete(mse);
    }

    
}
