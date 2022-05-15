package com.datastructure.cache.assignment1;

public class TestingAssignment {
    public static void main(String[] args) {
        CustomizeLRUCache<String ,User>  testing =new CustomizeLRUCache<>(5);
        testing.set("nitin", new User(27,"nitin") );
    }
}
