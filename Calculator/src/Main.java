import javax.swing.*;

/**
 * Created by FckLove on 2/15/2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CalculatorPanel());
        frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}
