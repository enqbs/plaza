package com.tzeho.plaza.mbg.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/* @description 自定义 Serializable 插件
 * @author tzeho */
public class SerializablePlugin extends org.mybatis.generator.plugins.SerializablePlugin {

    @Override
    protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        super.makeSerializable(topLevelClass, introspectedTable);
        topLevelClass.getFields().forEach(field -> addAnnotation(field, topLevelClass));
    }

    /** serialVersionUID 字段增加 @Serial 注解 */
    private void addAnnotation(Field field, TopLevelClass topLevelClass) {
        if ("serialVersionUID".equals(field.getName())) {
            topLevelClass.addImportedType("java.io.Serial");
            field.addAnnotation("@Serial");
        }
    }

}
