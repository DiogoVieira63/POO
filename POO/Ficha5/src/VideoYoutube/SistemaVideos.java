package VideoYoutube;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SistemaVideos {
    private Map<String, VideoYouTube> videos;

    public SistemaVideos (){
        this.videos = new HashMap<>();
    }

    public SistemaVideos(Map<String, VideoYouTube> videos) {
        this.videos = videos;
    }

    public SistemaVideos(SistemaVideos sistemaVideos){
        setVideos(sistemaVideos.getVideos());
    }

    public Map<String, VideoYouTube> getVideos() {
        Map<String, VideoYouTube> map = new HashMap<>();
        for (Map.Entry<String, VideoYouTube> stringYouTubeEntry : videos.entrySet()) {
            map.put(stringYouTubeEntry.getKey(), stringYouTubeEntry.getValue());
        }
        return map;
    }

    public void setVideos(Map<String, VideoYouTube> videos) {
        Map<String, VideoYouTube> map = new HashMap<>();
        for (Map.Entry<String, VideoYouTube> stringYouTubeEntry : videos.entrySet()) {
            map.put(stringYouTubeEntry.getKey(), stringYouTubeEntry.getValue());
        }
        this.videos = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaVideos that = (SistemaVideos) o;
        return Objects.equals(getVideos(), that.getVideos());
    }

    @Override
    public String toString() {
        return "VideoYouTube{" +
                "videos=" + videos +
                '}';
    }

    public SistemaVideos clone (){
        return new SistemaVideos(this);
    }

    public void addVideo (VideoYouTube video){
        if (!this.videos.containsValue(video)){
            this.videos.put(video.getVideoName(),video);
        }
    }

    public VideoYouTube getVideo(String codVideo){
        if (this.videos.containsKey(codVideo))
            return this.videos.get(codVideo);
        return null;
    }

    public void removeVideo(String codVideo){
        this.videos.remove(codVideo);
    }

    public void addLike(String codVideo){
        if (getVideos().containsKey(codVideo)) {
            VideoYouTube video = getVideo(codVideo);
            video.setLikes(video.getLikes() + 1);
        }
    }

    public String topLikes(){
        if (this.videos.size() == 0) return null;
        return this.videos.entrySet().stream().
                sorted(Comparator.comparingInt(v -> v.getValue().getLikes())).
                map(Map.Entry::getKey).
                collect(Collectors.toList()).
                get(getVideos().size() -1);
    }

    public String topLikes(LocalDate dinicial, LocalDate dfinal){
        SistemaVideos v1 = clone();
        v1.videos = v1.videos.entrySet().stream().
                filter(v -> v.getValue().getDate().isAfter(dinicial) &&  v.getValue().getDate().isBefore(dfinal)).
        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return v1.topLikes();
    }

    public VideoYouTube videoMaisLongo(){
        return this.videos.entrySet().stream().
                sorted(Comparator.comparingInt(v-> v.getValue().timeInSeconds())).
                map(Map.Entry::getValue).
                collect(Collectors.toList()).
                get(getVideos().size() -1);
    }
}
