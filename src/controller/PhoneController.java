package controller;

import model.Phone;
import storage.CrawlDataByWeb;
import storage.ICrawlData;

import java.util.ArrayList;
import java.util.List;

public class PhoneController {
    private static ICrawlData crawlData = CrawlDataByWeb.getInstance();
    public static List<Phone> list1 = crawlData.crawData1();
    public static List<Phone> list2 = crawlData.crawData2();
    public static List<Phone> searchPhone(List<Phone> list,String key){
        List<Phone> result = new ArrayList<>();
        for (Phone phone:list){
            if (phone.getName().contains(key)){
                result.add(phone);
            }
        }
        return result;
    }
}
