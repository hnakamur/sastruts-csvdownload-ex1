package net.naruh.sastruts.util.csv;

import java.io.IOException;

public interface CSVResponseWriter<ENTITY, CSVROW> {
    String download(String filename, CSVWriteCallback<ENTITY, CSVROW> callback)
            throws IOException;
}
