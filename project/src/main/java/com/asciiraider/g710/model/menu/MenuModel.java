package com.asciiraider.g710.model.menu;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class MenuModel extends Model {
	private List<Button> options;
	private int selected;

	public MenuModel(){
		options = new ArrayList<>();
		options.add(new Button("PLAY", new Position(5, 3), new Position(13, 6), new HexColorString("6dc750"), new HexColorString("0")));
		options.add(new Button("EXIT", new Position(5, 7), new Position(13, 10), new HexColorString("b52225"), new HexColorString("0")));
		options.get(0).setActive(true);
		selected = 0;
	}

	public void addOption(Button newButton){
		options.add(newButton);
	}

	public List<Button> getOptions(){
		return this.options;
	}

	public int getNumberOptions(){
		return this.options.size();
	}

	public int getSelected() {
		return selected % options.size();
	}

	public Button getSelectedButton() {
		return this.options.get(getSelected());
	}

	public void nextOption() {
		getSelectedButton().setActive(false);
		selected++;
		getSelectedButton().setActive(true);
	}

	public void previousOption(){
		getSelectedButton().setActive(false);
		selected--;
		if(selected < 0)
			selected = options.size() - 1;
		getSelectedButton().setActive(true);
	}

}
