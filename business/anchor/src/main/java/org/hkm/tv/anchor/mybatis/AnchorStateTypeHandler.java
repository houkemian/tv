package org.hkm.tv.anchor.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.hkm.tv.anchor.entity.Anchor;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Anchor.State.class)
public class AnchorStateTypeHandler extends BaseTypeHandler<Anchor.State> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Anchor.State state, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, state.value());
    }

    @Override
    public Anchor.State getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return Anchor.State.state(resultSet.getInt(s));
    }

    @Override
    public Anchor.State getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return Anchor.State.state(resultSet.getInt(i));
    }

    @Override
    public Anchor.State getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Anchor.State.state(callableStatement.getInt(i));
    }
}
