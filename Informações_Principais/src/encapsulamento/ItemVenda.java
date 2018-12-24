package encapsulamento;
import java.math.BigDecimal;

public class ItemVenda {
	
		Integer quantidade;
		Produto produto;

		public Produto getProduto() {
			return produto;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public BigDecimal obterTotal() {
			Produto produto = getProduto();
			int qtd = getQuantidade();
			BigDecimal bigQtd = new BigDecimal(qtd);
			return bigQtd.multiply(produto.getpreco());
			
		}
	

}
