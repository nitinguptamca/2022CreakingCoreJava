package com.datastructure.graph.BFS_Web_crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {
    private Queue<String> queue;
    private List<String> discoveredWenSiteList;

    public BFS() {
        this.queue = new LinkedList<>();
        this.discoveredWenSiteList = new ArrayList<>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWenSiteList.add(root);
        while (!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHtml = readURL(v);
            String regexp = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern =Pattern.compile(regexp);
            Matcher matcher =pattern.matcher(rawHtml);
            while (matcher.find()){
                String w =matcher.group();
                if (!discoveredWenSiteList.contains(w)){
                    discoveredWenSiteList.add(w);
                    System.out.println("website found " +w);
                    queue.add(w);
                }
            }
        }
    }
///read the html content the website
    private String readURL(String v) {
        StringBuilder rawHTLM = new StringBuilder("");
        try {
            URL url = new URL(v);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line = "";
            while ((line = reader.readLine()) != null) {
                rawHTLM.append(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("problem while crawling the website");
        }
        return rawHTLM.toString();

    }

}
