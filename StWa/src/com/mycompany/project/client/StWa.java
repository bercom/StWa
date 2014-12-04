/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.mycompany.project.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StWa implements EntryPoint {
	private VerticalPanel mainPanel;
	private FlexTable stocksFlexTable;
	private HorizontalPanel addPanel;
	private TextBox newSymbolTextBox;
	private Button addButton;
	private Label lastUpdatedLabel;

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		mainPanel = new VerticalPanel();
		rootPanel.add(mainPanel, 10, 10);
		mainPanel.setSize("261px", "280px");

		stocksFlexTable = new FlexTable();
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");
		mainPanel.add(stocksFlexTable);

		addPanel = new HorizontalPanel();
		mainPanel.add(addPanel);
		addPanel.setSize("244px", "126px");

		newSymbolTextBox = new TextBox();
		newSymbolTextBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					addStock();
				}
			}
		});
		newSymbolTextBox.setFocus(true);
		addPanel.add(newSymbolTextBox);
		newSymbolTextBox.setWidth("134px");

		addButton = new Button("New button");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addStock();
			}
		});
		addButton.setText("Add");
		addPanel.add(addButton);

		lastUpdatedLabel = new Label("New label");
		mainPanel.add(lastUpdatedLabel);
	}

	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();

		newSymbolTextBox.setFocus(true);

		// Stock code must be between 1 and 10 chars that are numbers, letters,
		// or dots.
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			newSymbolTextBox.selectAll();
			return;
		}

		newSymbolTextBox.setText("");

		// TODO Don't add the stock if it's already in the table.
		// TODO Add the stock to the table.
		// TODO Add a button to remove this stock from the table.
		// TODO Get the stock price.}
	}
}