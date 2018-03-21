package com.niranjan.custom.util;

import java.util.Date;

import com.niranjan.custom.dao.HDFCDao;
import com.niranjan.custom.dto.HDFCDto;

public class SaveTestiing {

	public static void main(String[] args) {
		HDFCDto dto=new HDFCDto();
		Date d=new Date(2005, 6, 13);
		dto.setName("Bangalore");
		dto.setCreationDate(new Date());
		HDFCDao dao=new HDFCDao();
		dao.saveHDFC(dto);

	}

}
