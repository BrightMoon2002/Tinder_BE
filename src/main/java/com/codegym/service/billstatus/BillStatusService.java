package com.codegym.service.billstatus;

import com.codegym.model.receipt.BillStatus;
import com.codegym.repository.billstatus.IBillStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillStatusService implements IBillStatusService {
    @Autowired
    private IBillStatusRepository billStatusRepository;

    @Override
    public Iterable<BillStatus> findAll() {
        return billStatusRepository.findAll();
    }

    @Override
    public Optional<BillStatus> findById(Long id) {
        return billStatusRepository.findById(id);
    }

    @Override
    public BillStatus save(BillStatus billStatus) {
        return billStatusRepository.save(billStatus);
    }

    @Override
    public void remove(Long id) {
        billStatusRepository.deleteById(id);
    }

    @Override
    public Page<BillStatus> findAll(Pageable pageable) {
        return billStatusRepository.findAll(pageable);
    }

    @Override
    public BillStatus findBillStatusByName(String name) {
        return billStatusRepository.findBillStatusByName(name);
    }
}
