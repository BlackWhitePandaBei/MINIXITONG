package dragon.all;

/**
 * Created by Administraor on 2016/8/29.
 */
import java.sql.*;
public class SqlHelper {
    Connection ct;
    PreparedStatement ps;
    ResultSet rs;

    public void lianjie(){
        try {
            //驱动
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //连接
            ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=DragonStudy","sa","xiongmao");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void lianjie(String databaseName){
        try {
            //驱动
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //连接
            ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName="+databaseName,"sa","xiongmao");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeResourse(ResultSet rs,PreparedStatement ps){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(ct!=null){
                ct.close();
            }

        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
    }
    public void closeResourse(){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(ct!=null){
                ct.close();
            }

        } catch (Exception e2) {
            // TODO: handle exception
            e2.printStackTrace();
        }
    }
}
