package com.galaxyguide.metals;

import com.galaxyguide.metals.MetalsRepository.Metal;

import junit.framework.TestCase;

public class MetalsRepositoryTest extends TestCase {
	public void testFindMetal() throws Exception {
		Metal metal = new Metal("Gold", 10.5);
		MetalsRepository.addMetal(metal);
		assertEquals(metal, MetalsRepository.findMetal(new Metal("Gold")));
	}
}
