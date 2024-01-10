package storage;
import model.Phone;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlDataByWeb implements ICrawlData{

    private CrawlDataByWeb(){

    }
    private static CrawlDataByWeb instance;
    public static CrawlDataByWeb getInstance(){
        if (instance == null){
            synchronized (CrawlDataByWeb.class){
                if (instance == null){
                    instance = new CrawlDataByWeb();
                }
            }
        }
        return instance;
    }


    public List<Phone> crawData1(){
        List<Phone> list = new ArrayList<>();
        try{
            URL url = new URL("https://24hstore.vn/dien-thoai-iphone-apple");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n", "");
            Pattern namePattern = Pattern.compile("<h3(.*?)\" >(.*?)</h3>");
            Matcher nameMatcher = namePattern.matcher(content);
            Pattern pricePattern = Pattern.compile("class=\"price\">(.*?)</span>");
            Matcher priceMatcher = pricePattern.matcher(content);
            while (nameMatcher.find() && priceMatcher.find()){
                String name = nameMatcher.group(2);
                String name2 = name.trim();
                String price = priceMatcher.group(1);
                price.trim();
                list.add(new Phone(name2,price));
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Phone> crawData2(){
        List<Phone> list = new ArrayList<>();
        try{
            URL url = new URL("https://xoanstore.vn/iphone");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n", "");
            Pattern namePattern = Pattern.compile("title=\"iPhone(.*?)product__box-name\">(.*?)</a>");
            Matcher nameMatcher = namePattern.matcher(content);
            Pattern pricePattern = Pattern.compile("title=\"iPhone(.*?)class=\"price\">(.*?)</span>");
            Matcher priceMatcher = pricePattern.matcher(content);
            while (nameMatcher.find() && priceMatcher.find()){
                String name = nameMatcher.group(2);
                name.trim();
                String price = priceMatcher.group(2);
                price.trim();
//                String[] temp = price.split("₫");
                list.add(new Phone(name,price));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
