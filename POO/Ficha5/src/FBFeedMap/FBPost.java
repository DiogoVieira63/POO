package FBFeedMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FBPost {
        private int identificador;
        private String utilizador;
        private LocalDateTime date;
        private String content;
        private int numberLikes;
        private List<String> comentarios;

        public FBPost(int identificador, String utilizador, LocalDateTime date, String content, int numberLikes, List<String> comentarios) {
            this.identificador = identificador;
            this.utilizador = utilizador;
            this.date = date;
            this.content = content;
            this.numberLikes = numberLikes;
            setComentarios(comentarios);
        }

        public FBPost (){
            this.identificador = -1;
            this.utilizador = "n/a";
            this.date = LocalDateTime.now();
            this.content = "n/a";
            this.numberLikes = 0;
            this.comentarios = new ArrayList<>();
        }

        public FBPost(FBPost post){
            this.identificador = post.getIdentificador();
            this.utilizador = post.getUtilizador();
            this.date = post.getDate();
            this.content = post.getContent();
            this.numberLikes = post.getNumberLikes();
            setComentarios(post.getComentarios());
        }

        public int getIdentificador() {
            return identificador;
        }

        public void setIdentificador(int identificador) {
            this.identificador = identificador;
        }

        public String getUtilizador() {
            return utilizador;
        }

        public void setUtilizador(String utilizador) {
            this.utilizador = utilizador;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getNumberLikes() {
            return numberLikes;
        }

        public void setNumberLikes(int numberLikes) {
            this.numberLikes = numberLikes;
        }

        public List<String> getComentarios() {
            return comentarios;
        }

        public void setComentarios(List<String> comentarios) {
            this.comentarios.addAll(comentarios);
        }

        public FBPost clone (){
            return new FBPost(this);
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FBPost fbPost = (FBPost) o;
            return getIdentificador() == fbPost.getIdentificador() && getNumberLikes() == fbPost.getNumberLikes() && Objects.equals(getUtilizador(), fbPost.getUtilizador()) && Objects.equals(getDate(), fbPost.getDate()) && Objects.equals(getContent(), fbPost.getContent()) && Objects.equals(getComentarios(), fbPost.getComentarios());
        }

        public String toString() {
            return "FBPost{" +
                    "identificador=" + identificador +
                    ", utilizador='" + utilizador + '\'' +
                    ", date=" + date +
                    ", content='" + content + '\'' +
                    ", numberLikes=" + numberLikes +
                    ", comentarios=" + comentarios +
                    '}';
        }
}
