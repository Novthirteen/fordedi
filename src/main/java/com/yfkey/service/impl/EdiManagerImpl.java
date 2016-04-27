package com.yfkey.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.internal.util.collections.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yfkey.dao.UserDao;
import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.ScheduleBody;
import com.yfkey.model.ScheduleView;
import com.yfkey.model.User;
import com.yfkey.model.UserPasswordLog;
import com.yfkey.model.UserPermission;
import com.yfkey.model.UserRole;
import com.yfkey.service.EdiManager;
import com.yfkey.service.UniversalManager;
import com.yfkey.service.UserManager;

/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("ediManager")
public class EdiManagerImpl extends GenericManagerImpl<User, String>implements EdiManager {
	@Autowired
	private UniversalManager universalManager;

	@SuppressWarnings("deprecation")
	public InputStream exportEdiDetails(ScheduleView scheduleView, List<String> headTitleList) {
		

		HSSFWorkbook wb = new HSSFWorkbook();

		

		HSSFSheet sheet = wb.createSheet();

	
		HSSFRow row = sheet.createRow(0);

		List<Map<String, Object>> headList = scheduleView.getScheduleHead().getHeadList();

		int t = 0;
		for (String headTitle : headTitleList) {
			HSSFCell cell = row.createCell(t);
			cell.setCellValue(headTitle);
			t++;
		}
		
		for (Map<String, Object> head : headList) {
			HSSFCell cell = row.createCell(t);
			cell.setCellValue(head.get("dateFrom").toString());
			t++;
		}

		for (int i = 1; i < scheduleView.getScheduleBodyList().size() + 1; i++) {
			ScheduleBody scheduleBody = (ScheduleBody) scheduleView.getScheduleBodyList().get(i - 1);
			;

			if ((i + 1) % 2 == 0) {

				row = sheet.createRow(i);

		
				HSSFCell cell = row.createCell(0);
				cell.setCellValue(scheduleBody.getReleaseDate());

				cell = row.createCell(1);
				cell.setCellValue(scheduleBody.getPart());

				cell = row.createCell(2);
				cell.setCellValue(scheduleBody.getPartDescription());

				cell = row.createCell(3);
				cell.setCellValue(scheduleBody.getFord_part());

				cell = row.createCell(4);
				cell.setCellValue(scheduleBody.getUm());

			
				for (int j = 0; j < scheduleBody.getPlanQtyList().size(); j++) {
					cell = row.createCell(j + 5);
					BigDecimal planQty = scheduleBody.getPlanQtyList().get(j);
					cell.setCellValue(planQty.toString());
				}

			} else {
				row = sheet.createRow(i);

				
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("");

				cell = row.createCell(1);
				cell.setCellValue("");

				cell = row.createCell(2);
				cell.setCellValue("");

				cell = row.createCell(3);
				cell.setCellValue("");

				cell = row.createCell(4);
				cell.setCellValue("");

				
				for (int j = 0; j < scheduleBody.getTotalQtyList().size(); j++) {
					cell = row.createCell(j + 5);
					BigDecimal totalQty = scheduleBody.getTotalQtyList().get(j);
					cell.setCellValue(totalQty.toString());
				}

			}
		}



		StringBuffer sb = new StringBuffer("EdiDetail");

		final File file = new File(sb.append(".xls").toString());

		try {

			OutputStream os = new FileOutputStream(file);

			try {

				wb.write(os);

				os.close();

			} catch (IOException e) {

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		InputStream is = null;

		try {

			is = new FileInputStream(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		return is;

	}

}
