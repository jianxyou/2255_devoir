import java.util.ArrayList;
import java.io.Serializable;
/**
 * BinController permet la gestion des bacs elle remplit une liste de instance de bac
 * @author admin
 *
 */
public class BinController implements Serializable { // all of the bins of all the resident users of Bineco
	
	private ArrayList<Bin> bins = new ArrayList<Bin>();

	public ArrayList<Bin> getBins() { return bins; }
	/**
	 * ajouter une instance bin a la liste des bacs
	 * @param bin bac a poubelle
	 */
	public void addBin(Bin bin) { bins.add(bin); }
	/**
	 * retirer une instance bin de la liste des bacs
	 * @param bin bac a poubelle
	 */
	public void removeBin(Bin bin) { bins.remove(bin); }

}