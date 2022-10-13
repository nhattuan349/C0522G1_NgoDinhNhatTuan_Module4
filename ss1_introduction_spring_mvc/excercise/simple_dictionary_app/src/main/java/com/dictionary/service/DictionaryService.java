package com.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("yellow", "màu vàng");
    }

    @Override
    public String search(String keyWord) {
        if (dictionary.get(keyWord) == null) {
            return "Không tồn tại trong từ điển";
        }else{
            return dictionary.get(keyWord);
        }

    }
}
