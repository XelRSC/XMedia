package com.xel.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class XGui extends AnchorPane{
  
	public XGui(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
			loader.setController(new XController());
			Parent root = (Parent)loader.load();
			this.getChildren().add(root);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
}
