package FBFeedMap;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeedMap {
    private Map<String, List<FBPost>> feed;


    public FBFeedMap (FBFeedMap map){
        setFeed(map.feed);
    }

    public FBFeedMap (){
        this.feed = new HashMap<>();
    }

    public Map<String, List<FBPost>> getFeed() {
        return feed;
    }

    public void setFeed(Map<String, List<FBPost>> feed) {
        this.feed = new HashMap<>();
        feed.forEach((key, value) -> {
            for (FBPost post : value){
                addPost(key,post);
            }
        });
    }

    public void addPost(String user, FBPost post){
        feed.putIfAbsent(user,new ArrayList<>());
        if (!feed.get(user).contains(post)) feed.get(user).add(post);
    }

    public void removePosts(String user, LocalDateTime di, LocalDateTime df){
        feed.entrySet().stream().
                filter(entry -> entry.getValue().removeIf(fbPost -> fbPost.getDate().isAfter(di) && fbPost.getDate().isBefore(df))).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df){
        FBFeedMap clone = clone();
        return (int) clone.feed.entrySet().stream().
                filter(entry -> entry.getValue().removeIf(fbPost -> fbPost.getDate().isBefore(di) || fbPost.getDate().isAfter(df))).
                count();
    }

    public String utilizadorMaisActivo(LocalDateTime di, LocalDateTime df){
        FBFeedMap clone = clone();
        clone.postsNumPeriodo(di,df);
        String maior = null;
        int sizeMaior = 0;
        for (Map.Entry<String, List<FBPost>> entry: feed.entrySet()){
            int size = entry.getValue().size();
            if (size > sizeMaior){
                sizeMaior = size;
                maior = entry.getKey();
            }
        }
        return maior;
    }

    public List<FBPost> timelineGlobal(){
        List<FBPost> all = feed.values().stream().
                flatMap(List :: stream).
                sorted(Comparator.comparing(fbPost -> fbPost.getDate())).
                collect(Collectors.toList());
        return all;
    }

    public boolean validaPostsSimultaneos(){
        for (List <FBPost> list : feed.values()){
            Set<LocalDateTime> set = new HashSet<>();
            for (FBPost post: list){
                if (set.contains(post.getDate())) return false;
                set.add(post.getDate());
            }
        }
        return true;
    }


    public FBFeedMap clone (){
        return new FBFeedMap(this);
    }

    
    @Override
    public String toString() {
        return "FBFeedMap{" +
                "feed=" + feed +
                '}';
    }
}
