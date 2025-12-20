package com.tzeho.plaza.mbg.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/* @description 自定义 Lombok 注解插件
 * @author tzeho */
public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /** 不生成 Get 方法 */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /** 不生成 Set 方法 */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /** Lombok 注解 */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Getter");
        topLevelClass.addImportedType("lombok.Setter");
        topLevelClass.addImportedType("lombok.ToString");
        topLevelClass.addAnnotation("@Getter");
        topLevelClass.addAnnotation("@Setter");
        topLevelClass.addAnnotation("@ToString");
        return true;
    }

}
