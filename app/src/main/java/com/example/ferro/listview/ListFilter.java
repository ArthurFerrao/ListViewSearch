package com.example.ferro.listview;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ferrão on 24/09/2016.
 */
public class ListFilter {
    static ArrayList<String> filter(ArrayList<String> list , String digito){
        ArrayList<String> filterList= new ArrayList<String>();
        String modelo = "[a-zA-Z]{0,}"+digito+"{0,}[a-zA-Z]{0,}";
        Pattern pattern = Pattern.compile(modelo);
        Matcher matcher;
        for(int x = 0; x < list.size() ; x++){
             matcher = pattern.matcher(list.get(x));
            if(matcher.find()){
                filterList.add(list.get(x));
            }
        }
        return filterList;
    }
}
