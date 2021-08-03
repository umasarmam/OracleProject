package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/* 
 * 
 * This is the main class which is used to read the input data
 * Process the data as per the requirement
 * Print the results
 * 
 */
public class MainClass {

	public static void main(String[] args) {

		// read input
		List<CustomerDetails> customers = readData();

		// process data
		getContractBasedCustomerCount(customers);
		getZoneBasedCustomerCount(customers);
		getAverageBuildDruation(customers);
		getZoneBasedCustomers(customers);
	}

	/*
	 * this method is used to read the given data and set it to customer objects
	 */
	public static List<CustomerDetails> readData() {
		List<CustomerDetails> customers = new ArrayList<CustomerDetails>();

		try {
			List<String> input = new ArrayList<String>();
			System.out.println("Enter input string : ");
			Scanner scanner = new Scanner(System.in);

			while (scanner.hasNextLine()) { 
				String line = scanner.nextLine();
				if(line == null || line.isEmpty()){ //if the line is empty exit the loop
					break;  
				}
				input.add(line);

				String[] data = ProjectUtils.getArrayOfStrings(line);
				if (data != null && data.length == 6) {
					CustomerDetails customer = new CustomerDetails();
					customer.setCustomerId(data[0]);
					customer.setContractId(data[1]);
					customer.setGeoZone(data[2]);
					customer.setTeamCode(data[3]);
					customer.setProjectCode(data[4]);
					if(data[5] != null && data[5].length() > 0)
					customer.setBuildDuration(Integer.parseInt(data[5].substring(0, data[5].length()-1)));

					customers.add(customer);
				}
			}

			scanner.close();
		} catch (Exception e) {
			System.out.println("Exception occured inside MainClass.readData method");
		}
		

		return customers;
	}

	/*
	 * this method is used to get - The number of unique customerId for each contractId
	 */
	public static Map<String, Long> getContractBasedCustomerCount(List<CustomerDetails> customers) {
		Map<String, Long> result = null;
		try {
			if (customers != null && customers.size() > 0) {
				result = customers.stream().collect(
						Collectors.groupingBy(CustomerDetails::getContractId,
								Collectors.mapping(CustomerDetails::getCustomerId, Collectors.counting())));

				System.out.println("The number of unique customerId for each contractId : ");
				System.out.println(result.toString());
			}
		} catch (Exception e) {
			System.out.println("Exception occured inside MainClass.getContractBasedCustomerCount method");
		}
		return result;
	}

	/*
	 * this method is used to get - The number of unique customerId for each geozone
	 */
	public static Map<String, Long> getZoneBasedCustomerCount(List<CustomerDetails> customers) {
		Map<String, Long> result = null;
		try {
			if (customers != null && customers.size() > 0) {
				result = customers.stream().collect(
						Collectors.groupingBy(CustomerDetails::getGeoZone,
								Collectors.mapping(CustomerDetails::getCustomerId, Collectors.counting())));

				System.out.println("The number of unique customerId for each geozone : ");
				System.out.println(result.toString());
			}
		} catch (Exception e) {
			System.out.println("Exception occured inside MainClass.getZoneBasedCustomerCount method");
		}
		return result;
	}
	
	
	/*
	 * this method is used to get - The average buildduration for each geozone.
	 */
	public static Map<String, Double> getAverageBuildDruation(List<CustomerDetails> customers) {
		Map<String, Double> result = null;
		try {
			if (customers != null && customers.size() > 0) {
				result= customers.stream()
						.collect(Collectors.groupingBy(CustomerDetails::getGeoZone,
								Collectors.averagingInt(CustomerDetails::getBuildDuration)));
				
				System.out.println("The average buildduration for each geozone : ");
				System.out.println(result.toString());
			}
		} catch (Exception e) {
			System.out.println("Exception occured inside MainClass.getAverageBuildDruation method");
		}
		return result;
	}

	/*
	 * this method is used to get - The list of unique customerId for each geozone.
	 */
	public static Map<String, Set<String>> getZoneBasedCustomers(List<CustomerDetails> customers) {
		Map<String, Set<String>> result = null;
		try {
			if (customers != null && customers.size() > 0) {
				result = customers.stream().collect(
						Collectors.groupingBy(CustomerDetails::getGeoZone,
								Collectors.mapping(CustomerDetails::getCustomerId, Collectors.toSet())));

				System.out.println("The list of unique customerId for each geozone : ");
				System.out.println(result.toString());
			}
		} catch (Exception e) {
			System.out.println("Exception occured inside MainClass.getZoneBasedCustomers method");
		}
		return result;
	}

}

