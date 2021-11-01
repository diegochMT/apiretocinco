package co.usa.retotres.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Computer;
import co.usa.retotres.retotres.repository.ComputerRepositorio;

@Service
public class ComputerServicio {
    @Autowired
    private ComputerRepositorio computerRepositorio;

    public List<Computer>getALL(){
        return computerRepositorio.getALL();
    }

    public Optional<Computer>getComputer(int id){
        return computerRepositorio.getComputer(id);
    }
    
    public Computer save(Computer computer) {
        //Verificamos si el Computer es nuevo y de ser asi, se guarda
        if (computer.getId()==null){
            return computerRepositorio.save(computer);
        }else{//si el objeto viene con un numId verificamos si existe o no
            Optional<Computer> consulta=computerRepositorio.getComputer(computer.getId());
            if (consulta.isEmpty()){
                return computerRepositorio.save(computer);
            }else{
                return computer;
            }

        }
        
    }
    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> consulta=computerRepositorio.getComputer(computer.getId());
            if(!consulta.isEmpty()){
                if(computer.getName()!=null){
                    consulta.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    consulta.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    consulta.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    consulta.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    consulta.get().setCategory(computer.getCategory());
                }
                computerRepositorio.save(consulta.get());
                return consulta.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            computerRepositorio.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
