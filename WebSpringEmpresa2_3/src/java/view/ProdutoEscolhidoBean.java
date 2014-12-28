/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Produto;
import org.springframework.stereotype.Component;

/**
 *
 * @author Willyam
 */
@Component
public class ProdutoEscolhidoBean {
    private Produto produto;
    private double quantidade;
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        produto.setDescricao(produto.getDescricao().trim());
        produto.setNome(produto.getNome().trim());
        this.produto = produto;
    }
    
    public double getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }
    
    public void add(){
        this.quantidade++;
    }
    
    public void rem(){
        this.quantidade--;
    }
    
    public double getSubTotal(){
        return produto.getPreco() * quantidade;
    }
}
