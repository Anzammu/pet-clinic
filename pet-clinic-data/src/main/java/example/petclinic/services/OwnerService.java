package example.petclinic.services;

import example.petclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    void delete(Owner object);

    Owner findByLastName(String lastName);

}
