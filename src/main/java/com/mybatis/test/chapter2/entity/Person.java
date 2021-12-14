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
package com.mybatis.test.chapter2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: liy
 * @datetime: 2021/12/14 9:43
 * @description:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    /**
     * 编号
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private short age;
    /**
     * 出生日期
     */
    private Date birthday;
}
