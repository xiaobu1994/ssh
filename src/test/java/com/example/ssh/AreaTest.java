package com.example.ssh;

import com.example.entity.Area;
import com.example.repository.AreaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/27 9:24
 * @description V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaTest {
    @Autowired
    AreaRepository areaRepository;
    @Test
    public void addArea(){
        for (int i = 1; i <11 ; i++) {
            Area area = new Area(i,"name"+i,"time"+i);
            areaRepository.save(area);
        }
    }
}
