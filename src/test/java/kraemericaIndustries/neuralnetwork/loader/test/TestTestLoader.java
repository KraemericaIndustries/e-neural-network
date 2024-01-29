package kraemericaIndustries.neuralnetwork.loader.test;

import static org.junit.Assert.*;

import org.junit.Test;

import kraemericaIndustries.neuralnetwork.loader.BatchData;
import kraemericaIndustries.neuralnetwork.loader.Loader;
import kraemericaIndustries.neuralnetwork.loader.MetaData;

public class TestTestLoader {

	@Test
	public void test() {

		int batchSize = 32;
		
		Loader testLoader = new TestLoader(60_000, batchSize);
		
		MetaData metaData = testLoader.open();
		
		for(int i = 0; i < metaData.getNumberBatches(); i++) {
			BatchData batchData = testLoader.readBatch();
			
			assertTrue(batchData != null);
			
			int itemsRead = metaData.getItemsRead();
			
			assertTrue(itemsRead == batchSize);
		}
	}
}