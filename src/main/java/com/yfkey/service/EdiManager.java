package com.yfkey.service;

import java.io.InputStream;
import java.util.List;

import com.yfkey.exception.PrincipalNullException;
import com.yfkey.model.PermissionType;
import com.yfkey.model.ScheduleView;
import com.yfkey.model.User;


public interface EdiManager extends GenericManager<User, String> {
	
	
	InputStream exportEdiDetails(ScheduleView scheduleView,List<String> headTitleList);
}
