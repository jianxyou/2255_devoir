import java.util.ArrayList;

public class BinController { // all of the bins of all the residents of Bineco

	private ArrayList<Bin> bins = new ArrayList<Bin>();

	public ArrayList<Bin> getBins() { return bins; }

	public void addBin(Bin bin) { bins.add(bin); }
	public void removeBin(Bin bin) { bins.remove(bin); }

}