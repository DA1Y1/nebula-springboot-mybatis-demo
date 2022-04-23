package com.example.config.mybatis;

import com.example.pojo.PathDO;
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
public class RelationTypeHandler implements TypeHandler<List<PathDO.RelationShip>> {


    @Override
    public void setParameter(PreparedStatement ps, int i, List<PathDO.RelationShip> parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<PathDO.RelationShip> getResult(ResultSet rs, String columnName) throws SQLException {
        String object = rs.getString(columnName);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<PathDO.RelationShip>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<PathDO.RelationShip> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String object = rs.getString(columnIndex);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<PathDO.RelationShip>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<PathDO.RelationShip> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String object = cs.getString(columnIndex);
        try {
            return JacksonUtil.getObjectMapper().readValue(object, new TypeReference<List<PathDO.RelationShip>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
