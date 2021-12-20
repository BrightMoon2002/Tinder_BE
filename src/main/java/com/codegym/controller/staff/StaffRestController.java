package com.codegym.controller.staff;

import com.codegym.model.receipt.Bill;
import com.codegym.model.receipt.BillDTO;
import com.codegym.model.receipt.StaffOption;
import com.codegym.model.user.Staff;
import com.codegym.model.user.StaffDTO;
import com.codegym.service.staff.IStaffService;
import com.codegym.service.staff.StaffService;
import com.codegym.service.staffoption.IStaffOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/staffs")
public class StaffRestController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IStaffOptionService staffOptionService;

    @GetMapping
    public ResponseEntity<Iterable<Staff>> findAllStaff() {
        return new ResponseEntity<>(staffService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/allstaff")
    public ResponseEntity<Iterable<StaffDTO>> getAll() {
        Iterable<Staff> staffIterable = staffService.findAll();
        List<StaffDTO> staffDTOList = new ArrayList<>();
        for (Staff b: staffIterable
        ) {

            StaffDTO staffDTO = new StaffDTO(
                    b.getId(),
                    b.getGender().getName(),
                    b.getName(),
                    b.getDob(),
                    b.getCity(),
                    b.getNationality(),
                    b.getHeight(),
                    b.getWeight(),
                    b.getDescription(),
                    b.getAccount().getId()
            );




            List<String> optionsTemp = new ArrayList<>();
            for (StaffOption s: staffOptionService.findAll()) {
                if (s.getStaff().getId().equals(b.getId())) {
                    optionsTemp.add(s.getOption().getName());
                }
            }

            String options = String.join(", ",optionsTemp);
            staffDTO.setAvatarUrl1(b.getAvatarList().get(0).getImage());
            staffDTO.setAvatarUrl2(b.getAvatarList().get(1).getImage());
            staffDTO.setAvatarUrl3(b.getAvatarList().get(2).getImage());
            staffDTO.setOptions(options);
            staffDTOList.add(staffDTO);





        }





        return new ResponseEntity<>(staffDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff){
        staffService.save(staff);
        return new ResponseEntity<>(staff,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id,@RequestBody Staff staff){
        Optional<Staff> staff1 = staffService.findById(id);
        if(!staff1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staff.setId(staff1.get().getId());
        staffService.save(staff);
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Staff>findById(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> delete(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.remove(id);
        return new ResponseEntity<>(staff.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{idAccount}")
    public ResponseEntity<Staff> findByAccountID(@PathVariable Long idAccount){
        Optional<Staff> staff = staffService.findAllByAccount_Id(idAccount);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }

    @GetMapping("/gender/{id}")
    public ResponseEntity<Iterable<StaffDTO>> getAllByGender(@PathVariable Long id) {
        Iterable<Staff> staffIterable = staffService.findAllByGenderId(id);
        List<StaffDTO> staffDTOList = new ArrayList<>();
        for (Staff b: staffIterable
        ) {

            StaffDTO staffDTO = new StaffDTO(
                    b.getId(),
                    b.getGender().getName(),
                    b.getName(),
                    b.getDob(),
                    b.getCity(),
                    b.getNationality(),
                    b.getHeight(),
                    b.getWeight(),
                    b.getDescription(),
                    b.getAccount().getId()
            );



            List<String> optionsTemp = new ArrayList<>();
            for (StaffOption s: staffOptionService.findAll()) {
                if (s.getStaff().getId().equals(b.getId())) {
                    optionsTemp.add(s.getOption().getName());
                }
            }

            String options = String.join(", ",optionsTemp);
            staffDTO.setAvatarUrl1(b.getAvatarList().get(0).getImage());
            staffDTO.setAvatarUrl2(b.getAvatarList().get(1).getImage());
            staffDTO.setAvatarUrl3(b.getAvatarList().get(2).getImage());
            staffDTO.setOptions(options);
            staffDTOList.add(staffDTO);





        }





        return new ResponseEntity<>(staffDTOList, HttpStatus.OK);
    }


}
