/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package net.naruh.sastrutscsvdownloadex1.action;

import java.io.IOException;

import javax.annotation.Resource;

import net.naruh.sastruts.util.csv.CSVRowWriteCallback;
import net.naruh.sastruts.util.csv.CSVWriteCallback;
import net.naruh.sastruts.util.csv.DefaultCSVResponseWriter;
import net.naruh.sastrutscsvdownloadex1.dto.EmpCsv;
import net.naruh.sastrutscsvdownloadex1.entity.Emp;
import net.naruh.sastrutscsvdownloadex1.service.EmpService;

import org.seasar.struts.annotation.Execute;

public class EmpAction {
    @Resource
    protected EmpService empService;

    @Execute(validator = false)
    public String downloadCsv() throws IOException {
        return new DefaultCSVResponseWriter<Emp, EmpCsv>(EmpCsv.class)
            .download("従業員.csv", new CSVWriteCallback<Emp, EmpCsv>() {
                @Override
                public void write(CSVRowWriteCallback<Emp, EmpCsv> rowCallback)
                        throws IOException {
                    empService.downloadCsv(rowCallback);
                }
            });
    }
}
