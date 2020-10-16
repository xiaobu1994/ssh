package com.example.repository;

import com.example.entity.McMblUserCount;
import com.example.base.repository.BaseRepository;

/**
 * @author xiaobu
 * @date 2019-12-13 15:33:17
 * @description 这些实现类必须加 @Repository 否则回报没有注入bean 
 */
public interface McMblUserCountRepository extends BaseRepository <McMblUserCount,Integer> {

}