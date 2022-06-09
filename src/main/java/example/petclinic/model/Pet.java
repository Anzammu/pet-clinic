package example.petclinic.model;

import org.aspectj.weaver.patterns.PerTypeWithin;

import java.time.LocalDate;

public class Pet {

    private PerType petType;
    private Owner owner;
    private LocalDate birthday;

    public PerType getPetType() {
        return petType;
    }

    public void setPetType(PerType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
