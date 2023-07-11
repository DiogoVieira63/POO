package Aluno_Turma;

import javax.net.ssl.TrustManagerFactorySpi;
import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {
    private Map<String,Aluno> turma;
    private String name;
    private String codigoUC;

    public TurmaAlunos (){
        this.turma = new HashMap<String,Aluno>();
        this.name = "n/a";
        this.codigoUC ="n/a";
    }

    public TurmaAlunos(Map<String, Aluno> turma, String name, String codigoUC) {
        this.turma = turma;
        this.name = name;
        this.codigoUC = codigoUC;
    }
    public TurmaAlunos (TurmaAlunos turma){
        this.turma = turma.getTurma();
        this.name = turma.getName();
        this.codigoUC = turma.getCodigoUC();
    }




    public Map<String, Aluno> getTurma() {
        return turma;
    }

    public void setTurma(Map<String, Aluno> turma) {
        this.turma = turma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodigoUC() {
        return codigoUC;
    }

    public void setCodigoUC(String codigoUC) {
        this.codigoUC = codigoUC;
    }

    @Override
    public String toString() {
        return "TurmaAlunos{" +
                "turma=" + turma +
                ", name='" + name + '\'' +
                ", codigoUC='" + codigoUC + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaAlunos that = (TurmaAlunos) o;
        return Objects.equals(getTurma(), that.getTurma()) && getName().equals(that.getName()) && getCodigoUC().equals(that.getCodigoUC());
    }

    public TurmaAlunos clone (){
        return new TurmaAlunos(this);
    }

    public int compareTo (TurmaAlunos turma){
        return this.name.compareTo(turma.getName());
    }

    public void insereAluno(Aluno a){
        turma.put(a.getNumero(),a);
    }

    public Aluno getAluno(String codAluno){
        return turma.get(codAluno);
    }

    public void removeAluno(String codAluno){
        turma.remove(codAluno);
    }

    public Set<String> todosOsCodigos(){
        return turma.keySet();
    }

    public int qtsAlunos(){
        return turma.size();
    }

    public Collection<Aluno> alunosOrdemAlfabetica(){
        return turma.values().stream().
                sorted(Aluno::compareTo).
                collect(Collectors.toList());
    }

    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        return (Set<Aluno>) turma.keySet().stream().
                sorted(Comparator.reverseOrder()).
                map(s -> turma.get(s)).
                collect(Collectors.toUnmodifiableSet());
    }

















}
