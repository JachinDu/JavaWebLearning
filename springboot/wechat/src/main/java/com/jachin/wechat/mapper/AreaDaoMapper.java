package com.jachin.wechat.mapper;

import com.jachin.wechat.entity.Area;

import java.util.List;

public interface AreaDaoMapper {

    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);
}
