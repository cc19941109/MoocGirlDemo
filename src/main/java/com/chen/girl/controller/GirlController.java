package com.chen.girl.controller;

import com.chen.girl.aspect.HttpAspect;
import com.chen.girl.domain.Result;
import com.chen.girl.repository.GirlRepository;
import com.chen.girl.domain.Girl;
import com.chen.girl.service.GirlService;
import com.chen.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    //当RequestParam，PathVariable同时存在以requestParam 为主

    @Autowired
    GirlRepository girlRepository;
    @Autowired
    GirlService girlService;

    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls() {
        logger.info("getGirls...");
        return girlRepository.findAll();
    }


    /**
     * 加入一个
     */
    @PostMapping(value = "/girls")
    public Object postGirls(@Valid Girl girl, BindingResult bindingResult) {
        Result result = new Result();
        if(bindingResult.hasErrors()){
            return null;
//            return ResultUtil.Error(400,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.Success(girlRepository.save(girl));

    }

    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirl(@PathVariable(value = "id") Integer id) {
        if (girlRepository.exists(id)) {
            Girl girl = girlRepository.findOne(id);
            return girl;

        }

        return null;
    }

    /*
    更新一个女生
     */
    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable(value = "id") Integer id,
                           @RequestParam(value = "cupSize") String cupSize,
                           @RequestParam(value = "age") Integer age) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);

        return girl;
    }

    /*
    删除一个女生
     */
    @DeleteMapping("/girls/{id}")
    public Girl deleteGirl(@PathVariable(value = "id") Integer id) {
        if (!girlRepository.exists(id)) {
            return null;
        }
        Girl girl = girlRepository.findOne(id);
        girlRepository.delete(id);
        return girl;

    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable(value = "age") Integer age) {

        List<Girl> girls = girlRepository.findByAge(age);
        if (girls == null) {
            return null;
        }
        return girls;
    }

    @GetMapping(value = "/girls/getage/{id}")
    public void getAge(@PathVariable("id")Integer id) throws  Exception{
        girlService.getAgeById(id);
    }

}


