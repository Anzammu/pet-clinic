package example.petclinic.bootstrap;

import example.petclinic.model.*;
import example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType bird =new PetType();
        bird.setName("Bird");
        PetType savedBirdPetType= petTypeService.save(bird);

        PetType tiger =new PetType();
        bird.setName("Tiger");
        PetType savedTigerPetType= petTypeService.save(tiger);

        Speciality specialityOne =new Speciality();
        specialityOne.setDescription("speciality1");
        Speciality savedspecialityOne= specialityService.save(specialityOne);

        Speciality specialityTwo =new Speciality();
        specialityTwo.setDescription("speciality2");
        Speciality savedspecialityTwo = specialityService.save(specialityTwo);


        Speciality specialityThree =new Speciality();
        specialityThree.setDescription("speciality3");
        Speciality savedspecialityThree= specialityService.save(specialityThree);

        Owner owner1 =new Owner();
        owner1.setFirstName("OwnerNameTest1");
        owner1.setLastName("OwnerLastNameTest1");
        owner1.setAddress("OwnerAddressTest1");
        owner1.setCity("CityTest1");
        owner1.setTelephone("123456");



        Pet testonePet= new Pet();
        testonePet.setPetType(savedBirdPetType);
        testonePet.setOwner(owner1);
        testonePet.setBirthday(LocalDate.now());
        testonePet.setName("AnimalTest1");
        owner1.getPets().add(testonePet);

        ownerService.save(owner1);

        Owner owner2 =new Owner();
        owner2.setFirstName("OwnerNameTest2");
        owner2.setLastName("OwnerLastNameTest2");
        owner2.setAddress("OwnerAddressTest2");
        owner2.setCity("CityTest2");
        owner2.setTelephone("7891011");

        Pet testtwoPet= new Pet();
        testtwoPet.setPetType(savedTigerPetType);
        testtwoPet.setOwner(owner2);
        testtwoPet.setBirthday(LocalDate.now());
        testtwoPet.setName("AnimalTest2");
        owner2.getPets().add(testtwoPet);

        ownerService.save(owner2);

        Visit birdVisit = new Visit();
        birdVisit.setPet(testtwoPet);
        birdVisit.setDate(LocalDate.now());
        birdVisit.setDescription("Description2");

        visitService.save(birdVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 =new Vet();
        vet1.setFirstName("VetNameTest1");
        vet1.setLastName("VetLastNameTest1");
        vet1.getSpecialities().add(savedspecialityOne);

        vetService.save(vet1);

        Vet vet2 =new Vet();
        vet2.setFirstName("VetNameTest2");
        vet2.setLastName("VetLastNameTest2");
        vet2.getSpecialities().add(savedspecialityThree);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
