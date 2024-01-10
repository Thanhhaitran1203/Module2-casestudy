package view;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import controller.PhoneController;
import model.Phone;
import storage.CrawlDataByWeb;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
//        List<Phone> list = PhoneController.list1;
//        System.out.println(list);
//        List<Phone> result = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap key search");
//        String regex = sc.nextLine();
//
//        for (Phone phone:list){
//            if (phone.getName().contains(regex)){
//                result.add(phone);
//            }
//        }
//        for (Phone phone:result){
//            System.out.println(phone);
//        }
    }
    private static void createGUI(){
        MainUI ui = new MainUI();
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
