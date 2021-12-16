package com.codegym.repository.staffoption;

import com.codegym.model.receipt.StaffOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffOptionRepository extends JpaRepository<StaffOption, Long> {

}
