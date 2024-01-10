package view;

import controller.PhoneController;
import model.Phone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MainUI {
    private JPanel rootPanel;
    private JTable showTable;
    private JTable showTable2;
    private JTextField txtSearch;
    private JButton searchButton;
    private List<Phone> data1 = PhoneController.list1;
    private List<Phone> data2 = PhoneController.list2;


    public MainUI(){
        createTable(showTable,data1);
        createTable(showTable2,data2);
        rootPanel.addKeyListener(new KeyAdapter() {
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}
