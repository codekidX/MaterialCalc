/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 * */

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXSnackbar;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

public class CalculatorViewController implements Initializable {
	
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton divideButton;

    @FXML
    private JFXButton minusButton;

    @FXML
    private Label calcLabel;

    @FXML
    private JFXButton equalsButton;

    @FXML
    private JFXButton pointButton;

    @FXML
    private JFXButton oneButton;

    @FXML
    private JFXButton plusButton;

    @FXML
    private JFXButton threeButton;

    @FXML
    private JFXButton sevenButton;

    @FXML
    private JFXButton twoButton;

    @FXML
    private JFXButton eightButton;

    @FXML
    private JFXButton sixButton;

    @FXML
    private JFXButton nineButton;

    @FXML
    private JFXButton zeroButton;

    @FXML
    private JFXButton multiplyButton;

    @FXML
    private JFXButton fourButton;

    @FXML
    private JFXButton fiveButton;
    
    // --------------------------------
    // Our own calc variables
    
    String answer;
    Double firstOperand;
    Double secondOperand;
    
    String operation = null;
    
    String calcLabelText = "";
    
    JFXSnackbar snackbar;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		calcLabel.setTextAlignment(TextAlignment.RIGHT);
		
		setUpAllButtonActions();
		setUpOperationButtonActions();
		
	}
	
	private void setUpOperationButtonActions() {
		
		// delete button click
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				operation = null;
				firstOperand = 0d;
				secondOperand = 0d;
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
				
				setCalculatorLabel("0");
			}
		});
		
		// addition button click
		plusButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				operation = "+";
				firstOperand = Double.parseDouble(calcLabel.getText());
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
				
			}
		});
		
		// subtract button click
		minusButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				operation = "-";
				firstOperand = Double.parseDouble(calcLabel.getText());
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
			}
		});
		
		// divide button click
		divideButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				operation = "/";
				firstOperand = Double.parseDouble(calcLabel.getText());
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
			}
		});
		
		// multiply button click
		multiplyButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				operation = "*";
				firstOperand = Double.parseDouble(calcLabel.getText());
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
				
			}
		});
		
		
		/*
		 *  THE RESULT PROVIDER
		 * */
		
		// equals button click
		equalsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
				firstOperand = Double.parseDouble(calcLabel.getText());
				
				// clear label text too
				calcLabelText = "";
				
				// clear label
				setCalculatorLabel(" ");
				
				
				answer = performOperation();
				
				setCalculatorLabel(answer);
			}

		});
		
		
	}

	private void setCalculatorLabel(String label) {
		
		calcLabel.setText(label);
	}
	
	private String performOperation() {
		

		secondOperand = Double.parseDouble(calcLabel.getText());
		
		double answerDouble = 0;
		
		switch(operation) {
		case "+":
			answerDouble = firstOperand + secondOperand;
			return "" + answerDouble;
		case "-":
			answerDouble = firstOperand - secondOperand;
			return "" + answerDouble;
		case "/":
			answerDouble = firstOperand / secondOperand;
			return "" + answerDouble;
		case "*":
			answerDouble = firstOperand * secondOperand;
			return "" + answerDouble;
		}
		
		return "" + answerDouble;
		
		
	}
	
	
	private void setUpAllButtonActions() {
		
		// point button click
		pointButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				calcLabelText += ".";
				setCalculatorLabel(calcLabelText);
			}
		});
		
		
		
		// zero button click
		zeroButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "0";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		// one button click
		oneButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				calcLabelText += "1";
				setCalculatorLabel(calcLabelText);
			}
		});
		
		// two button click
		twoButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "2";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		
		// three button click
		threeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "3";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		// four button click
		fourButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "4";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		// five button click
		fiveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "5";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		// six button click
		sixButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "6";
				setCalculatorLabel(calcLabelText);
			}
		});
		
		// seven button click
		sevenButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "7";
				setCalculatorLabel(calcLabelText);
			}
		});
		
		// eight button click
		eightButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "8";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
		// nine button click
		nineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				calcLabelText += "9";
				setCalculatorLabel(calcLabelText);
				
			}
		});
		
	}

}
