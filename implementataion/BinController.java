import java.util.ArrayList;
import java.io.Serializable;

public class BinController implements Serializable { // all of the bins of all the resident users of Bineco

	private ArrayList<Bin> bins = new ArrayList<Bin>();

	public ArrayList<Bin> getBins() { return bins; }

	public void addBin(Bin bin) { bins.add(bin); }
	public void removeBin(Bin bin) { bins.remove(bin); }

}