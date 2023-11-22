package visual.util.forDBAction;

import exception.DontExistException;
import exception.EmptyDataShowException;

public interface UpdateTabPanel{
	void update() throws EmptyDataShowException ;
	void delete() throws DontExistException;
}
