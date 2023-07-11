package SistemadeSuporte;/*
  @author Diogo Vieira
 * @version 1.0
 * @use Academical Use
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class PedidodeSuporte {
    /**
     * The person who called
     */
    private String caller;
    /**
     * The time when the call was done
     */
    private LocalDateTime callTime;
    /**
     * The subject
     */
    private String subject;
    /**
     * The description
     */
    private String description;
    /**
     * The person who answer
     */
    private String collaborator;
    /**
     * The time when the Pedido was solved
     */
    private LocalDateTime timeConcluded;
    /**
     * Info about the solution of Pedido
     */
    private String info;
    /**
     * To know if Pedido is solved
     */
    private boolean solved;

    /**
     * Empty constructor
     */
    public PedidodeSuporte (){
        this.caller ="n/a";
        this.callTime = LocalDateTime.now();
        this.subject ="n/a";
        this.description ="n/a";
        this.collaborator ="n/a";
        this.timeConcluded =LocalDateTime.now();
        this.info = "n/a";
        this.solved = false;
    }

    /**
     * Constructor with parameters
     * @param caller The caller
     * @param callTime The time when the call was made
     * @param subject The subject of Pedido
     * @param description The description
     * @param collaborator The collaborator
     * @param timeConcluded The time when it was solved
     * @param info The info
     */
    public PedidodeSuporte(String caller, LocalDateTime callTime, String subject, String description, String collaborator, LocalDateTime timeConcluded, String info) {
        this.caller = caller;
        this.callTime = callTime;
        this.subject = subject;
        this.description = description;
        this.collaborator = collaborator;
        this.timeConcluded = timeConcluded;
        this.info = info;
        this.solved = false;
    }

    public PedidodeSuporte (PedidodeSuporte pedidodeSuporte){
        this.caller = pedidodeSuporte.getCaller();
        this.callTime = pedidodeSuporte.getCallTime();
        this.subject = pedidodeSuporte.getSubject();
        this.description = pedidodeSuporte.getDescription();
        this.collaborator = pedidodeSuporte.getCollaborator();
        this.timeConcluded = pedidodeSuporte.getTimeConcluded();
        this.info = pedidodeSuporte.getInfo();
        this.solved = pedidodeSuporte.isSolved();
    }

    /**
     * Get the caller
     * @return The caller
     */
    public String getCaller() {
        return caller;
    }

    /**
     * Set the caller to the parameter
     * @param caller The new caller
     */
    public void setCaller(String caller) {
        this.caller = caller;
    }

    /**
     * Get the Call Time
     * @return The CallTime
     */
    public LocalDateTime getCallTime() {
        return callTime;
    }

    /**
     * Set the CallTime to the parameter
     * @param callTime The new CallTime
     */
    public void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }

    /**
     * Get the subject
     * @return The Subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the subject to the parameter
     * @param subject The new Subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Get the description
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Description to the parameter
     * @param description The new Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get The collaborator
     * @return The collaborator
     */
    public String getCollaborator() {
        return collaborator;
    }

    /**
     * Set Collaborator to the parameter
     * @param collaborator The new collaborator
     */
    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }

    /**
     * Get the Time Concluded
     * @return The time Concluded
     */
    public LocalDateTime getTimeConcluded() {
        return timeConcluded;
    }

    /**
     * Set the timeConcluded to the parameter
     * @param timeConcluded The new timeConcluded
     */
    public void setTimeConcluded(LocalDateTime timeConcluded) {
        this.timeConcluded = timeConcluded;
    }

    /**
     * Get the Info
     * @return The info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Set the Info to the parameter
     * @param info The new info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * See if the Pedido is Solved
     * @return Solved Status
     */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Set the Solved status to the paramter
     * @param solved The new status
     */
    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    /**
     * Time (in seconds) beetween CallTime and TimeConcluded (Time to solve Pedido)
     * @return The time
     */
    public double tempoResolver (){
        return (double)ChronoUnit.SECONDS.between(getCallTime(), getTimeConcluded());
    }

    /**
     * Transform the Object into a String
     * @return The String
     */
    @Override
    public String toString() {
        return "SistemadeSuporte.PedidodeSuporte{" +
                "caller='" + caller + '\'' +
                ", callTime=" + callTime +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", receiver='" + collaborator + '\'' +
                ", timeConcluded=" + timeConcluded +
                ", info='" + info + '\'' +
                ", resolved=" + solved +
                '}';
    }

    /**
     * Clone Method
     * @return A copy of Pedido
     */
    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
    }

    /**
     * Equals method
     * @param o The object to be compared to
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidodeSuporte that = (PedidodeSuporte) o;
        return isSolved() == that.isSolved() && Objects.equals(getCaller(), that.getCaller()) && Objects.equals(getCallTime(), that.getCallTime()) && Objects.equals(getSubject(), that.getSubject()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getCollaborator(), that.getCollaborator()) && Objects.equals(getTimeConcluded(), that.getTimeConcluded()) && Objects.equals(getInfo(), that.getInfo());
    }

}
