/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.util.Iterator;
import java.util.Objects;

/**
 * Representacao de Linha de Encomenda
 *
 * @author MaterialPOO
 * @version 20180312
 * @version 20200317
 * @version 20210323
 */

public class LinhaEncomenda {
    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;
    
    public LinhaEncomenda() {
        this.referencia = "n/a";
        this.descricao = "n/a";
        this.preco = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
    }
    
    public LinhaEncomenda(String referencia, String descricao, double preco,
                int quantidade, double imposto, double desconto) {
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }
    
    public LinhaEncomenda(LinhaEncomenda linha) {
        this.referencia = linha.getReferencia();
        this.descricao = linha.getDescricao();
        this.preco = linha.getPreco();
        this.quantidade = linha.getQuantidade();
        this.imposto = linha.getImposto();
        this.desconto = linha.getDesconto();
    }
    
    /**
     * B)
     */
    public double calculaValorLinhaEnc() {
        double valor = this.quantidade * this.preco;
        valor -= valor*this.desconto;
        valor *= 1+this.imposto;
        return valor;
    }
    
    /**
     * C)
     */
    public double calculaValorDesconto() {
        double valor = this.quantidade * this.preco;
        valor *= this.imposto; //e.g. imposto = 1.06
        return this.calculaValorLinhaEnc()-valor;
    }  
    
    public String getReferencia() {
        return this.referencia;
    }
    
     public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return Double.compare(that.getPreco(), getPreco()) == 0 && getQuantidade() == that.getQuantidade() && Double.compare(that.getImposto(), getImposto()) == 0 && Double.compare(that.getDesconto(), getDesconto()) == 0 && Objects.equals(getReferencia(), that.getReferencia()) && Objects.equals(getDescricao(), that.getDescricao());
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia: ").append(this.referencia).append('\n');
        sb.append("Descrição: ").append(this.descricao).append('\n');
        sb.append("Preço: ").append(this.preco).append('\n');
        sb.append("Quantidade: ").append(this.quantidade).append('\n');
        sb.append("Imposto: ").append(this.imposto).append('\n');
        sb.append("Desconto: ").append(this.desconto).append('\n');
        return sb.toString();
    }            


}
