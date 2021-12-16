package com.codegym.service.option;

import com.codegym.model.receipt.Option;
import com.codegym.repository.option.IOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionService implements IOptionService{
    @Autowired
    IOptionRepository optionRepository;


    @Override
    public Iterable<Option> findAll() {
        return optionRepository.findAll();
    }

    @Override
    public Optional<Option> findById(Long id) {
        return  optionRepository.findById(id);
    }

    @Override
    public Option save(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public void remove(Long id) {
        optionRepository.deleteById(id);
    }
}
