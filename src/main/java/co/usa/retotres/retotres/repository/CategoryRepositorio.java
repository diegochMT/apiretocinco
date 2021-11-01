package co.usa.retotres.retotres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.retotres.retotres.model.Category;
import co.usa.retotres.retotres.repository.crud.CategoryCrudRepositorio;

@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio categoryCrudRepositorio;
    
    public List<Category> getALL() {
        return (List<Category>)categoryCrudRepositorio.findAll();
        
    }
    
    public Optional<Category>getCategory(int id){
        return categoryCrudRepositorio.findById(id);
    }

    public Category save(Category ctg){
        return categoryCrudRepositorio.save(ctg);
    }

    public void delete(Category ctg){
        categoryCrudRepositorio.delete(ctg);
    }
    
}
