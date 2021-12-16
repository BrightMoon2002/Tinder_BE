package com.codegym.service.gender;

import com.codegym.model.user.Gender;
import com.codegym.repository.gender.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class GenderService implements IGenderService{

    @Autowired
    IGenderRepository genderRepository;

    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return genderRepository.findById(id);
    }

    @Override
    public Gender save(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public void remove(Long id) {
        genderRepository.deleteById(id);
    }

    @Override
    public Page<Gender> findAll(Pageable pageable) {
        return genderRepository.findAll(pageable);
    }
}
