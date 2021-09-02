import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class YouTube {
    private String videoName;
    private Byte[] content;
    private LocalDate date;
    private int resolution;
    private int minutes;
    private int seconds;
    private String[] comments;
    private int num_comments;
    private int likes;
    private int dislikes;

    public YouTube (){
        this.videoName = "None";
        this.content = new Byte[2048];
        this.date = LocalDate.now();
        this.resolution = 0;
        this.minutes= 0;
        this.seconds=0;
        this.comments = new String[200];
        this.num_comments = 0;
        this.likes = 0;
        this.dislikes = 0;
    }

    public YouTube (String videoName,Byte[] content, LocalDate date, int resolution,
                    int minutes, int seconds, String[] comments, int num_comments, int likes,int dislikes)
    {
        this.videoName =videoName;
        this.content = content;
        this.date = date;
        this.resolution = resolution;
        this.minutes= minutes;
        this.seconds=seconds;
        this.comments = comments;
        this.num_comments = num_comments;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getVideoName() {
        return videoName;
    }

    public Byte[] getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getResolution() {
        return resolution;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String[] getComments() {
        return comments;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setContent(Byte[] content) {
        this.content = content;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    public void insereComentario (String comentario){
        if (getNum_comments() == getComments().length)return;
        this.comments[getNum_comments()] = comentario;
        setNum_comments(getNum_comments() + 1);
    }
    public long qtsDiasDepois(){
        LocalDate now = LocalDate.now();
        LocalDate dateBefore;
        LocalDate dateAfter;
        long daysBetween = DAYS.between(now,getDate());
        return daysBetween;
    }
    public void thumbsUp(){
        setLikes(getLikes()+1);
    }

}
