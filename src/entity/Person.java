package entity;

import annotations.DataBaseTableField;
import annotations.DataBaseTableName;

@DataBaseTableName("Person")
public class Person {

    @DataBaseTableField("id")
    private int id;//工号

    @DataBaseTableField("name")
    private String name;//姓名

    @DataBaseTableField("age")
    private int age;//年龄

    @DataBaseTableField("privilege")
    private int level;//权限

    @DataBaseTableField("classNum")
    private int classId;//所在班级
}

