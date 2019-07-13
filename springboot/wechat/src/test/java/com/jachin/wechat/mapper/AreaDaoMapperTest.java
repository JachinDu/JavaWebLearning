package com.jachin.wechat.mapper;

import com.jachin.wechat.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoMapperTest {

    @Autowired
    private AreaDaoMapper areaDaoMapper;

    @Test
    public void queryArea() {
        List<Area> list = areaDaoMapper.queryArea();
        for (Area area : list) {
            System.out.println(area);
        }
    }

    @Test
    public void queryAreaById() {
        Area area = areaDaoMapper.queryAreaById(1);
        System.out.println(area);
    }

    @Test
    public void insertArea() {
        Area area = new Area("南苑", 1, new Date(), new Date());
        int id =areaDaoMapper.insertArea(area);
        System.out.println("id: "+id);
        System.out.println(area);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setPriority(3);
        area.setAreaId(1);
        int x = areaDaoMapper.updateArea(area);
        System.out.println(x);
    }

    @Test
    public void deleteArea() {
        int x = areaDaoMapper.deleteArea(3);

    }
}