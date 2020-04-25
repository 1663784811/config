package cn.cyyaw.jpa;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
    private PageUtil() {
    }

    public static Map<String, Object> pageFormat(Page page) {
        if (null != page) {
            Map<String, Object> map = new HashMap<>();
            map.put("page", page.getNumber()+1);
            map.put("size", page.getSize());
            map.put("total", page.getTotalElements());
            map.put("data", page.getContent());
            return map;
        }
        return null;
    }
}
