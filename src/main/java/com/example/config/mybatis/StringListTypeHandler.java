package com.example.config.mybatis;

import com.example.util.JacksonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DAIYI
 */
public class StringListTypeHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        String object = rs.getString(columnName);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String object = rs.getString(columnIndex);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String object = cs.getString(columnIndex);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
