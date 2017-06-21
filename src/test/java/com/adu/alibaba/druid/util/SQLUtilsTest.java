package com.adu.alibaba.druid.util;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

/**
 * @author yunjie.du
 * @date 2017/6/20 17:54
 */
public class SQLUtilsTest extends BaseTest {
    private String sql;

    @Test
    public void format() {
        String res = SQLUtils.format(sql, JdbcConstants.MYSQL);
        logRes(res);
    }

    @Test
    public void format1() {
        String res = SQLUtils.formatMySql(sql);
        logRes(res);
    }

    @Test
    public void format2() {
        String res = SQLUtils.format(sql, JdbcConstants.MYSQL, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION);
        logRes(res);
    }

    @Test
    public void parseStatements() {
        List<SQLStatement> res = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        logResStringfy(res);
    }

    @Test
    public void parseStatements2() {
        List<SQLStatement> sqlStatementList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        MySqlSchemaStatVisitor schemaStatVisitor = new MySqlSchemaStatVisitor();
        for (SQLStatement sqlStatement : sqlStatementList) {
            sqlStatement.accept(schemaStatVisitor);
            logResStringfy(schemaStatVisitor);
        }
    }

    @Before
    public void init() {
        this.sql = "update t set name = 'x' where id < 100 limit 10";
    }
}
