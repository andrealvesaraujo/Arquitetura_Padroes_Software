package dominio;
import java.util.*;
public class ValidadorMaxCreditorService {
	private final static int maximo=20;
	
	public static boolean validar(Aluno aluno,TurmaRepositorio repo,Integer creditos) {
		if (creditos <= 0) {
			throw new IllegalArgumentException("Quantidade de créditos solicitados deve ser positiva.");
		}
		Set<Turma> turmasDoAluno = repo.getTurmasByAlunoDoPeriodo(aluno,PeriodoLetivo.PERIODO_CORRENTE);
		Integer totalCreditosSolicitados=0;
		
		for(Turma i:turmasDoAluno) {
			Disciplina d = i.getDisciplina();
			totalCreditosSolicitados+=d.getQuantidadeCreditos();
			
		}
		
		if(totalCreditosSolicitados+creditos> maximo) {
			return false;
		}
		return true;
		
		
	}
}
