/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.mybatis.test.chapter2.mapper;

import com.mybatis.test.chapter2.entity.Person;

import java.util.List;

/**
 * @author: liy
 * @datetime: 2021/12/14 9:49
 * @description:
 */
public interface PersonMapper {
    /**
     * 插入人员信息
     *
     * @param p 人员信息
     * @return true：插入成功，false：插入失败
     */
    boolean insert(Person p);


    /**
     * 查询所有数据
     *
     * @return 返回查询的结果集合
     */
    List<Person> selectAll();

    /**
     * 根据人员编号返回人员信息
     *
     * @param id 编号
     * @return
     */
    Person selectById(int id);
}
