package net.naruh.sastruts.util.csv;

import org.seasar.extension.jdbc.IterationContext;
import org.seasar.framework.beans.util.BeanUtil;
import org.seasar.framework.util.ClassUtil;
import org.seasar.s2csv.csv.S2CSVWriteCtrl;

public class DefaultCSVRowWriteCallback<ENTITY, CSVROW> implements
        CSVRowWriteCallback<ENTITY, CSVROW> {

    protected S2CSVWriteCtrl<CSVROW> controller;
    protected CSVROW row;

    @SuppressWarnings("unchecked")
    public DefaultCSVRowWriteCallback(S2CSVWriteCtrl<CSVROW> controller,
            Class<CSVROW> rowClass) {
        this.controller = controller;
        this.row = (CSVROW) ClassUtil.newInstance(rowClass);
    }

    @Override
    public CSVROW iterate(ENTITY entity, IterationContext context) {
        BeanUtil.copyProperties(entity, row);
        controller.write(row);
        return row;
    }
}
