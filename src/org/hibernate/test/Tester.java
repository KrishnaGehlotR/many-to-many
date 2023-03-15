package org.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dao.MobileDAO;
import org.hibernate.dto.ApplicationDTO;
import org.hibernate.dto.MobileDTO;

public class Tester {
	public static void main(String[] args) {
		List<MobileDTO> listOfMobiles = new ArrayList<MobileDTO>();
		List<ApplicationDTO> listOfApplications = new ArrayList<ApplicationDTO>();
		
		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setAppName("Gmail");
		applicationDTO.setType("Utilities");
		applicationDTO.setVersion(1.2);
		
		ApplicationDTO applicationDTO1 = new ApplicationDTO();
		applicationDTO1.setAppName("Whatsapp");
		applicationDTO1.setType("Social Networking");
		applicationDTO1.setVersion(4.2);
		
		MobileDTO mobileDTO = new MobileDTO();
		mobileDTO.setBrand("Apple");
		mobileDTO.setModel("X");
		mobileDTO.setPrice(100000.5);

		
		listOfMobiles.add(mobileDTO);
		listOfApplications.add(applicationDTO);
		listOfApplications.add(applicationDTO1);
		
		mobileDTO.setApplicationDTOs(listOfApplications);
		applicationDTO.setMobileDTOs(listOfMobiles);
		applicationDTO1.setMobileDTOs(listOfMobiles);
		
		MobileDAO mobileDAO = new MobileDAO();
		mobileDAO.saveMobile(mobileDTO);
	}

}
