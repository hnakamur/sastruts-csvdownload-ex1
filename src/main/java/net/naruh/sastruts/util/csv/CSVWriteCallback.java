package net.naruh.sastruts.util.csv;

import java.io.IOException;

public interface CSVWriteCallback<ENTITY, CSVROW> {
    void write(CSVRowWriteCallback<ENTITY, CSVROW> rowCallback)
            throws IOException;
}
