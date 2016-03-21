package com.galaxyguide.metals;

import java.util.ArrayList;
/*
 * This class is the container of metals, holding information for the metals
 */
public class MetalsRepository {
	public static class Metal {
		private final String metalName;
		private final double unitPrice;
		
		public Metal(String metalName, double unitMetalPrice) {
			this.metalName = metalName;
			this.unitPrice = unitMetalPrice;
		}

		public Metal(String metalName) {
			this.metalName = metalName;
			this.unitPrice = 0;
		}
		
		public String getMetalName() {
			return metalName;
		}
		
		public double getUnitPrice() {
			return unitPrice;
		}

		public int getTotalPriceForUnits(int units) {
			return (int) (units*unitPrice);
		}
		
		public boolean equals(Object object) {
			if (object instanceof Metal &&
					((Metal)object).metalName.equals(this.metalName)) {
				return true;
			}
			return false;
		}		
	}
	
	private static ArrayList<Metal> metals = new ArrayList<MetalsRepository.Metal>();
	
	/*
	 * Add new metal to the repository
	 */
	public static void addMetal(Metal metal) throws Exception {
		if(metals.contains(metal)) {
			throw new Exception("Metal " + metal.getMetalName() + " is already present.");
		}
		metals.add(metal);
	}
	
	public static Metal findMetal(Metal metalToSearch) throws Exception {
		for (Metal metal : metals) {
			if(metal.equals(metalToSearch)) {
				return metal;
			}
		}
		throw new Exception("Metal " + metalToSearch.getMetalName() + " not found.");
	}
}
