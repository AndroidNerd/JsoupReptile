package com.example.nerd.jsoupdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by nerd on 2017/3/22.
 */

public class JsoupTest {
    private static Map<Integer, String> cssMap = new HashMap<Integer, String>();
    private static BufferedWriter bufferedWriter = null;

    static {
        cssMap.put(1, "provincetr");// 省
        cssMap.put(2, "citytr");// 市
        cssMap.put(3, "countytr");// 县
        cssMap.put(4, "towntr");// 镇
        cssMap.put(5, "villagetr");// 村
    }

    public static void main(String[] args) throws IOException {
        int level = 1;
        initFile();
        // 获取全国各个省级信息
        Document connect = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/1999/");
        Elements rowProvince = connect.select("tr." + cssMap.get(level));
        for (Element provinceElement : rowProvince)// 遍历每一行的省份城市
        {
            Elements select = provinceElement.select("a");
            for (Element province : select)// 每一个省份(四川省)
            {
                bufferedWriter.write("--------"+province.getAllElements().get(0).text());
                bufferedWriter.newLine();
                bufferedWriter.flush();
                parseNextLevel(province, level +1);
            }
        }
        closeStream();
        System.out.print("success");
    }

    private static void initFile() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File("d:\\CityInfo.txt"), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeStream() {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bufferedWriter = null;
        }
    }

    private static void parseNextLevel(Element parentElement, int level) throws IOException {
        try {
            Thread.sleep(1);//睡眠一下，否则可能出现各种错误状态码
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document doc = connect(parentElement.attr("abs:href"));
        if (doc != null) {
            Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
            // 获取表格的一行数据
            for (Element element : newsHeadlines) {
                printInfo(element, level);
                Elements select = element.select("a");// 在递归调用的时候，这里是判断是否是村一级的数据，村一级的数据没有a标签
                if (select.size() !=0) {
                    parseNextLevel(select.last(), level +1);
                }
            }
        }
    }

    /**
     * 写一行数据到数据文件中去
     *
     * @param element 爬取到的数据元素
     * @param level   城市级别
     */
    private static void printInfo(Element element, int level) {
        try {
package com.example.nerd.jsoupdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by nerd on 2017/3/22.
 */

public class JsoupTest {
    private static Map<Integer, String> cssMap = new HashMap<Integer, String>();
    private static BufferedWriter bufferedWriter = null;

    static {
        cssMap.put(1, "provincetr");// 省
        cssMap.put(2, "citytr");// 市
        cssMap.put(3, "countytr");// 县
        cssMap.put(4, "towntr");// 镇
        cssMap.put(5, "villagetr");// 村
    }
    private static String Str0;
    private static String Str2;
    private static String Str3;
    private static String Str4;

    public static void main(String[] args) throws IOException {
        int level = 1;
        initFile();
        // 获取全国各个省级信息
        Document connect = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/");
        Elements rowProvince = connect.select("tr." + cssMap.get(level));
        for (Element provinceElement : rowProvince)// 遍历每一行的省份城市
        {
            Elements select = provinceElement.select("a");
            for (Element province : select)// 每一个省份(四川省)
            {
                Str0=province.getAllElements().get(0).text();
                parseNextLevel(province, level +1);
            }
        }
        closeStream();
        System.out.print("success");
    }

    private static void initFile() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File("d:\\CityInfo66.txt"), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeStream() {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bufferedWriter = null;
        }
    }

    private static void parseNextLevel(Element parentElement, int level) throws IOException {
        try {
            Thread.sleep(1);//睡眠一下，否则可能出现各种错误状态码
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document doc = connect(parentElement.attr("abs:href"));
        if (doc != null) {
            Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
            // 获取表格的一行数据
            for (Element element : newsHeadlines) {
                printInfo(element, level);
                Elements select = element.select("a");// 在递归调用的时候，这里是判断是否是村一级的数据，村一级的数据没有a标签
                if (select.size() !=0) {
                    parseNextLevel(select.last(), level +1);
                }
            }
        }
    }

    /**
     * 写一行数据到数据文件中去
     *
     * @param element 爬取到的数据元素
     * @param level   城市级别
     */
    private static void printInfo(Element element, int level) {
        try {
            switch (level){
                case 0:
//                    Str0="   "+element.select("td").last().text();
                    break;
                case 1:
//                    Str1="   "+element.select("td").last().text();
                    break;
                case 2:
                    Str2="   "+element.select("td").last().text();
                    break;
                case 3:
                    Str3="   "+element.select("td").last().text();
                    break;
                case 4:
                    Str4="   "+element.select("td").last().text();
                    break;
                case 5:
                    bufferedWriter.write(Str0+Str2+Str3+Str4+"     "+element.select("td").last().text());
                    bufferedWriter.newLine();
                    break;
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Document connect(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("The input url('" + url + "') is invalid!");
        }
        try {
            return Jsoup.connect(url).timeout(999999999*999999999).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
