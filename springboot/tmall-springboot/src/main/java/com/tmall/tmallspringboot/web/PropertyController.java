package com.tmall.tmallspringboot.web;


import com.tmall.tmallspringboot.pojo.Property;
import com.tmall.tmallspringboot.service.PropertyService;
import com.tmall.tmallspringboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") Integer cid,
                                         @RequestParam(value = "start", defaultValue = "0") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) {

        start = start<0 ? 0 : start;
        Page4Navigator<Property> page = propertyService.list(cid, start, size, 5);
        return page;
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") Integer id) {
        Property property = propertyService.get(id);
        return property;
    }


    @PostMapping("/properties")
    public Object add(@RequestBody Property property) {
        propertyService.add(property);
        return property;
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") Integer id) {
        propertyService.delete(id);
        return null;
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property property) {
        propertyService.update(property);
        return property;
    }

}
