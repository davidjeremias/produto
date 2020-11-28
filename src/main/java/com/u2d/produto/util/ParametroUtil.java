package com.u2d.produto.util;

import java.util.Map;

public class ParametroUtil {

	public static String extrairParametro(Map<String, String[]> params, String nomeParametro) {
		return params.get(nomeParametro) != null ? params.get(nomeParametro)[0] : null;
	}
	
	public static Integer extrairParametroInteiro(Map<String, String[]> params, String nomeParametro) {
		return params.get(nomeParametro) != null ? Integer.parseInt(params.get(nomeParametro)[0])  : null;
	}
	
	public static String[] extrairParametros(Map<String, String[]> params, String nomeParametro) {
		return params.get(nomeParametro) != null ? params.get(nomeParametro) : null;
	}
}
