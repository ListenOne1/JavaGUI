import java.awt.event.*;
import javax.swing.*;
class display{
    private final JLabel lb2;
    private final JTextField tf1, tf2, tf3;

    public display(){
        // create frame object and title
        JFrame frame = new JFrame("Compound Interest");
        // layout
        frame.setLayout(null);

        // create label
        JLabel lb1 = new JLabel("Investing an original $");
        lb1.setBounds(5,5,150,20); // set coordinate
        frame.add(lb1); // add to label

        // create a input for the money you have
        tf1 = new JTextField("");
        tf1.setBounds(150, 5, 100, 20); // set coordinate
        frame.add(tf1);

        lb1 = new JLabel(" at ");
        lb1.setBounds(250,5,20,20);
        frame.add(lb1);

        // input for interest rate
        tf2 = new JTextField("");
        tf2.setBounds(270, 5, 50, 20);
        frame.add(tf2);

        lb1 = new JLabel("% compounded ");
        lb1.setBounds(320,5,100,20);
        frame.add(lb1);

        String[] s1 = {"annually","monthly"};
        JComboBox cb = new JComboBox(s1);
        cb.setSelectedIndex(0);
        cb.setBounds(420,5,125,20);
        frame.add(cb);

        lb1 = new JLabel("how much would you have after");
        lb1.setBounds(5,37,200,20);
        frame.add(lb1);

        // input for the year
        tf3 = new JTextField("");
        tf3.setBounds(205, 37, 50, 20);
        frame.add(tf3);

        lb1 = new JLabel("years?");
        lb1.setBounds(255,37,50,20);
        frame.add(lb1);

        JButton btn1 = new JButton("Calculate");
        btn1.setBounds(5, 67, 100, 20);
        frame.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num,rate,Year;
                String A;
                try{
                    num = Double.parseDouble(tf1.getText());
                    rate = Double.parseDouble(tf2.getText());
                    Year = Double.parseDouble(tf3.getText());

                    String val = (String)cb.getSelectedItem();
                    switch(val){
                        case "annually":
                            A = String.format("%.03f",num * Math.pow((1 + rate * 0.01), Year));
                            break;
                        case "monthly":
                            A = String.format("%.03f",num * Math.pow((1 + (rate/12 + rate%12) * 0.01), Year * 12));
                            break;
                        default: A = "Error";
                    }

                    lb2.setText("$: " + A);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Please check the number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btn2 = new JButton("Clear");
        btn2.setBounds(110, 67, 100, 20);
        frame.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                lb2.setText("Answer");
            }
        });

        lb2 = new JLabel("Answer");
        lb2.setBounds(5, 97, 200, 40);
        frame.add(lb2);

        frame.setSize(600,350);
        frame.setVisible(true); // show the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window



    }

}
public class Main{
    public static void main(String[] args) {
        new display();
    }
}