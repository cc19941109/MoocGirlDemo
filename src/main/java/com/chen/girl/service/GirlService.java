package com.chen.girl.service;

import com.chen.girl.domain.Girl;
import com.chen.girl.enums.ResultEnum;
import com.chen.girl.exception.GirlException;
import com.chen.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    @Transactional
    public void insert() {
        Girl girl = new Girl();
        girl.setAge(12);
        girl.setCupSize("V");
        girlRepository.save(girl);

    }

    public void getAgeById(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 12) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age>=10&&age < 18) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }


    }

    /**
     * 通过Id查找女生
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }

}