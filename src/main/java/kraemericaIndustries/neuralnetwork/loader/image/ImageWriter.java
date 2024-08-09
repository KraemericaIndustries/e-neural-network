package kraemericaIndustries.neuralnetwork.loader.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import kraemericaIndustries.neuralnetwork.loader.BatchData;

public class ImageWriter {

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
		
		new ImageWriter().run(directory);
	}
	
	public void run(String directory) {
		
		final String trainImages = String.format("%s%s%s",  directory, File.separator, "train-images-idx3-ubyte");
		final String trainLabels = String.format("%s%s%s",  directory, File.separator, "train-labels-idx1-ubyte");
		final String testImages = String.format("%s%s%s",  directory, File.separator, "t10k-images-idx3-ubyte");
		final String testLabels = String.format("%s%s%s",  directory, File.separator, "t10k-labels-idx1-ubyte");
		
		int batchSize = 900; 
		
		ImageLoader trainLoader = new ImageLoader(trainImages, trainLabels, batchSize);
		ImageLoader testLoader = new ImageLoader(testImages, testLabels, batchSize);
		
		ImageLoader loader = testLoader;
		
		ImageMetaData metaData = loader.open();
		
		int imageWidth = metaData.getWidth();
		int imageHeight = metaData.getHeight();
		
		for(int i = 0; i < metaData.getNumberBatches(); i++) {
			BatchData batchData = testLoader.readBatch();
			
			var numberImages = metaData.getItemsRead();
			
			int horizontalImages = (int)Math.sqrt(numberImages);
			
			while(numberImages % horizontalImages != 0) {
				++horizontalImages;
			}
			
			int verticalImages = numberImages / horizontalImages;
			
			int canvasWidth = horizontalImages * imageWidth;
			int canvasHeight = verticalImages * imageHeight;
			
			String montagePath = String.format("montage%d.jpg", i);
			System.out.println("Writing " + montagePath);
			
			var montage = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_BYTE_GRAY);
			
			try {
				ImageIO.write(montage, "jpg", new File(montagePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		loader.close();
	}
}