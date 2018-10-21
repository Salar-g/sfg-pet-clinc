package com.springframework.sfgpetclinic.service.map;


import com.springframework.sfgpetclinic.model.Speciality;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.service.SpecialityService;
import com.springframework.sfgpetclinic.service.VetSerivce;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetSerivce {
    private SpecialityService specialtyService;

    public VetServiceMap(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size()>0){
            object.getSpecialties().forEach(speciality -> {
                if (speciality.getId()==null){
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}