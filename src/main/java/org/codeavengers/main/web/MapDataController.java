/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.web;

import org.codeavengers.common.dto.RestWrapper;
import org.codeavengers.main.service.MapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
@RestController
public class MapDataController {
    @Autowired
    @Qualifier("MapDataService")
    private MapDataService mapData = null;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public RestWrapper getCategories() {
        RestWrapper wrapper = new RestWrapper();
        wrapper.setDataList(mapData.getCategories());
        return wrapper;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestWrapper getCategory(@PathVariable Long id) {
        RestWrapper wrapper = new RestWrapper();
        wrapper.setData(mapData.getCategory(id));
        return wrapper;
    }
}