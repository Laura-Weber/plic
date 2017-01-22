package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toMIPS() {
		int result = 0;
		if (this.cste.compareTo("vrai") == 0) {
			result = 1;
		}
		return "li $v0, " + result + "\n";
	}
}
