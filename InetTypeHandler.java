package org.egc.cybersolim.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Postgresql inet <=> java InetAddress in mybatis
 *
 * @author houzhiwei
 * @date 2017/2/14 14:15
 */
public class InetTypeHandler extends BaseTypeHandler<InetAddress>
{
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, InetAddress parameter, JdbcType jdbcType) throws SQLException
    {
        PGobject object = new PGobject();
//        用parameter.getAddress() 得到的IP地址前面会有/
        object.setValue(parameter.getHostAddress());
        object.setType("inet");
        ps.setObject(i, object);
    }

    @Override
    public InetAddress getNullableResult(ResultSet rs, String columnName) throws SQLException
    {
        String v = rs.getString(columnName);
        InetAddress address = toInetAddress(v);
        if (rs.wasNull()) {
            return null;
        } else {
            return address;
        }
    }

    @Override
    public InetAddress getNullableResult(ResultSet rs, int columnIndex) throws SQLException
    {
        String v = rs.getString(columnIndex);
        InetAddress address = toInetAddress(v);
        if (rs.wasNull()) {
            return null;
        } else {
            return address;
        }
    }

    @Override
    public InetAddress getNullableResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        String v = cs.getString(columnIndex);
        InetAddress address = toInetAddress(v);
        if (cs.wasNull()) {
            return null;
        } else {
            return address;
        }
    }

    private InetAddress toInetAddress(String v)
    {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(v);
        } catch (UnknownHostException e) {
            return null;
        }
        return address;
    }
}
