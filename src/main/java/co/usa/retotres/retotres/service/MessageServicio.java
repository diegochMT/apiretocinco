package co.usa.retotres.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Message;
import co.usa.retotres.retotres.repository.MessageRepositorio;


@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepositorio;

    public List<Message>getAll(){
        return messageRepositorio.getALL();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepositorio.getMessage(id);
        
    }
    
   public Message save(Message mse){
       if(mse.getIdMessage()==null){
           return messageRepositorio.save(mse);
       }else{
           Optional<Message> consulta=messageRepositorio.getMessage(mse.getIdMessage());
           if(consulta.isEmpty()){
               return messageRepositorio.save(mse);
           }else{
               return mse;
           }
       }
   }
   public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepositorio.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepositorio.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepositorio.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
