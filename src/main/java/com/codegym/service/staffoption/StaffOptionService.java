package com.codegym.service.staffoption;

import com.codegym.model.receipt.StaffOption;
import com.codegym.repository.staffoption.IStaffOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffOptionService implements IStaffOptionService{
    @Autowired
    IStaffOptionRepository staffOptionRepository;

    @Override
    public Iterable<StaffOption> findAll() {
        return staffOptionRepository.findAll();
    }

    @Override
    public Optional<StaffOption> findById(Long id) {
        return staffOptionRepository.findById(id);
    }

    @Override
    public StaffOption save(StaffOption staffOption) {
        return staffOptionRepository.save(staffOption);
    }

    @Override
    public void remove(Long id) {
        staffOptionRepository.deleteById(id);
    }
}
