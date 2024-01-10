package view;

import controller.PhoneController;
import model.Phone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MainUI {
    private JPanel rootPanel;
    private JTable showTable;
    private JTable showTable2;
    private List<Phone> data1 = PhoneController.list1;
    private List<Phone> data2 = PhoneController.list2;

    public MainUI(){
        createTable(showTable,data1);
        createTable(showTable2,data2);
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
