package com.jachin.wechat.service.Impl;

import com.jachin.wechat.entity.Area;
import com.jachin.wechat.mapper.AreaDaoMapper;
import com.jachin.wechat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDaoMapper areaDaoMapper;

    @Override
    public List<Area> queryArea() {
        return areaDaoMapper.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {

//        int i = 1/0;
        return areaDaoMapper.queryAreaById(areaId);
    }

    @Transactional //加上事务
    //默认只对RuntimeException回滚
    //可通过@Transactional(rollbackFor = Exception.class)指明具体异常
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            try {
                int num = areaDaoMapper.insertArea(area);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());

            try {
                int num = areaDaoMapper.updateArea(area);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int num = areaDaoMapper.deleteArea(areaId);
                if (num > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("区域id不能为空！");
        }
    }
}
