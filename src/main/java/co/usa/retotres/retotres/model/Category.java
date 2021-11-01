package co.usa.retotres.retotres.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *
 * @author Diego Chacon
 */
@Entity
@Table(name="category")
public class Category implements Serializable{
    //Campo llave primaria y autoincremental
    @Id
      //Campo  autoincrmental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
    * Elemento Id
    */
    private  Integer id;
    
    @Column(length = 45) 
    private String name;
    
    @Column(length = 250) 
    private String description;
    /**
    * Relacion Category -Computer
    */
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Computer> computers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }



}


