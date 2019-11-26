package com.hy.it.service;

import com.hy.it.mapper.TransPortMapper;
import com.hy.it.pojo.TransPort;
import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransPortService {
    @Autowired
    private TransPortMapper transPortMapper;
    public Long select(TransPort transPort) {
        System.out.println(transPort);
        Long transportid = transPortMapper.selectIdByname(transPort.getName());
        if(transportid == null){
            throw new HyzgException(ExceptionEnums.TRANSPORT_NOT_FOUND);
        }
        return transportid;
    }
}
