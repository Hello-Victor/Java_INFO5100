/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;

/**
 *
 * @author harshalneelkamal
 */
public class DataStore {
    
    private static DataStore dataStore;
    
    private Map<Integer, User> users;
    private Map<Integer, Post> posts;
    private Map<Integer, Comment> comments;
    
    private DataStore(){
        users = new HashMap<>();
        posts = new HashMap<>();
        comments = new HashMap<>();
    }
    
    public static DataStore getInstance(){
        if(dataStore == null)
            dataStore = new DataStore();
        return dataStore;
    }

    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setDataStore(DataStore dataStore) {
        DataStore.dataStore = dataStore;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, Post> getPosts() {
        return posts;
    }

    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, Comment> comments) {
        this.comments = comments;
    }

}
