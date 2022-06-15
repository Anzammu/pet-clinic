package example.petclinic.services;

import example.petclinic.model.Visit;

public interface VisitService extends CrudService<Visit, Long>{
    void delete(Visit object);
}
