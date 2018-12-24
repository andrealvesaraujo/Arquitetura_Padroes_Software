package encapsulamento;
import java.math.BigDecimal;
import java.util.Set;

public class Venda {
	Set<ItemVenda> itens;

	public BigDecimal obterTotalErrado() {
		BigDecimal total = new BigDecimal("0.0");
		for(ItemVenda item : itens) {
			Produto produto = item.getProduto();
			int qtd = item.getQuantidade();
			BigDecimal bigQtd = new BigDecimal(qtd);
			total.add(bigQtd.multiply(produto.getpreco()));
		}
		return total;
	}

	public BigDecimal obterTotalCerto() {
		BigDecimal total = new BigDecimal("0.0");
		for(ItemVenda item : itens) {
			total.add(item.obterTotal());
		}
		return total;
	}

}