package net.naruh.sastruts.util.csv;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.seasar.framework.container.SingletonS2Container;
import org.seasar.s2csv.csv.S2CSVWriteCtrl;
import org.seasar.s2csv.csv.factory.S2CSVCtrlFactory;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;

public class DefaultCSVResponseWriter<ENTITY, CSVROW> implements
        CSVResponseWriter<ENTITY, CSVROW> {
    protected static final String DEFAULT_CSV_CONTENT_TYPE = "text/csv";

    protected static final String DEFAULT_CSV_ENCODING = "Windows-31J";

    protected Class<CSVROW> csvRowClass;

    protected String contentType = DEFAULT_CSV_CONTENT_TYPE;

    protected String encoding = DEFAULT_CSV_ENCODING;

    public DefaultCSVResponseWriter(Class<CSVROW> csvRowClass) {
        this.csvRowClass = csvRowClass;
    }

    public String download(String filename,
            CSVWriteCallback<ENTITY, CSVROW> callback) throws IOException {
        HttpServletResponse response = ResponseUtil.getResponse();
        response.setHeader("Content-Type", contentType + "; charset="
                + encoding);
        response.setHeader("Content-Disposition", "attachment; filename="
                + encodeFilename(filename));
        Writer writer = new OutputStreamWriter(response.getOutputStream(),
                encoding);
        try {
            S2CSVCtrlFactory csvCtrlFactory = getS2CSVCtrlFactory();
            S2CSVWriteCtrl<CSVROW> controller = csvCtrlFactory
                    .getWriteController(csvRowClass, writer);
            callback.write(new DefaultCSVRowWriteCallback<ENTITY, CSVROW>(
                    controller, csvRowClass));
        } finally {
            writer.close();
        }
        return null;
    }

    protected String encodeFilename(String filename)
            throws UnsupportedEncodingException {
        String userAgent = RequestUtil.getRequest().getHeader("User-Agent");
        String encoding = (userAgent.indexOf("MSIE") >= 0
                && userAgent.indexOf("Opera") < 0 ? "Windows-31J" : "UTF-8");
        return new String(filename.getBytes(encoding), "ISO8859_1");
    }

    protected static S2CSVCtrlFactory getS2CSVCtrlFactory() {
        return SingletonS2Container.getComponent(S2CSVCtrlFactory.class);
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
