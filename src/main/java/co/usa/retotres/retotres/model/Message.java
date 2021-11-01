package co.usa.retotres.retotres.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Diego Chacon
 */
@Entity
@Table (name = "message")
public class Message implements Serializable{
    //Campo llave primaria y autoincremental
    @Id
      //Campo  autoincrmental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idMessage;
    private String messageText;
    /**
    * Relacion Message -Computer
    */
   @ManyToOne
   @JoinColumn(name="id")
   @JsonIgnoreProperties({"messages","reservations"})
   private Computer computer;
     /**
    * Relacion Client - Message
    */
   @ManyToOne
   @JoinColumn(name="clientId")
   @JsonIgnoreProperties({"messages","reservations"})
   private Client client;

public Integer getIdMessage() {
    return idMessage;
}

public void setIdMessage(Integer idMessage) {
    this.idMessage = idMessage;
}

public String getMessageText() {
    return messageText;
}

public void setMessageText(String messageText) {
    this.messageText = messageText;
}

public Computer getComputer() {
    return computer;
}

public void setComputer(Computer computer) {
    this.computer = computer;
}

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}
   

   
}
