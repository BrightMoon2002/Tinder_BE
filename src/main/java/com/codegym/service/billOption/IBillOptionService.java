package com.codegym.service.billOption;

import com.codegym.model.receipt.BillOption;
import com.codegym.service.IGeneralService;

public interface IBillOptionService extends IGeneralService<BillOption> {
    Iterable<BillOption> findAllByBillId(Long id);
}
