package co.usa.retotres.retotres.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import co.usa.retotres.retotres.model.Category;
import co.usa.retotres.retotres.service.CategoryServicio;



@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CategoryControlador {
    @Autowired
    private CategoryServicio categoryServicio;
    @GetMapping("/all")
    public List<Category>getCategories(){
        return categoryServicio.getALL();
    }
    @GetMapping("/{id}")
    public Optional<Category>getCategory(@PathVariable("id")int id){
        return categoryServicio.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) 
    public Category save(@RequestBody Category ctg) {
        return categoryServicio.save(ctg);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category ctg){
        return categoryServicio.update(ctg);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id")int categoryId) {
        return categoryServicio.deleteCategory(categoryId);
    }



}
