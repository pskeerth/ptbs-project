package visitors;

import facade.Reminder;
import facade.Product;
import facade.Facade;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	public void visitProduct(Product product) {

	}

	@Override
	public void visitorProduct(Product product) {

	}

	@Override
	public void visitTrading(Trading trading) {

	}

	public void visitorFacade(Facade facade) {

	}

}
