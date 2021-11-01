package co.usa.retotres.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.retotres.retotres.model.Category;
import co.usa.retotres.retotres.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;
    public List<Category>getALL(){
        return categoryRepositorio.getALL();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepositorio.getCategory(id);
        
    }

    public Category save(Category ctg) {
        //verificacion si categoria es nuevo, en acso afirmativo Guarda
        if (ctg.getId()==null) {
            return categoryRepositorio.save(ctg);
            
        } else {//si el objeto viene con id verificacion si existe o no
            Optional<Category> consulta=categoryRepositorio.getCategory(ctg.getId());
            if(consulta.isEmpty()){
                return categoryRepositorio.save(ctg);
            }else{
                return ctg;
            }
        }
        
    }

    public Category update(Category ctg){
        if (ctg.getId()!=null){
            Optional<Category> consulta=categoryRepositorio.getCategory(ctg.getId());
            if (!consulta.isEmpty()){
                if (ctg.getName()!=null) {
                    consulta.get().setName(ctg.getName());
                }
                if (ctg.getDescription()!=null) {
                    consulta.get().setDescription(ctg.getDescription());
                }
                return categoryRepositorio.save(consulta.get());
            }  
        }
        return ctg;
    }
    public boolean deleteCategory(int categoriaId){
        Optional<Category> consulta=categoryRepositorio.getCategory(categoriaId);
        if (!consulta.isEmpty()){
            categoryRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }




}
