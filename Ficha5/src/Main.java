import Aluno_Turma.Aluno;
import Aluno_Turma.TurmaAlunos;
import FBFeedMap.FBFeedMap;
import FBFeedMap.FBPost;
import Grafos.Grafo;
import Parque_Lugar.Lugar;
import Parque_Lugar.Parque;
import VideoYoutube.SistemaVideos;
import VideoYoutube.VideoYouTube;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        /*Parque parque = new Parque();
        Lugar lugar = new Lugar();
        Lugar other = new Lugar();
        other.setMinutos(100);
        other.setMatricula("AA-BB-CC");
        parque.newLugar(lugar);
        parque.newLugar(other);
        parque.alteraTempo(lugar.getMatricula(),10);
        System.out.println(parque.totalMinutes());*/

        /*
        TurmaAlunos turma = new TurmaAlunos();
        Aluno aluno1 = new Aluno();
        aluno1.setNumero("0000");
        Aluno aluno2 = new Aluno();
        aluno2.setNumero("1111");
        turma.insereAluno(aluno1);
        turma.insereAluno(aluno2);
        System.out.println(turma.alunosOrdemDescrescenteNumero().toString());
         */
        /*
        SistemaVideos sistemaVideos = new SistemaVideos();
        VideoYouTube v1 = new VideoYouTube();
        v1.setVideoName("Diogo");
        v1.setLikes(10);
        v1.setMinutes(2);
        VideoYouTube v2 = new VideoYouTube();
        v2.setLikes(15);
        v2.setVideoName("Andrea");
        v2.setMinutes(1);
        v2.setDate(LocalDate.now().minusDays(2));
        sistemaVideos.addVideo(v1);
        sistemaVideos.addVideo(v2);
        System.out.println(sistemaVideos.videoMaisLongo().getVideoName());

        Grafo grafo = new Grafo();
        grafo.addArco(0,1);
        grafo.addArco(1,0);
        grafo.addArco(1,3);
        Grafo grafo1 = new Grafo();
        grafo1.addArco(0,1);
        System.out.println(grafo1.subGrafo(grafo));
         */
        FBPost post = new FBPost();
        FBPost post1 = new FBPost();
        LocalDateTime now = LocalDateTime.now();
        post1.setDate(post.getDate());
        post1.setNumberLikes(10);
        FBFeedMap fbFeedMap = new FBFeedMap();
        fbFeedMap.addPost("Diogo",post);
        fbFeedMap.addPost("Andrea",post);
        fbFeedMap.addPost("Andrea",post1);
        fbFeedMap.postsNumPeriodo(now.minusMinutes(10),now.plusMinutes(10));
        //System.out.println(fbFeedMap.utilizadorMaisActivo(now.minusMinutes(10),now.plusMinutes(10)));
        System.out.println(fbFeedMap);
        System.out.println(fbFeedMap.validaPostsSimultaneos());


    }
}
