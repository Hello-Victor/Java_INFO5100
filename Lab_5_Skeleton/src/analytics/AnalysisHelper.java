/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Q1 - Average number of likes per comments: " + likeNumber / commentNumber);
            
    }
    
    public void getMaxLikeCommentPost(){
        DataStore data = DataStore.getInstance();
        Comment commentWithMaxLikes = null;
        
        for(Comment c : data.getComments().values()){
            if(commentWithMaxLikes == null){
                commentWithMaxLikes = c;
            }
            
            if(c.getLikes() > commentWithMaxLikes.getLikes()){
                commentWithMaxLikes = c;

            }
                
        }
        
        int postId = commentWithMaxLikes.getPostId();
        System.out.println("Q2 - Post with most likes per comment:" + data.getPosts().get(postId).getPostId());

    }
    
    
    public void getPostWithMostComments(){
        DataStore data = DataStore.getInstance();
        Post postWithMostComments = null;
        for(Post p : data.getPosts().values()){
            if(postWithMostComments == null){
                postWithMostComments = p;
            }
            
            if(p.getComments().size()>postWithMostComments.getComments().size()){
                postWithMostComments = p;
            }
            
            if(p.getComments().size() > postWithMostComments.getComments().size()){
                postWithMostComments = p;
            }
        }
        System.out.println("Q3 - Post with most comments:"+postWithMostComments.getPostId());

    }
    
    
    
    public void getPassiveUsers(){
        
        DataStore data = DataStore.getInstance();
        HashMap<Integer, Integer> postNumbers = new HashMap<Integer, Integer>();
        
        for(Post p : data.getPosts().values()){
            int userId = p.getUserId();
            if(postNumbers.containsKey(userId)){
                postNumbers.put(userId, postNumbers.get(userId)+1);
            } else {
                postNumbers.put(userId, 1);
            }      
        }
    
    
        ArrayList<User> users = new ArrayList(data.getUsers().values());
        Collections.sort(users, new UserMapComparator(postNumbers));
        System.out.println("Q4 - The following users have the least posts:"); 
        for(int i = 0 ;i <5; i++){
            System.out.println(users.get(i) + ",  -Post count:" + postNumbers.get(users.get(i).getId())); 
        }
    }
    
        public void getPassiveCommentUsers(){
            DataStore data = DataStore.getInstance();
            HashMap<Integer, Integer>commentNumbers = new HashMap<Integer, Integer>();
            for(Comment c : data.getComments().values()){
                int userId = c.getUserId();
                if(commentNumbers.containsKey(userId)){
                        commentNumbers.put(userId, commentNumbers.get(userId)+1);
                } else {
                        commentNumbers.put(userId, 1);
   
                }

            }
                ArrayList<User> users = new ArrayList(data.getUsers().values());
                Collections.sort(users, new UserMapComparator(commentNumbers));
                System.out.println("Q5 - The following users have the least comments:");
                
                for(int i = 0; i<5; i++){
                    System.out.println(users.get(i) + ", - Comment count:" + commentNumbers.get(users.get(i).getId()));
 
                }

               }
        
                public void getPassiveAndActiveOverallUsers(){
                    
                DataStore data = DataStore.getInstance();
                HashMap<Integer, Integer> overallNumbers = new HashMap<Integer, Integer>();
                for(Comment c : data.getComments().values()){
                    int userId = c.getUserId();
                    if (overallNumbers.containsKey(userId)){
                        overallNumbers.put(userId, overallNumbers.get(userId)+1+c.getLikes());    
                    } else {
                        overallNumbers.put(userId, 1+c.getLikes());                
                    }
                }
                
                ArrayList<User> users = new ArrayList(data.getUsers().values());
                Collections.sort(users, new UserMapComparator(overallNumbers));
               
                System.out.println("Q6 - The following users have overall been passive:");
                for(int i = 0; i<5;i++){
                    System.out.println(users.get(i)+",  -Overall count:" + overallNumbers.get(users.get(i).getId()));             
                }
                
                    System.out.println("Q7 - The following users have overall been active:");
                 for(int i = users.size()-1 ; i > users.size() -6 ; i--){
                     System.out.println(users.get(i)+", - Overall count: " + overallNumbers.get(users.get(i).getId()));
                 
                 }
                
        }
    
}
