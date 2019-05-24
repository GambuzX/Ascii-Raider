package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Controller;
import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.View;

public interface State {
	Model getStateModel();
	View getStateView();
	Controller getStateController();
}
