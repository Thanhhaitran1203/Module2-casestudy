package controller;

import model.Phone;
import storage.CrawlDataByWeb;
import storage.ICrawlData;

import java.util.List;

public class PhoneController {
    private static ICrawlData crawlData = CrawlDataByWeb.getInstance();
    public static List<Phone> list1 = crawlData.crawData1();
    public static List<Phone> list2 = crawlData.crawData2();
}
