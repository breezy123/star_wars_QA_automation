package org.example.UI.pageobjects;

import java.io.FileInputStream;
import java.util.Properties;

public class PageObjects {
    private static final String page_ObjectFile = "\\src\\test\\resources\\page_elements.props";
    public String pageElement="";
    public PageObjects(){}
    public String pageElement(String imageName){
        try {

            Properties p = new Properties();
            p.load(new FileInputStream(System.getProperty("user.dir")+page_ObjectFile));

            if(p.getProperty(imageName)==null){
                return null;
            }
            else {
               return pageElement =p.getProperty(imageName);
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
