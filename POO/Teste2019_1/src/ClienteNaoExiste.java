public class ClienteNaoExiste extends Exception{
    public ClienteNaoExiste (){
        super();
    }

    public ClienteNaoExiste (String msg){
        super(msg);
    }
}
