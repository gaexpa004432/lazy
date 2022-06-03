package com.salaryup.lazyboot.main.service.impl;

import com.salaryup.lazyboot.main.mapper.MainMapper;
import com.salaryup.lazyboot.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mapper;


}
