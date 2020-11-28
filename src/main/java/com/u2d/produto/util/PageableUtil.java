package com.u2d.produto.util;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

public class PageableUtil {

	private static final String PAGE = "page";
	private static final String SIZE = "size";
	
	public static Pageable getPageableParams(Map<String, String[]> params, Direction direction, String orderBy) {
		int page = ParametroUtil.extrairParametroInteiro(params, PAGE);
		int size = ParametroUtil.extrairParametroInteiro(params, SIZE);
		return PageRequest.of(page, size, direction, orderBy);
	}
}
