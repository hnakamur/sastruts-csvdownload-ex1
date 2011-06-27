package net.naruh.sastrutscsvdownloadex1.dto;

import java.math.BigDecimal;
import java.sql.Date;

import org.seasar.s2csv.csv.annotation.column.CSVColumn;
import org.seasar.s2csv.csv.annotation.entity.CSVEntity;

@CSVEntity
public class EmpCsv {
    /** idプロパティ */
    @CSVColumn(columnIndex=0, quote=false)
    protected Long id;

    /** empNoプロパティ */
    @CSVColumn(columnIndex=1, quote=false)
    protected Integer empNo;

    /** empNameプロパティ */
    @CSVColumn(columnIndex=2, quote=false)
    protected String empName;

    /** mgrIdプロパティ */
    @CSVColumn(columnIndex=3, quote=false)
    protected Integer mgrId;

    /** hiredateプロパティ */
    @CSVColumn(columnIndex=4, quote=false)
    protected Date hiredate;

    /** salプロパティ */
    @CSVColumn(columnIndex=5, quote=false)
    protected BigDecimal sal;

    /** deptIdプロパティ */
    @CSVColumn(columnIndex=6, quote=false)
    protected Integer deptId;

    /** versionNoプロパティ */
    @CSVColumn(columnIndex=7, quote=false)
    protected Integer versionNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
}
