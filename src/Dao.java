import annotations.DataBaseTableField;
import annotations.DataBaseTableName;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.util.HashMap;

public class Dao<T extends java.io.Serializable> {
    //类成员变量
    private String tableName;//表名称
    private List<String> tableFieldList;//表列名称
    private Field[] modelFields;//实体类字段集合
    private HashMap<String,Integer> fieldToIndex;//实体类转编号
    private HashMap<String,Integer> tableToIndex;//表列转编号

    //泛型Dao
    public Dao(Class<T> classInfo) {

        // 获取类注解（对应的表名称）
        if (classInfo.isAnnotationPresent(DataBaseTableName.class)) {
            tableName = classInfo.getAnnotation(DataBaseTableName.class).value();
        } else {
            tableName = classInfo.getSimpleName();
        }

        //反射获取实体类信息，并通过注解确定表信息
        modelFields = classInfo.getDeclaredFields();
        String modelFieldName,tableFieldName;
        tableFieldList=new ArrayList<String>(modelFields.length);
        for (Field field : modelFields) {
            field.setAccessible(true);
            modelFieldName = field.getName();
            if (field.isAnnotationPresent(DataBaseTableField.class)) {
                tableFieldName = field.getAnnotation(DataBaseTableField.class).value();
            } else {
                tableFieldName = modelFieldName;
            }
            tableFieldList.add(tableFieldName);
        }
    }

    public int Init()
    {
        System.out.println("表名称"+tableName);
        System.out.print("表字段");
        for (String string:tableFieldList) {
            System.out.print(string);
        }
        System.out.print("/n实体类字段");
        for (Field field:modelFields) {
            System.out.print(field.getName());
        }
        return 0;
    }

}
