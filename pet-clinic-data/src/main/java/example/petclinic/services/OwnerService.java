package example.petclinic.services;

import example.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    void delete(Owner object);

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
