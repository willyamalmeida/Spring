/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.*;
import model.Produto;
import org.springframework.stereotype.Component;

/**
 *
 * @author Willyam
 */
@Component
public class CarrinhoBean {
    private List<ProdutoEscolhidoBean> produtosEscolhidos = new ArrayList<ProdutoEscolhidoBean>();
    private Produto produto;
    
    public List<ProdutoEscolhidoBean> getProdutosEscolhidos(){
        return produtosEscolhidos;
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
        
    public boolean isVazio(){
        return produtosEscolhidos.isEmpty();
    }
    
    public double getTotalDosProdutos(){
        double total = 0;
        
        for(ProdutoEscolhidoBean produtoEscolhido : this.produtosEscolhidos){
            total += produtoEscolhido.getSubTotal();
        }
        
        return total;
    }
    
    public int getItens(Produto produto){
        int quantidade = 0;
        
        for (ProdutoEscolhidoBean produtoEscolhido : this.produtosEscolhidos) {
            if (produtoEscolhido.getProduto().getCodigo() == produto.getCodigo()) {
                quantidade += produtoEscolhido.getQuantidade();
            }
        }
                        
        return quantidade;
    }
    
    public void addProduto(){
        for (ProdutoEscolhidoBean produtoEscolhido : this.produtosEscolhidos) {
            if (produtoEscolhido.getProduto().getCodigo() == this.produto.getCodigo()) {
                produtoEscolhido.add();
                return;
            }
        }
        
        Produto novoProduto = new Produto();
        novoProduto.setCodigo(this.produto.getCodigo());
        novoProduto.setDescricao(this.produto.getDescricao().trim());
        novoProduto.setNome(this.produto.getNome().trim());
        novoProduto.setPreco(this.produto.getPreco());
        
        ProdutoEscolhidoBean novoProdutoEscolhido = new ProdutoEscolhidoBean();
        novoProdutoEscolhido.setProduto(novoProduto);
        novoProdutoEscolhido.setQuantidade(1);
        
        this.produtosEscolhidos.add(novoProdutoEscolhido);
    }
    
    public void remProduto(){               
        for (int i = 0; i < this.produtosEscolhidos.size(); i++) {
            ProdutoEscolhidoBean produtoEscolhido = this.produtosEscolhidos.get(i);
            
            if(produtoEscolhido.getProduto().getCodigo() == this.produto.getCodigo()){
                produtoEscolhido.rem();
                
                if (produtoEscolhido.getQuantidade() <= 0) {
                    this.produtosEscolhidos.remove(i);
                    break;
                }
            }            
        }
    }
}
