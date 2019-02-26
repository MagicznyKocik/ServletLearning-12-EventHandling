package pl.adamLupinski.jdbc;

// class for connection managing

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {

    private static DbUtil dbUtil;
    private HikariDataSource dataSource;

    // creating dbUtil object with hikari config

    // write here your own username and password

    private DbUtil(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("{username}");
        config.setPassword("{password}");
        dataSource =new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close(){
        dataSource.close();
    }

    public static DbUtil getInstance(){
        if (dbUtil == null){
            dbUtil = new DbUtil();
        }
        return dbUtil;
    }

}
