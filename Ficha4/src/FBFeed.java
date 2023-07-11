import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class FBFeed{
    List <FBPost> posts;

    FBFeed (){
        this.posts = new ArrayList<>();
    }

    FBFeed (List <FBPost> list){
        setPosts(list);
    }

    FBFeed (FBFeed feed){
        setPosts(feed.getPosts());
    }

    public int nrPosts(String user){
        return (int) this.posts.stream().filter(fbPost -> fbPost.getUtilizador().equals(user)).count();
    }

    public List<FBPost> postsOf(String user){
        List <FBPost> list = new ArrayList<FBPost>();
        for (FBPost post : this.posts){
            if (post.getUtilizador().equals(user)){
                list.add(post);
            }
        }
        return list;
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return (List<FBPost>) postsOf(user).stream().filter(fbPost -> fbPost.getDate().isBefore(fim) && fbPost.getDate().isAfter(fim)).collect(Collectors.toList());
    }
    public FBPost getPost(int id){
        for (FBPost post : this.posts){
            if (post.getIdentificador() == id) return post;
        }
        return null; //NOT FOUND
    }
    public void comment(FBPost post, String comentario){
        post.getComentarios().add(comentario);
    }

    public void like(FBPost post){
        post.setNumberLikes(post.getNumberLikes()+1);
    }

    public void like(int postid){
        like(getPost(postid));
    }

    public List<Integer> top5Comments(){
        List <Integer> list;
        list = this.posts.stream()
                .sorted(Comparator.comparingInt(post -> post.getComentarios().size()))
                .map(FBPost::getIdentificador)
                .limit(5)
                .collect(Collectors.toList());
        return list;
    }


    public List<Integer> top5comments(){
        List<Integer> list = new ArrayList<>();
        FBFeed copy = clone();
        Iterator <FBPost> iter = clone().getPosts().iterator();
        for (int i = 0; i < 5; i++) {
            int numMaxComment = 0, idMaxComment = 0;
            while (iter.hasNext()) {
                if (iter.next().getComentarios().size() > numMaxComment){
                    numMaxComment = iter.next().getComentarios().size();
                    idMaxComment = iter.next().getIdentificador();
                }
            }
            list.add(getPost(idMaxComment).getIdentificador());
            int finalIdMaxComment = idMaxComment;
            copy.getPosts().removeIf(fbPost -> fbPost.getIdentificador() == finalIdMaxComment);
        }
        return list;
    }


    public List<FBPost> getPosts() {
        return posts;
    }

    public void setPosts(List<FBPost> posts) {
        this.posts.addAll(posts);
    }

    @Override
    public String toString() {
        return "FBFeed{" +
                "posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FBFeed feed = (FBFeed) o;
        return Objects.equals(getPosts(), feed.getPosts());
    }

    public FBFeed clone (){
        return new FBFeed(this);
    }
}
