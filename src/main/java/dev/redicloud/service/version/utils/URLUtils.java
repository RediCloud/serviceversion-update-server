package dev.redicloud.service.version.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class URLUtils {

    public static String getContent(String rwaUrl) throws Exception {
        URL url = new URL(rwaUrl);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer builder = new StringBuffer();
        while(sc.hasNext()) {
            builder.append(sc.next());
        }
        String result = builder.toString();
        result = result.replaceAll("<[^>]*>", "");
        return result;
    }

    public static Collection<String> getLines(String rwaUrl) throws Exception {
        URL url = new URL(rwaUrl);
        Scanner sc = new Scanner(url.openStream());
        List<String> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.next());
        }
        return list;
    }

}
