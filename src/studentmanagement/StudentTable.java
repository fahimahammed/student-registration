
package studentmanagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fahim
 */
public class StudentTable extends JFrame implements ActionListener{
    
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, fnLabel, lnLabel, ageLabel, resultLabel, abc;
    private JTextField fnText, lnText, ageText, resultText;
    private JButton addBtn, delBtn, updatedBtn, clearBtn;
    private Font font;
    
    private String[] col = {"First Name", "Last Name", "Age", "Result"};
    private String[] rows = new String[4];
    
    StudentTable(){
        initComponents();
    }
    public void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Registration Form");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);
        
        titleLabel = new JLabel("Student Registration Form");
        titleLabel.setBounds(170, 10, 450, 50);
        font = new Font("Calibri", Font.BOLD,  40);
        titleLabel.setFont(font);
        c.add(titleLabel);
        
        fnLabel = new JLabel("First Name: ");
        fnLabel.setBounds(50, 110, 100, 20);
        c.add(fnLabel);
        
        fnText = new JTextField();
        fnText.setBounds(150, 105, 150, 30);
        c.add(fnText);
        
        lnLabel = new JLabel("Last Name: ");
        lnLabel.setBounds(50, 160, 100, 20);
        c.add(lnLabel);
        
        lnText = new JTextField();
        lnText.setBounds(150, 155, 150, 30);
        c.add(lnText);
        
        ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(50, 205, 100, 20);
        c.add(ageLabel);
        
        ageText = new JTextField();
        ageText.setBounds(150, 200, 150, 30);
        c.add(ageText);
        
        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 255, 100, 20);
        c.add(resultLabel);
        
        resultText = new JTextField();
        resultText.setBounds(150, 250, 150, 30);
        c.add(resultText);
        
        addBtn = new JButton("Add");
        addBtn.setBounds(400, 105, 100, 25);
        c.add(addBtn);
        
        delBtn = new JButton("Delete");
        delBtn.setBounds(400, 155, 100, 25);
        c.add(delBtn);
        
        updatedBtn = new JButton("Update");
        updatedBtn.setBounds(400, 200, 100, 25);
        c.add(updatedBtn);
        
        clearBtn = new JButton("Clear");
        clearBtn.setBounds(400, 250, 100, 25);
        c.add(clearBtn);
        
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setSelectionBackground(Color.YELLOW);
        table.setBackground(Color.WHITE);
        font = new Font("SansSerif", Font.BOLD,  12);
        table.setFont(font);
        table.setRowHeight(30);
        
        scroll = new JScrollPane(table);
        scroll.setBounds(10, 360, 750, 265);
        c.add(scroll);
        
        addBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        delBtn.addActionListener(this);
        updatedBtn.addActionListener(this);
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int rowNum = table.getSelectedRow();
                
                String fName = model.getValueAt(rowNum, 0).toString();
                String lName = model.getValueAt(rowNum, 1).toString();
                String age = model.getValueAt(rowNum, 2).toString();
                String result = model.getValueAt(rowNum, 3).toString();
                
                fnText.setText(fName);
                lnText.setText(lName);
                ageText.setText(age);
                resultText.setText(result);
            }
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==addBtn){
            
            rows[0] = fnText.getText();
            rows[1] = lnText.getText();
            rows[2] = ageText.getText();
            rows[3] = resultText.getText();
            model.addRow(rows);
            
        }
        else if(event.getSource()==clearBtn){
            
            fnText.setText("");
            lnText.setText("");
            ageText.setText("");
            resultText.setText("");
        }
        else if(event.getSource()==delBtn){
            int rowNum = table.getSelectedRow();
            if(rowNum >= 0){
                model.removeRow(rowNum);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please selct a row");
            }
        }
        else if(event.getSource()==updatedBtn){
            int numRow = table.getSelectedRow();
            String fName = fnText.getText();
            String lName = lnText.getText();
            String age = ageText.getText();
            String result = resultText.getText();
            
            model.setValueAt(fName, numRow, 0);
            model.setValueAt(lName, numRow, 1);
            model.setValueAt(age, numRow, 2);
            model.setValueAt(result, numRow, 3);
        }
    }
    
    public static void main(String[] args) {
        StudentTable frame = new StudentTable();
        frame.setVisible(true);
    }
    
}
