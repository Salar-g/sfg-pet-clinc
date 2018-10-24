package com.springframework.sfgpetclinic.bootstrap;

import com.springframework.sfgpetclinic.model.*;
import com.springframework.sfgpetclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetSerivce vetSerivce;
    private final PetTypeService petTypeService;
    private final SpecialityService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetSerivce vetSerivce, PetTypeService petTypeService, SpecialityService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetSerivce = vetSerivce;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

        loadData();
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadialogy = specialtyService.save(radiology);

        Speciality sugery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(sugery);

        Speciality dentistery = new Speciality();
        radiology.setDescription("Dentistery");
        Speciality savedDentistery = specialtyService.save(dentistery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Mcway");
        owner1.setCity("Miami");
        owner1.setTelephone("1234566565");


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        owner2.setAddress("456 Mcway");
        owner2.setCity("Huston");
        owner2.setTelephone("654321");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("kitty");
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        System.out.println("GetPet: " + catVisit.getPet() + '\n' + "n ...getpet.getowner : " + catVisit.getPet().getOwner() + '\n' +
                "...getpet.getid: " + catVisit.getPet().getId() + '\n' + "... pet.owner.getid " + catVisit.getPet().getOwner().getId());

        visitService.save(catVisit);
        System.out.println("Owners Loaded....");


        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadialogy);

        vetSerivce.save(vet1);

        Vet vet2 = new Vet();


        vet2.setFirstName("Jessie");
        vet2.setLastName("Pot");
        vetSerivce.save(vet2);
        vet2.getSpecialties().add(savedDentistery);
        System.out.println("Vets Loaded");
    }


}
