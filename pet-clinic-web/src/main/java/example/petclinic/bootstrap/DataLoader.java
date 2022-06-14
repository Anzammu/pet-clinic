package example.petclinic.bootstrap;

import example.petclinic.model.Owner;
import example.petclinic.model.Vet;
import example.petclinic.services.OwnerService;
import example.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 =new Owner();
        owner1.setFirstName("OwnerNameTest1");
        owner1.setLastName("OwnerLastNameTest1");

        ownerService.save(owner1);

        Owner owner2 =new Owner();
        owner2.setFirstName("OwnerNameTest2");
        owner2.setLastName("OwnerLastNameTest2");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 =new Vet();
        vet1.setFirstName("VetNameTest1");
        vet1.setLastName("VetLastNameTest1");

        vetService.save(vet1);

        Vet vet2 =new Vet();
        vet2.setFirstName("VetNameTest2");
        vet2.setLastName("VetLastNameTest2");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
