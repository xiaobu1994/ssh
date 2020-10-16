package com.example.service.impl;

import org.springframework.stereotype.Service;
import com.example.entity.McMblUserCount;
import com.example.base.service.BaseServiceImpl;
import com.example.service.McMblUserCountService;

/**
 * @author xiaobu
 * @date 2019-12-13 15:33:17
 * @description 这些实现类必须加 @Repository 否则回报没有注入bean 
 */
@Service
public class McMblUserCountServiceImpl extends BaseServiceImpl<McMblUserCount,Integer> implements McMblUserCountService{

}