package net.naruh.sastrutscsvdownloadex1.service;

import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;

import net.naruh.sastruts.util.csv.CSVRowWriteCallback;
import net.naruh.sastrutscsvdownloadex1.dto.EmpCsv;
import net.naruh.sastrutscsvdownloadex1.entity.Emp;

import static net.naruh.sastrutscsvdownloadex1.entity.EmpNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Emp}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2011/06/25 13:54:23")
public class EmpService extends AbstractService<Emp> {
    @Resource
    protected JdbcManager jdbcManager;

    public void downloadCsv(CSVRowWriteCallback<Emp, EmpCsv> callback) {
        jdbcManager.from(Emp.class).orderBy("id").iterate(callback);
    }

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Emp findById(Long id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子とバージョン番号でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @param versionNo
     *            バージョン番号
     * @return エンティティ
     */
    public Emp findByIdVersion(Long id, Integer versionNo) {
        return select().id(id).version(versionNo).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Emp> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}