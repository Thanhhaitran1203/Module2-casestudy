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
    public static int findMinPrice(ArrayList<String> arr){
        for (int i=0;i< arr.size();i++){
            arr.set(i,arr.get(i).replaceAll("\\p{Punct}",""));
        }
        int min = Integer.parseInt(arr.get(0));
        for (int i = 0; i < arr.size(); i++) {
            if (min > Integer.parseInt(arr.get(i))){
                min = Integer.parseInt(arr.get(i));
            }
        }
        return min;
    }
}
