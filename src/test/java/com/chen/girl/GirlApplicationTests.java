package com.chen.girl;

import com.chen.girl.domain.Girl;
import com.chen.girl.repository.GirlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {


	@Autowired
	GirlRepository girlRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testDatabase(){
		Girl girl = new Girl();
		girl.setAge(1321);
		girl.setCupSize("D");

		girlRepository.save(girl);


	}


}
