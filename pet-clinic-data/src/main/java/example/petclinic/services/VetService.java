package example.petclinic.services;

import example.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {

    void delete(Vet object);
}
