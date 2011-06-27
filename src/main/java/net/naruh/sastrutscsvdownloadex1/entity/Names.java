package net.naruh.sastrutscsvdownloadex1.entity;

import javax.annotation.Generated;
import net.naruh.sastrutscsvdownloadex1.entity.DeptNames._DeptNames;
import net.naruh.sastrutscsvdownloadex1.entity.EmpNames._EmpNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2011/06/25 13:54:18")
public class Names {

    /**
     * {@link Dept}の名前クラスを返します。
     * 
     * @return Deptの名前クラス
     */
    public static _DeptNames dept() {
        return new _DeptNames();
    }

    /**
     * {@link Emp}の名前クラスを返します。
     * 
     * @return Empの名前クラス
     */
    public static _EmpNames emp() {
        return new _EmpNames();
    }
}