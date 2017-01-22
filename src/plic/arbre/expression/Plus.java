package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder SB = new StringBuilder();
		SB.append(this.gauche.toMIPS());
		SB.append("sw $v0, ($sp)\n");
		SB.append("addi $sp, $sp, -4\n");
		SB.append(this.droite.toMIPS());
		SB.append("addi $sp, $sp, 4\n");
		SB.append("lw $t8, ($sp)\n");
		SB.append("add $v0, $t8, $v0\n");	
		return SB.toString();
	}
}
