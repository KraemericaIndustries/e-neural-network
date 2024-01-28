package kraemericaIndustries.neuralnetwork.loader;

public interface Loader {

	MetaData open();
	void close();
	
	MetaData getMetaData();
	BatchData readBatch();
}