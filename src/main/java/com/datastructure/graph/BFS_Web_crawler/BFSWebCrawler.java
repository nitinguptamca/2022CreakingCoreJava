package com.datastructure.graph.BFS_Web_crawler;

public class BFSWebCrawler {
    public static void main(String[] args) {
        BFS bfs =new BFS();
        bfs.discoverWeb("https://www.bbc.com");
    }
}
