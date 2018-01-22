package fangcheng.springframework.lab.springboot.mybatis.h2.service;

import java.util.List;

import fangcheng.springframework.lab.springboot.mybatis.h2.mapper.NameMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class NameService {
    private static final Logger logger = LoggerFactory.getLogger(NameService.class);

    @Autowired
    private NameMapper nameMapper;

    /**
     *  voucher create
     */
    public List<String> listAllName() {
        return nameMapper.selectAllNames();
    }

}
