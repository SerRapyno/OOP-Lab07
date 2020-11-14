package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	private List<T> list;

	public OneListAcceptable(List<T> list) {
		super();
		this.list = list;
	}

    public Acceptor<T> acceptor() {
        final Iterator<T> it = list.iterator();
        return new Acceptor<T>() {

            public void accept(final T value) throws Acceptor.ElementNotAcceptedException {
                try {
                	System.out.println("value: " + value);
                    if (value.equals(it.next())) {
                    	System.out.println("accepted");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("no more element to be evaluated");
                }
                
                throw new Acceptor.ElementNotAcceptedException(value);
            }

            public void end() throws Acceptor.EndNotAcceptedException {
            	System.out.println("is sequence ended?");
                try {
                    if (!it.hasNext()) {
                        return;
                    }
                } catch (Exception e) {             
                }
                System.out.println("sequence is not ended");
                throw new Acceptor.EndNotAcceptedException();
            }
        };
    }
}

