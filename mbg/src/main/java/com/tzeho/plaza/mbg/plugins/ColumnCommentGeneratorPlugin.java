package com.tzeho.plaza.mbg.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/* @description 自定义注释
 * @author tzeho */
public class ColumnCommentGeneratorPlugin extends DefaultCommentGenerator {

    /** 不生成 xml 文件注释 */
    @Override
    public void addComment(XmlElement xmlElement) {}

    /** 实体类数据表注释 */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String remarks = introspectedTable.getRemarks();

        if (remarks != null && !remarks.isEmpty()) {
            topLevelClass.addJavaDocLine("/* @description " + remarks);
            topLevelClass.addJavaDocLine(" * @author tzeho */");
        }
    }

    /** 实体类字段注释 */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();

        if (remarks != null && !remarks.isEmpty()) {
            field.addJavaDocLine("/** " + remarks + " */");
        }
    }

    /** 不生成结尾注释 */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {}

    /** 不生成方法注释 */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {}

}
