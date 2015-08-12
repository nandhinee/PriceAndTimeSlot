package user.com;

import java.sql.Timestamp;

public class collectionsFramework {

	public boolean get() {
		 boolean state = false;
	     if(Timestamp.valueOf("2013-06-27 23:36:08.394").before(new Timestamp(System.currentTimeMillis()))) {

		 }
		 else {
			 state = true;
		 }
		 return state;
	}
}
