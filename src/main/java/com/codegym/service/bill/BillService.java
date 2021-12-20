package com.codegym.service.bill;

import com.codegym.model.receipt.Bill;
import com.codegym.model.DTO.IBillDTo;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.codegym.repository.bill.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService implements IBillService{

    @Autowired
    private IBillRepository billRepository;

    @Override
    public Iterable<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void remove(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Iterable<Bill> findAllByStaff(Staff staff) {
        return billRepository.findAllByStaff(staff);
    }

    @Override
    public Iterable<Bill> findAllByChecker(Checker checker) {
        return billRepository.findAllByChecker(checker);
    }

    @Override
    public Iterable<Bill> findAllByStaffIdAndBillStatusId(Long idStaff, Long idStatus) {
        return billRepository.findAllByStaffIdAndBillStatusId(idStaff,idStatus);
    }

    @Override
    public double sumAmountBill(Long staff_id, Long checker_id) {
        return billRepository.sumAmountBill(staff_id, checker_id);
    }

    @Override
    public Iterable<IBillDTo> customShowBillWithContent() {
        return billRepository.customShowBillWithContent();
    }
}
