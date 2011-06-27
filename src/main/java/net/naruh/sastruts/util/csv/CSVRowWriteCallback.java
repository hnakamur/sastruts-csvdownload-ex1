package net.naruh.sastruts.util.csv;

import org.seasar.extension.jdbc.IterationCallback;

public interface CSVRowWriteCallback<ENTITY, CSVROW> extends
        IterationCallback<ENTITY, CSVROW> {
}
