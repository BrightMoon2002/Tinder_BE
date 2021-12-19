package com.codegym.service.staff;

import com.codegym.model.user.Staff;
import com.codegym.repository.staff.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService implements IStaffService{
    @Autowired
    IStaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Optional<Staff> findAllByAccount_Id(Long id) {
        return staffRepository.findAllByAccount_Id(id);
    }

    @Override
    public Iterable<Staff> findAllByGenderId(Long id) {
        return staffRepository.findAllByGenderId(id);
    }
}
