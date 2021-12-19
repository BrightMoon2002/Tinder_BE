package com.codegym.service.billOption;

import com.codegym.model.receipt.BillOption;
import com.codegym.repository.bill_option.IBillOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillOptionService implements IBillOptionService{

    @Autowired
    private IBillOptionRepository billOptionRepository;

    @Override
    public Iterable<BillOption> findAll() {
        return billOptionRepository.findAll();
    }

    @Override
    public Optional<BillOption> findById(Long id) {
        return billOptionRepository.findById(id);
    }

    @Override
    public BillOption save(BillOption billOption) {
        return billOptionRepository.save(billOption);
    }

    @Override
    public void remove(Long id) {
        billOptionRepository.deleteById(id);
    }

    @Override
    public Page<BillOption> findAll(Pageable pageable) {
        return billOptionRepository.findAll(pageable);
    }

    @Override
    public Iterable<BillOption> findAllByBillId(Long id) {
        return billOptionRepository.findAllByBillId(id);
    }
}
