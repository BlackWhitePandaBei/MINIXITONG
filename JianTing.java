package dragon.all;

/**
 * Created by Administraor on 2016/8/29.
 */
import java.awt.event.*;
import javax.swing.*;
public class JianTing extends JFrame implements ActionListener{
    TianjiaJieMian tianjia;
    JTable jt;
    IdeaGoTable ideago;
    public JianTing(){
    }
    public JianTing(TianjiaJieMian tianjia ,JTable jt){
        this.tianjia=tianjia;
        this.jt=jt;
    }
    public JianTing(JTable jt){
        this.jt=jt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("查询")){
//            System.out.println("查询");
            String name=ZongJieMiam.chaxunJT.getText().trim();
            if(!name.equals("")){
                ideago=new IdeaGoTable();
                ideago.nameChaXun(name);
                jt.setModel(ideago);
            }

        }else if(e.getActionCommand().equals("添加")){
            ideago=new IdeaGoTable();
            tianjia =new TianjiaJieMian(jt,"添加角色",ideago);

        }else if(e.getActionCommand().equals("修改")){
            int rowIndex=jt.getSelectedRow();
            if(rowIndex==-1) {
                JOptionPane.showMessageDialog(this, "请选择数据行");
                return;
            }else{
                ideago=new IdeaGoTable();
                tianjia =new TianjiaJieMian(jt,"修改信息",ideago);
            }

        }else if(e.getActionCommand().equals("删除")){
//            System.out.println("删除");
            int rowIndex=jt.getSelectedRow();
            if(rowIndex==-1){
                JOptionPane.showMessageDialog(this, "请选择数据行");
                return;
            }else{
                ideago=new IdeaGoTable();
                ideago.showAll();
                String haoma=(ideago.getValueAt(rowIndex,0)).toString();
//                System.out.println(haoma);
                ideago.shanChu(haoma);
                ideago.showAll();
                jt.setModel(ideago);

            }

        }else if(e.getActionCommand().equals("确认")){
//           System.out.println("确认");

            ideago=new IdeaGoTable();
            int num=ideago.tianJiaShuJu();
            if(num==1){
                tianjia.setVisible(false);
                JOptionPane.showMessageDialog(this, "添加成功");
                ideago=new IdeaGoTable();
                ideago.showAll();
                jt.setModel(ideago);

            }else{
                JOptionPane.showMessageDialog(this, "添加失败");
            }
        }else if(e.getActionCommand().equals("确认修改")){
            ideago=new IdeaGoTable();
            int rowIndex=jt.getSelectedRow();
            ideago=new IdeaGoTable();
            ideago.showAll();
            String haoma=(ideago.getValueAt(rowIndex,0)).toString();
            int num=ideago.xiuGaiShuJu(haoma);

            if(num==1){
                tianjia.setVisible(false);
                JOptionPane.showMessageDialog(this, "修改成功");
                ideago=new IdeaGoTable();
                ideago.showAll();
                jt.setModel(ideago);

            }else{
                JOptionPane.showMessageDialog(this, "添加失败");
            }
        }else if(e.getActionCommand().equals("全部")){
//           System.out.println("全部");
            ideago=new IdeaGoTable();
            ideago.showAll();
            jt.setModel(ideago);

        }
    }



}
