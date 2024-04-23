package app;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import EJB.calc;
@Path("cal")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Applicationservice {
	@EJB 
	calc calc;
	@PersistenceContext(unitName="hello")
	private EntityManager entitymanger;
	@Path("calc")
	@POST
	
	public String createcalc(calc calc) {
		int num1=calc.getNumber1();
		int num2=calc.getNumber2();
		String op=calc.getOperation();
		int r=calc.dooperation(num1, num2, op);
		calc.setResult(r);
		entitymanger.persist(calc);
		return "result : "+ r;
		}
	 @GET
	 @Path("calculations")
	    public List<calc> getAllCalculations() {
	        TypedQuery<calc> query = entitymanger.createQuery("select c from calc c", calc.class);
	        List<calc> calculations = query.getResultList();
	        return calculations;
	    }
}
//	@GET
//	 @Path("test")
//	 public String test() {
//		return "test from calc ";
//	}
//	}

//path to second method
	



