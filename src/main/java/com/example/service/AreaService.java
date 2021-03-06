package com.example.service;

import com.example.base.service.BaseService;
import com.example.entity.Area;

/**
 * @author xiaobu
 * @date 2018-11-20 17:29:39
 * @description V1.0
 */
public interface AreaService extends BaseService<Area, Integer> {

    Area get(int id);


    Area saveOrUpdate(Area area);

    void delete(int id);
}