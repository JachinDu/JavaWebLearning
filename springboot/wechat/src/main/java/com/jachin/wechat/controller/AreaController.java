package com.jachin.wechat.controller;


import com.jachin.wechat.entity.Area;
import com.jachin.wechat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // RestController = Controller + ResponseBody
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;


    /*
    * 多值返回，用Map kv形式
    * */
    @GetMapping("/listarea")
    public Map<String, Object> listArea() {
        Map<String, Object> map = new HashMap<>();
        List<Area> list = areaService.queryArea();
        map.put("areaList", list);
        return map;
    }

    @GetMapping("/getareabyid/{areaId}")
    public Map<String, Object> getAreaById(@PathVariable("areaId") Integer areaId) {
        Map<String, Object> map = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        map.put("area", area);
        return map;

    }

    @PostMapping("/insert")
    public Map<String, Object> insertArea(Area area) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", areaService.insertArea(area));
        return map;
    }
    @PostMapping("/update")
    public Map<String, Object> updateArea(Area area) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", areaService.updateArea(area));
        return map;
    }

    @GetMapping("/delete/{id}")
    public Map<String,Object> deleteArea(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", areaService.deleteArea(id));
        return map;
    }





}
