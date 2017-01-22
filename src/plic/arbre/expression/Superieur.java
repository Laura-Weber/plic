package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
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
		SB.append("ble $t8, $v0, sinonLigne" + this.noLigne + "\n");	
		SB.append("li $v0, 1\n");
		SB.append("b finSiLigne" + this.noLigne + "\n");
		SB.append("sinonLigne" + this.noLigne + ": li $v0, 0\n");
		SB.append("finSiLigne" + this.noLigne + ": ");
		return SB.toString();
	}
}
