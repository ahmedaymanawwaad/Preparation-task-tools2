package EJB;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Stateless
public class calc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private int number1;
	private int number2;
    private String operation;
    private int result;
    
	public calc(int number1, int number2, String operation) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}
//	public calc(int number1, int number2, String operation, int result) {
//		this.number1 = number1;
//		this.number2 = number2;
//		this.operation = operation;
//		this.result = result;
//	}
	public calc() {
	}

    public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int dooperation(int num1, int num2, String op) {
		int r;
	    switch (op) {
	        case "+":
	            r= num1 + num2;
	            break;
	        case "-":
	            r = num1 - num2;
	            break;
	        case "*":
	            r= num1 * num2;
	            break;
	        case "/":
	            if (num2 != 0) {
	                r= num1 / num2;
	                break;
	            } else {
	                throw new ArithmeticException("Cannot divide by zero");
	            }
	        default:
	            throw new IllegalArgumentException("Invalid operation: " + op);
	    }
	    return r;
	}

}
