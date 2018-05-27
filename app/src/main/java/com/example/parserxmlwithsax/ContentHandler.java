package com.example.parserxmlwithsax;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by liuhuan1 on 2018/5/27.
 */

public class ContentHandler extends DefaultHandler {
    private int count=0;
    private String nodeName;
    private StringBuffer id,name,version;

    @Override
    public void startDocument() throws SAXException{
        id=new StringBuffer();
        name=new StringBuffer();
        version =new StringBuffer();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        nodeName=localName;//得到节点名
    }

    @Override
    public void characters(char[] ch,int start,int length) throws SAXException{
        count++;
        Log.d("count",String.valueOf(count));
        if("id".equals(nodeName)){
            id.append(ch,start,length);
        }else if ("name".equals(nodeName)){
            name.append(ch,start,length);
        }else if("version".equals(nodeName)){
            version.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri,String localName,String qName) throws SAXException{
        if ("app".equals(localName)){
            Log.d("huan","id is:"+id.toString().trim());
            Log.d("huan","name is:"+name.toString().trim());
            Log.d("huan","version is:"+version.toString().trim());
            //将这三个变量清空，使其不影响下一轮的赋值
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException{
        super.endDocument();
    }
}
