package dragon.all;

/**
 * Created by Administraor on 2016/8/29.
 */

import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
public class IdeaGoTable extends AbstractTableModel{
    Vector<String> lieMing;
    Vector hangShuJu;
    Vector hangTou;
    SqlHelper myHelper= new SqlHelper();
    PreparedStatement ps;
    ResultSet rs;
    JianTing jianting;
    public IdeaGoTable(){
        jianting=new JianTing();
        lieMing=new Vector<String>();
        hangShuJu = new Vector();
        hangTou =new Vector();
        lieMing.add("号码");
        lieMing.add("名字");
        lieMing.add("性别");
        lieMing.add("工作");
        lieMing.add("薪水");
    }

    public void showAll(){
        hangShuJu = new Vector();
        hangTou =new Vector();

        try {
            myHelper.lianjie();
            ps=myHelper.ct.prepareStatement("select * from IdeaGo");
            rs=ps.executeQuery();
            while(rs.next()){
                int ID=rs.getInt(1);
                String name=rs.getString(2);
                String sex=rs.getString(3);
                String job=rs.getString(4);
                int sal=rs.getInt(5);

                hangShuJu.add(ID);
                hangShuJu.add(name);
                hangShuJu.add(sex);
                hangShuJu.add(job);
                hangShuJu.add(sal);

                hangTou.add(hangShuJu);
                hangShuJu = new Vector();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myHelper.closeResourse(rs,ps);
        }
    }
    public int tianJiaShuJu(){
        int num=-1;
        try {
            myHelper.lianjie();
            ps=myHelper.ct.prepareStatement("insert into IdeaGo values(?,?,?,?,?)");
            ps.setInt(1,Integer.valueOf(jianting.tianjia.ID.getText().trim()));
            ps.setString(2,jianting.tianjia.name.getText().trim());
            ps.setString(3,jianting.tianjia.sex.getText().trim());
            ps.setString(4,jianting.tianjia.job.getText().trim());
            ps.setInt(5,Integer.valueOf(jianting.tianjia.sal.getText().trim()));

            num=ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myHelper.closeResourse(rs,ps);
        }
        return num;
    }

    public int xiuGaiShuJu(String ID){
        int num=-1;
        try {
            myHelper.lianjie();

            ps=myHelper.ct.prepareStatement("update IdeaGo set name=?,sex=?,job=?,sal=? where ID=?");
//            ps.setInt(1,Integer.valueOf(jianting.tianjia.ID.getText().trim()));
//            ps.setString(2,jianting.tianjia.name.getText().trim());
//            ps.setString(3,jianting.tianjia.sex.getText().trim());
//            ps.setString(4,jianting.tianjia.job.getText().trim());
//            ps.setInt(5,Integer.valueOf(jianting.tianjia.sal.getText().trim()));
            ps.setString(1,TianjiaJieMian.name.getText().trim());
            ps.setString(2,TianjiaJieMian.sex.getText().trim());
            ps.setString(3,TianjiaJieMian.job.getText().trim());
            ps.setString(4,TianjiaJieMian.sal.getText().trim());
            ps.setString(5,ID);

            num=ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myHelper.closeResourse(rs,ps);
        }
        return num;
    }

    public void nameChaXun(String sqlname){
        hangShuJu = new Vector();
        hangTou =new Vector();
        try {
            myHelper.lianjie();
            ps=myHelper.ct.prepareStatement("select * from IdeaGo where name=?");
            ps.setString(1,sqlname);
            rs=ps.executeQuery();
            while(rs.next()){
                int ID=rs.getInt(1);
                String name=rs.getString(2);
                String sex=rs.getString(3);
                String job=rs.getString(4);
                int sal=rs.getInt(5);

                hangShuJu.add(ID);
                hangShuJu.add(name);
                hangShuJu.add(sex);
                hangShuJu.add(job);
                hangShuJu.add(sal);

                hangTou.add(hangShuJu);
                hangShuJu = new Vector();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myHelper.closeResourse(rs,ps);
        }
    }

    public void shanChu(String haoma){
        try {
            myHelper.lianjie();
            ps=myHelper.ct.prepareStatement("delete from IdeaGo where ID=?");
            ps.setString(1,haoma);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myHelper.closeResourse(rs,ps);
        }
    }
    @Override
    public int getRowCount() {
        return hangTou.size();
    }

    @Override
    public int getColumnCount() {
        return lieMing.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector) hangTou.get(rowIndex)).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return lieMing.get(column);
    }

}
