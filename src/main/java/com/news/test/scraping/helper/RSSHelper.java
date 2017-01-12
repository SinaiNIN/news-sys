package com.news.test.scraping.helper;

import com.news.test.scraping.entities.Item;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinai on 1/11/17.
 */
public class RSSHelper {
    public static List<Item> read(String url){
        List<Item> listItems=new ArrayList<Item>();
        try{
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse(url);
            XPath xPath= XPathFactory.newInstance().newXPath();
            NodeList nodeList=(NodeList) xPath.compile("//item").evaluate(document, XPathConstants.NODESET);
            for(int i=0;i<nodeList.getLength();i++){
                Item item=new Item();
                item.setCategory(xPath.compile("./category").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                item.setDescription(xPath.compile("./description").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                item.setGuid(xPath.compile("./guid").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                item.setLink(xPath.compile("./link").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                item.setPubDate(xPath.compile("./pubdate").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                item.setTitle(xPath.compile("./title").evaluate(nodeList.item(i),XPathConstants.STRING).toString());
                listItems.add(item);
            }
        }catch (Exception e){
            listItems=null;
        }
        return listItems;
    }
}
