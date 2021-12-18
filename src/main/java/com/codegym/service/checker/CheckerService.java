package com.codegym.service.checker;

import com.codegym.model.user.Checker;
import com.codegym.repository.checker.ICheckerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckerService implements ICheckerService{

    @Autowired
    ICheckerRepository checkerRepository;

    @Override
    public Iterable<Checker> findAll() {
        return checkerRepository.findAll();
    }

    @Override
    public Optional<Checker> findById(Long id) {
        return checkerRepository.findById(id);
    }

    @Override
    public Checker save(Checker checker) {
        return checkerRepository.save(checker);
    }

    @Override
    public void remove(Long id) {
        checkerRepository.deleteById(id);
    }

    @Override
    public Page<Checker> findAll(Pageable pageable) {
        return checkerRepository.findAll(pageable);
    }

    @Override
    public Optional<Checker> findAllByAccount_Id(Long id) {
        return checkerRepository.findAllByAccount_Id(id);
    }
}
