import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by FckLove on 2/15/2016.
 */
public class CalculatorPanel extends JPanel{
    private boolean check=true;
    private String lastValue;
    private char math;
    private ArrayList<JButton> buttonlist;
    private JLabel lb_head;
    private JTextField tf_result;
    private JButton bt_add,bt_subt,bt_mul,bt_div,bt_c,bt_equal;
    public CalculatorPanel()
    {
        buttonlist=new ArrayList<JButton>();
        setLayout(new MigLayout("insets 5","[center]8[]","[center]8[]"));
        ///
        lb_head=new JLabel("Casio Calculator Simulation");
        lb_head.setBackground(Color.BLUE);
        tf_result=new JTextField(18);
        tf_result.setText("0");
        tf_result.setEditable(false);
        ////
        Dimension s=new Dimension(20,20);
        NumberButton num=new NumberButton();

        for(Integer i=0;i<10;i++)
        {
            JButton bt=new JButton(i.toString());
            bt.addActionListener(num);
            buttonlist.add(bt);
        }
        //
        MathButton m=new MathButton();
        bt_c=new JButton(" C ");
        bt_c.addActionListener(num);
        bt_add=new JButton("+");
        bt_add.addActionListener(m);
        bt_subt=new JButton(" - ");
        bt_subt.addActionListener(m);
        bt_mul=new JButton("x");
        bt_mul.addActionListener(m);
        bt_div=new JButton(" / ");
        bt_div.addActionListener(m);
        bt_equal=new JButton(" = ");
        bt_equal.addActionListener(m);
        /////////////////////
        add(lb_head, "span");
        add(tf_result,"span");
        add(buttonlist.get(1));
        add(buttonlist.get(2));
        add(buttonlist.get(3));
        add(bt_add,"wrap");
        add(buttonlist.get(4));
        add(buttonlist.get(5));
        add(buttonlist.get(6));
        add(bt_subt,"wrap");
        add(buttonlist.get(7));
        add(buttonlist.get(8));
        add(buttonlist.get(9));
        add(bt_mul,"wrap");
        add(buttonlist.get(0));
        add(bt_c);
        add(bt_equal);
        add(bt_div);
        /////
    }
    ////////
    private class NumberButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp=tf_result.getText();
            for(int i=0;i<10;i++)
            {
                if(e.getSource()==buttonlist.get(i)
                        &&(e.getSource()!=buttonlist.get(0) || temp.equals("0")==false))
                {
                    if(check)
                    {
                        temp="";
                    }
                    temp=temp+buttonlist.get(i).getText();
                    tf_result.setText(temp);
                    check=false;
                }
            }
            ///bt_c
            if(e.getSource()==bt_c)
            {
                temp="0";
                check=true;
                lastValue="0";
                tf_result.setText(temp);
            }
        }
    }
    ////////
    private class MathButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp=tf_result.getText();
            //bt_add
            if(e.getSource()==bt_add)
            {
                lastValue=temp;
                math='+';
                check=true;
            }
            //bt_subt
            if(e.getSource()==bt_subt)
            {
                lastValue=temp;
                math='-';
                check=true;
            }
            //bt_mul
            if(e.getSource()==bt_mul)
            {
                lastValue=temp;
                math='x';
                check=true;
            }
            //bt_div
            if(e.getSource()==bt_div)
            {
                lastValue=temp;
                math='/';
                check=true;
            }
            //bt_equal
            if(e.getSource()==bt_equal)
            {
                Math mt=new Math(lastValue,temp);
                switch (math)
                {
                    case '+':temp=mt.Add();
                        tf_result.setText(temp);
                        check=true;
                        lastValue=temp;
                        break;
                    case '-':temp=mt.Subt();
                        tf_result.setText(temp);
                        check=true;
                        lastValue=temp;
                        break;
                    case 'x':temp=mt.Mul();
                        tf_result.setText(temp);
                        check=true;
                        lastValue=temp;
                        break;
                    case '/':if(temp.equals("0")==false)
                    {
                        temp=mt.Div();
                        tf_result.setText(temp);
                        check=true;
                        lastValue=temp;
                    }else
                    {
                        tf_result.setText("ERROR!");
                        check=true;
                        lastValue="0";
                    }
                        break;
                }
            }
        }
    }
}
