package visual.util.forDBAction;


public interface DBActionButton {
	public void selectPrev();
	public void selectNext();
	public void selectFirst();
	public void selectLast();
	
	public Object getSelected();
}
