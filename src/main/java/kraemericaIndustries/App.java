package kraemericaIndustries;

import java.io.File;

import kraemericaIndustries.neuralnetwork.loader.BatchData;
import kraemericaIndustries.neuralnetwork.loader.Loader;
import kraemericaIndustries.neuralnetwork.loader.MetaData;
import kraemericaIndustries.neuralnetwork.loader.image.ImageLoader;

public class App {

	public static void main(String[] args) {

		if(args.length == 0) {
			System.out.println("usage: [app] <MNIST DATA DIRECTORY>");
			return;
		}
		
		String directory = args[0];
		
		if(!new File(directory).isDirectory()) {
			System.out.println("'" + directory + "' is not a directory.");
			return;
		}
		
		final String trainImages = String.format("%s%s%s",  directory, File.separator, "train-images-idx3-ubyte");
		final String trainLabels = String.format("%s%s%s",  directory, File.separator, "train-labels-idx1-ubyte");
		final String testImages = String.format("%s%s%s",  directory, File.separator, "t10k-images-idx3-ubyte");
		final String testLabels = String.format("%s%s%s",  directory, File.separator, "t10k-labels-idx1-ubyte");
		
		Loader trainLoader = new ImageLoader(trainImages, trainLabels, 32);
		Loader testLoader = new ImageLoader(testImages, testLabels, 32);
		
		trainLoader.open();
		MetaData metaData = testLoader.open();
		
		for(int i = 0; i < metaData.getNumberBatches(); i++) {
			BatchData batchData = testLoader.readBatch();
		}
		
		trainLoader.close();
		testLoader.close();
	}
}