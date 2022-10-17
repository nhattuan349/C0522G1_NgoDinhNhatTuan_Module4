package com.email_program.repository;


import com.email_program.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{

private static List<String> languageList = new ArrayList<>();
private static List<Integer> pageSizeList = new ArrayList<>();
private static List<String> spamsFilterList = new ArrayList<>();



static {
    languageList.add("English");
    languageList.add("Vietnamese");
    languageList.add("Japanese");
    languageList.add("Chinese");

    pageSizeList.add(5);
    pageSizeList.add(10);
    pageSizeList.add(25);
    pageSizeList.add(50);
    pageSizeList.add(100);

    spamsFilterList.add("Enable spams filter");

}

    @Override
    public List<String> language() {
        return languageList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSizeList;
    }

    @Override
    public List<String> spamsFilter() {
        return spamsFilterList;
    }


}
