package br.com.colaboradores.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

/**
 * Classe utilitária da aplicação
 *
 */
public class Utils {

	/**
	 * Método responsável por calcular percentual através de um valor.
	 * @param Total
	 * @param Quantidade a ser calculada o percentual
	 * @return Percentual do valor passado no segundo parâmetro.
	 */
	public static BigDecimal calcularPercentualPeloValor(BigDecimal total, BigDecimal valor) {
		return valor.divide(total, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
	}
	
	/**
	 * Método responsável por formatar o CPF.
	 * @param CPF
	 * @return CPF formatado
	 */
	public static String formatarCpf(String cpf) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(cpf);
		} catch(ParseException e) {
			return cpf;
		}
	}
	
}
