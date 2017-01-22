package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder SB = new StringBuilder();
		SB.append(this.expression.toMIPS());
		SB.append("li $t8, 0\n");
		SB.append("nor $v0, $t8, $v0\n");
		return SB.toString();
	}
}
