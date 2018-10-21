package com.springframework.sfgpetclinic.bootstrap;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.service.OwnerService;
import com.springframework.sfgpetclinic.service.VetSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetSerivce vetSerivce;

    @Autowired
    public DataLoader(OwnerService ownerService, VetSerivce vetSerivce) {
        this.ownerService = ownerService;
        this.vetSerivce = vetSerivce;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1 =new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2=new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");

        ownerService.save(owner2);

        System.out.println("Owners Loaded....");

        Vet vet1= new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetSerivce.save(vet1);

        Vet vet2= new Vet();


        vet2.setFirstName("Jessie");
        vet2.setLastName("Pot");
        vetSerivce.save(vet2);

        System.out.println("Vets Loaded");
    }



}
