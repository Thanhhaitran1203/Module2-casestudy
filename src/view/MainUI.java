package view;

import controller.PhoneController;
import model.Phone;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainUI extends JTable{
    private JPanel rootPanel;
    private JTable showTable;
    private JTable showTable2;
    private JTextField txtSearch;
    private JButton searchButton;
    private List<Phone> data1 = PhoneController.list1;
    private List<Phone> data2 = PhoneController.list2;
    private DefaultTableCellRenderer minRenderer;


    public MainUI(){
        createTable(showTable,data1);
        createTable(showTable2,data2);
        rootPanel.addKeyListener(new KeyAdapter() {
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String key = txtSearch.getText();
                List<Phone> result1 = new ArrayList<>();
                List<Phone> result2 = new ArrayList<>();
                result1 = PhoneController.searchPhone(data1,key);
                result2 = PhoneController.searchPhone(data2,key);
                createTable(showTable,result1);
                createTable(showTable2,result2);
            }
        });
    }
    private int findMinIndexJTable(JTable table){
        int min = findMinJTable(table);
        ArrayList<String> arr = getPriceTable(table);
        for (int i=0;i< arr.size();i++){
            arr.set(i,arr.get(i).replaceAll("\\p{Punct}",""));
        }
        for (int i=0;i< arr.size();i++) {
            if ( Integer.parseInt(arr.get(i)) == min){
                return i;
        }
        }
        return -1;
    }
    private int findMinJTable(JTable table){
        int min = PhoneController.findMinPrice(getPriceTable(table));
        return min;
    }
    private ArrayList<String> getPriceTable(JTable table){
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < table.getRowCount();i++){
            arr.add(table.getValueAt(i,1).toString());
        }
        return arr;
    }
    private void createTable(JTable table, List<Phone> list){
        List<Phone> phones = list;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("price");

        for (Phone phone:phones){
            defaultTableModel.addRow(new Object[]{phone.getName(),phone.getPrice()});
        }
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }
     class MyTableCellRender extends JTable {
         int minIndex = findMinIndexJTable(showTable);

         public MyTableCellRender() {
             setOpaque(true);
         }

         public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
         {
             int minIndex = findMinIndexJTable(showTable);
             Component c = super.prepareRenderer(renderer, row, column);
             if (row == minIndex)
                 c.setBackground(Color.BLUE);

             return c;
         }
     }
}
