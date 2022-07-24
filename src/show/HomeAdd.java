package show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

public class HomeAdd extends JFrame implements ActionListener {
    //设置字体风格和大小
    Font ft18 = new Font("楷体", Font.PLAIN, 18);
    // 定义组件
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JPanel jp5 = new JPanel();
    JPanel jp6 = new JPanel();
    JPanel jp7 = new JPanel();
    JPanel jp8 = new JPanel();
    //定义名称
    JLabel jlid = new JLabel("产品编号");
    JLabel jlname = new JLabel("产品名称");
    JLabel jltype = new JLabel("产品类别");
    JLabel jlstock = new JLabel("产品库存");
    JLabel jlprice = new JLabel("产品价格");
    JLabel jldelid = new JLabel("删除产品");
    JLabel Prompt = new JLabel("产品编号应当为唯一且确定的值。添加、修改、删除和查询都是依据产品编号进行的。");

    //定义文本框
    JTextField jtid = new JTextField("必须输入编号", 10);
    JTextField jtname = new JTextField(10);
    JTextField jttype = new JTextField(10);
    JTextField jtstock = new JTextField(10);
    JTextField jtprice = new JTextField(10);
    //定义按钮
    JButton clear = new JButton("清空");
    JButton sureAdd = new JButton("添加产品");
    JButton del = new JButton("删除产品");
    JButton query = new JButton("刷新数据");
    JButton updata = new JButton("修改数据");
    JButton cancel = new JButton("关闭");
    JTable jt;
    //定义表格
    JTable table = this.buildTable();
    JScrollPane jsp = new JScrollPane(table);

    public HomeAdd(String title) {
        // 布局
        super(title);
        jp1.add(jlid);
        jp1.add(jtid);
        jlid.setFont(ft18);//设置字体

        jp2.add(jlname);
        jp2.add(jtname);
        jlname.setFont(ft18);

        jp3.add(jltype);
        jp3.add(jttype);
        jltype.setFont(ft18);

        jp4.add(jlstock);
        jp4.add(jtstock);
        jlstock.setFont(ft18);

        jp5.add(jlprice);
        jp5.add(jtprice);
        jlprice.setFont(ft18);


        jp7.add(jp2);
        jp7.add(jp3);
        jp7.add(jp4);
        jp7.add(jp5);
        jp7.add(jp6);
        jp7.add(jp1);
        jp7.add(clear);

        jp8.add(Prompt);
        Prompt.setFont(ft18);
        // 使用box布局使按钮上下排列
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(60));// 加入60像素的高度间隔
        box.add(sureAdd);
        box.add(Box.createVerticalStrut(60));
        box.add(del);
        box.add(Box.createVerticalStrut(60));
        box.add(query);
        box.add(Box.createVerticalStrut(60));
        box.add(updata);
        box.add(Box.createVerticalStrut(60));
        box.add(cancel);
        // 注册监听器
        clear.addActionListener(this);
        sureAdd.addActionListener(this);
        del.addActionListener(this);
        query.addActionListener(this);
        updata.addActionListener(this);
        cancel.addActionListener(this);

        this.add(jp7, "North");
        this.add(jsp, "Center");
        this.add(box, "East");
        this.add(jp8, "South");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // 事件
        jtid.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 获取焦点时执行此方法
                if (jtid.getText().equals("必须输入编号")) {
                    jtid.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                // 失去焦点时执行此方法
                if (jtid.getText().equals("")) {
                    jtid.setText("必须输入编号");
                }
            }
        });
    }

    public static void main(String[] args) {
        new HomeAdd("产品添加与删除");
    }

    public JTable buildTable() {
        // 定义表头
        Vector<String> title = new Vector<String>();
        title.add("产品编号");
        title.add("产品名称");
        title.add("产品类别");
        title.add("产品库存");
        title.add("产品价格");
        // 定义表数据
        QueryData QData = new QueryData();
        Vector data = QData.getinfo();
        jt = new JTable(data, title);
        return jt;
    }

    // 定义按钮事件
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            jtid.setText("");
            jtname.setText("");
            jttype.setText("");
            jtstock.setText("");
            jtprice.setText("");

        }
        if (e.getSource() == sureAdd) {// 添加数据
            String id = this.jtid.getText();
            String name = this.jtname.getText();
            String type = this.jttype.getText();
            String stock = this.jtstock.getText();
            String price = this.jtprice.getText();
            // 调用AddData的insertinfo()方法添加数据
            AddData ADDData = new AddData();
            int i = ADDData.insertinfo(id, name, type, stock, price);
            if (i < 1) {
                JOptionPane.showMessageDialog(this, "添加失败！");
            } else {
                JOptionPane.showMessageDialog(this, "添加产品编号为： " + id + " 的数据成功！\n\n" + "添加数据为：\n 编号：" + id + " \n 名称：" + name + " \n 类别：" + type + " \n 库存：" + stock + " \n 价格：" + price);
            }
            table = buildTable();
            jsp.setViewportView(table);
        }
        if (e.getSource() == del) {// 删除数据
            String id = this.jtid.getText();
            // 调用delTest的insertinto()方法删除数据
            DelData DELData = new DelData();
            int i = DELData.insertinto(id);
            if (i < 1) {
                JOptionPane.showMessageDialog(this, "删除失败！");
            } else {
                JOptionPane.showMessageDialog(this, "删除产品编号为： " + id + " 的数据成功！\n\n" + "删除的编号为：" + id);
            }
            table = buildTable();
            jsp.setViewportView(table);
        }
        if (e.getSource() == query) {// 刷新表
            table = buildTable();
            jsp.setViewportView(table);
            JOptionPane.showMessageDialog(this, "刷新成功！");
        }
        if (e.getSource() == updata) {// 修改数据
            String id = this.jtid.getText();
            String name = this.jtname.getText();
            String type = this.jttype.getText();
            String stock = this.jtstock.getText();
            String price = this.jtprice.getText();
            // 调用AddData的方法修改数据
            ChangeData ChangeD = new ChangeData();
            String outData = "";
            int i = 0;
            if (this.jtname.getText().equals("")) {//判断是否输入内容，如果输入则执行，否则执行空
            } else {
                i += ChangeD.insertupname(id, name);
                outData += "\n   将名称修改为" + name;
            }
            if (this.jttype.getText().equals("")) {
            } else {
                i += ChangeD.insertuptype(id, type);
                outData += "\n   将类别修改为" + type;
            }
            if (this.jtstock.getText().equals("")) {
            } else {
                i += ChangeD.insertupstock(id, stock);
                outData += "\n   将库存修改为" + stock;
            }
            if (this.jtprice.getText().equals("")) {
            } else {
                i += ChangeD.insertupprice(id, price);
                outData += "\n   将价格修改为" + price;
            }

            if (i < 1) {
                JOptionPane.showMessageDialog(this, "修改失败！");
            } else {
                JOptionPane.showMessageDialog(this, "修改产品编号为： " + id + " 的数据成功！\n\n" + outData);
            }
            table = buildTable();
            jsp.setViewportView(table);
        }
        if (e.getSource() == cancel) {// 关闭程序
            this.dispose();
        }
    }

}
