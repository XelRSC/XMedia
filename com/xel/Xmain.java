package com.xel;

import java.util.EnumSet;

import javafx.scene.Node;

import com.rsbuddy.api.gui.Location;
import com.rsbuddy.plugin.WidgetPluginBase;
import com.xel.gui.XGui;

public class XMain extends WidgetPluginBase{

//  private static String title = "XMedia", up = "UP.png", hover = "HOVER.png", down = "DOWN.png";
	private static double version = 0.1;
	
	private Location _defaultLocation;
	
	
	//public XMain(){
	//	super(title + " v" + version, up, hover, down);
	//}
	
	@Override
	public void init(){
		_defaultLocation = Location.RIGHT;
	}
	
	@Override
	public void dispose(){
		
	}
	
	@Override public EnumSet<Location> supportedLocations(){
		return EnumSet.of(_defaultLocation);
	}
	
	@Override
	public Node content(Location loc) {
		return new XGui();
	}

}
