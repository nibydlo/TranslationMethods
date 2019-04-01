import java.util.HashMap;
import java.io.InputStream;
import java.text.ParseException;

public class ArithmeticMemoryParser {

	ArithmeticMemoryLexer lex;

	OtherTree other(HashMap<String,Integer> hm) throws ParseException {
		switch (lex.getCurToken().getTokenName()) {
			case "NAME":
				AssignVarTree t0_0 = assignVar(hm);
				Tree t0_1 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				OtherTree t0_2 = other(hm);
				OtherTree res0 = new OtherTree("other", hm, t0_0, t0_1, t0_2);
				return res0;
			case "eof":
				Tree epsTerm = new Tree("eps");
				return new OtherTree("other", hm, epsTerm);
			default:
				throw new AssertionError();
		}
	}

	MultTree mult(HashMap<String,Integer> hm) throws ParseException {
		PowerTree t0_0 = power(hm);
		EndofmultTree t0_1 = endofmult(hm);
		MultTree res0 = new MultTree("mult", hm, t0_0, t0_1);
			
		res0.val = t0_0.val * t0_1.val;
		
		return res0;
	}

	EndofpowTree endofpow(HashMap<String,Integer> hm) throws ParseException {
		switch (lex.getCurToken().getTokenName()) {
			case "POW":
				Tree t0_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				AtomTree t0_1 = atom(hm);
				EndofpowTree t0_2 = endofpow(hm);
				EndofpowTree res0 = new EndofpowTree("endofpow", hm, t0_0, t0_1, t0_2);
				
				res0.val = (int) Math.pow(t0_1.val, t0_2.val);
				
				return res0;
			case "PLUS":
			case "NL":
			case "RBRACE":
			case "MINUS":
			case "MULT":
				Tree epsTerm = new Tree("eps");
				return new EndofpowTree("endofpow", hm, epsTerm);
			default:
				throw new AssertionError();
		}
	}

	AssignVarTree assignVar(HashMap<String,Integer> hm) throws ParseException {
		Tree t0_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
		Tree t0_1 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
		ExpTree t0_2 = exp(hm);
		AssignVarTree res0 = new AssignVarTree("assignVar", hm, t0_0, t0_1, t0_2);
			
		System.out.println(t0_0.getText() + " = " +  t0_2.val) ;
		 hm.put(t0_0.getText(), t0_2.val);
		
		return res0;
	}

	StartTree start() throws ParseException {
		
		HashMap<String, Integer> hm = new HashMap();
		
		AssignVarTree t0_0 = assignVar(hm);
		Tree t0_1 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
		OtherTree t0_2 = other(hm);
		StartTree res0 = new StartTree("start", t0_0, t0_1, t0_2);
			
		res0.hm = hm;
		
		return res0;
	}

	EndofmultTree endofmult(HashMap<String,Integer> hm) throws ParseException {
		switch (lex.getCurToken().getTokenName()) {
			case "MULT":
				Tree t0_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				PowerTree t0_1 = power(hm);
				EndofmultTree t0_2 = endofmult(hm);
				EndofmultTree res0 = new EndofmultTree("endofmult", hm, t0_0, t0_1, t0_2);
				
				res0.val = t0_1.val * t0_2.val;
				
				return res0;
			case "PLUS":
			case "NL":
			case "RBRACE":
			case "MINUS":
				Tree epsTerm = new Tree("eps");
				return new EndofmultTree("endofmult", hm, epsTerm);
			default:
				throw new AssertionError();
		}
	}

	PowerTree power(HashMap<String,Integer> hm) throws ParseException {
		AtomTree t0_0 = atom(hm);
		EndofpowTree t0_1 = endofpow(hm);
		PowerTree res0 = new PowerTree("power", hm, t0_0, t0_1);
			
		res0.val = (int) Math.pow(t0_0.val, t0_1.val);
		
		return res0;
	}

	ExpTree exp(HashMap<String,Integer> hm) throws ParseException {
		MultTree t0_0 = mult(hm);
		EndofexpTree t0_1 = endofexp(hm);
		ExpTree res0 = new ExpTree("exp", hm, t0_0, t0_1);
			
		res0.val = t0_0.val + t0_1.val;
		
		return res0;
	}

	AtomTree atom(HashMap<String,Integer> hm) throws ParseException {
		switch (lex.getCurToken().getTokenName()) {
			case "LBRACE":
				Tree t0_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				ExpTree t0_1 = exp(hm);
				Tree t0_2 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				AtomTree res0 = new AtomTree("atom", hm, t0_0, t0_1, t0_2);
				
				res0.val = t0_1.val;
				
				return res0;
			case "MINUS":
				Tree t1_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				AtomTree t1_1 = atom(hm);
				AtomTree res1 = new AtomTree("atom", hm, t1_0, t1_1);
				
				res1.val = -1 * t1_1.val;
				
				return res1;
			case "NUM":
				Tree t2_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				AtomTree res2 = new AtomTree("atom", hm, t2_0);
				
				res2.val = Integer.parseInt(t2_0.getText());
				;
				
				return res2;
			case "NAME":
				Tree t3_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				AtomTree res3 = new AtomTree("atom", hm, t3_0);
				
				res3.val = hm.get(t3_0.getText());
				
				return res3;
			default:
				throw new AssertionError();
		}
	}

	EndofexpTree endofexp(HashMap<String,Integer> hm) throws ParseException {
		switch (lex.getCurToken().getTokenName()) {
			case "PLUS":
				Tree t0_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				MultTree t0_1 = mult(hm);
				EndofexpTree t0_2 = endofexp(hm);
				EndofexpTree res0 = new EndofexpTree("endofexp", hm, t0_0, t0_1, t0_2);
				
				res0.val = t0_1.val + t0_2.val;
				
				return res0;
			case "MINUS":
				Tree t1_0 = new Tree(lex.getCurToken().toString());
				lex.nextToken();
				MultTree t1_1 = mult(hm);
				EndofexpTree t1_2 = endofexp(hm);
				EndofexpTree res1 = new EndofexpTree("endofexp", hm, t1_0, t1_1, t1_2);
				
				res1.val = -1 * t1_1.val + t1_2.val;
				
				return res1;
			case "NL":
			case "RBRACE":
				Tree epsTerm = new Tree("eps");
				return new EndofexpTree("endofexp", hm, epsTerm);
			default:
				throw new AssertionError();
		}
	}

	Tree parse(InputStream is, String inputString) throws ParseException {
		lex = new ArithmeticMemoryLexer(is, inputString);
		lex.nextToken();
		Tree ans = start();
		if (!lex.getCurToken().getTokenName().equals("eof")) {
			throw new AssertionError();
		}
		return ans;
	}
}
