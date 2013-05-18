package com.xel.gui;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.google.gdata.util.ServiceException;
import com.sun.media.jfxmedia.events.PlayerEvent;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class XController {

   	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
	    @FXML
	    private MenuItem btn_Local_Misc_Add_CM1;

	    @FXML
	    private MenuItem btn_Local_Misc_Add_CM2;

	    @FXML
	    private HBox Controls_Youtube;

	    @FXML
		protected Slider Slider_Local_Seek;

	    @FXML
	    private Slider Slider_Local_Volume;

	    @FXML
	    private VBox VBox_Local;

	    @FXML
	    private VBox VBox_Youtube;

	    @FXML
	    private Button btn_Local_Controls_First;

	    @FXML
	    private Button btn_Local_Controls_Last;

	    @FXML
	    private Button btn_Local_Controls_Next;

	    @FXML
	    private Button btn_Local_Controls_Pause;

	    @FXML
	    private Button btn_Local_Controls_Play;

	    @FXML
	    private Button btn_Local_Controls_Previous;

	    @FXML
	    private Button btn_Local_Controls_Stop;

	    @FXML
	    private Button btn_Local_Misc_Add;

	    @FXML
	    private Button btn_Local_Misc_Equal;

	    @FXML
	    private Button btn_Local_Misc_Remove;

	    @FXML
	    private Button btn_Local_Misc_SaveLoad;

	    @FXML
	    private Button btn_Youtube_Search;

	    @FXML
	    private Button btn_Youtube_Watch;

	    @FXML
		protected Label lbl_Local_Nowplaying;

	    @FXML
	    private Label lbl_Local_Time;

	    @FXML
		protected ListView<String> listview_Local;

	    @FXML
	    private ListView<String> listview_Youtube;

	    @FXML
	    private ToggleGroup sourceGroup;

	    @FXML
	    private ToggleButton tbLocal;

	    @FXML
	    private ToggleButton tbSpotify;

	    @FXML
	    private ToggleButton tbStream;

	    @FXML
	    private ToggleButton tbTwitch;

	    @FXML
	    private ToggleButton tbYoutube;

	    @FXML
	    private ToggleButton tb_Local_Misc_Loop;

	    @FXML 
	    protected ToggleButton tb_Local_Misc_Repeat;

	    @FXML
	    private ToggleButton tb_Local_Misc_Shuffle;

	    @FXML
	    private TextField textfield_Youtube;

	    @FXML
	    private AnchorPane videoPaneAnchor;

	    @FXML
	    private TitledPane videoPaneTitle;

	    @FXML
	    private WebView videoWebview;


	    @FXML
	    void LocalMouseClick(MouseEvent event) {
	    	LocalMouseClick(event, 0);
	    }

	    @FXML
	    void YoutubeMouseClick(MouseEvent event) {
	    	YoutubeMouseClick(event, 0);
	    }

	    @FXML
	    void YoutubeSearch(ActionEvent event) {
	    	YoutubeSearch(event, 0);
	    }

	    @FXML
	    void YoutubeWatch(ActionEvent event) {
	    	YoutubeWatch(event, 0);
	    }

	    @FXML
	    void btnLocalControls(ActionEvent event) {
	    	btnLocalControls(event, 0);
	    }

	    @FXML
	    void btnLocalMisc(ActionEvent event) {
	    	btnLocalMisc(event, 0);
	    }
	    
	    @FXML
	    void btnLocalMiscCM(ActionEvent event) {
	    	btnLocalMiscCM(event, 0);
	    }

	    @FXML
	    void tbLocalMisc(ActionEvent event) {
	    	tbLocalMisc(event, 0);
	    }
	    
	    @FXML
	    void Volume_Slider_MouseDrag(MouseEvent event) {
	    	Volume_Slider_MouseDrag(event, 0);
	    }

	    @FXML
	    void Volume_Slider_MouseReleased(MouseEvent event) {
	    	Volume_Slider_MouseReleased(event, 0);
	    }
	    
	    @FXML
	    void Slider_Local_Seek_MouseDrag(MouseEvent event) {
	    	Slider_Local_Seek_MouseDrag(event, 0);
	    }
	    
	    @FXML
	    void sourceAction(ActionEvent event) {
	    	sourceAction(event, 0);
	    }

	    @FXML
	    void initialize() {
	        assert Controls_Youtube != null : "fx:id=\"Controls_Youtube\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert Slider_Local_Seek != null : "fx:id=\"Slider_Local_Seek\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert Slider_Local_Volume != null : "fx:id=\"Slider_Local_Volume\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert VBox_Local != null : "fx:id=\"VBox_Local\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert VBox_Youtube != null : "fx:id=\"VBox_Youtube\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_First != null : "fx:id=\"btn_Local_Controls_First\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Last != null : "fx:id=\"btn_Local_Controls_Last\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Next != null : "fx:id=\"btn_Local_Controls_Next\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Pause != null : "fx:id=\"btn_Local_Controls_Pause\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Play != null : "fx:id=\"btn_Local_Controls_Play\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Previous != null : "fx:id=\"btn_Local_Controls_Previous\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Controls_Stop != null : "fx:id=\"btn_Local_Controls_Stop\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Misc_Add != null : "fx:id=\"btn_Local_Misc_Add\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Misc_Equal != null : "fx:id=\"btn_Local_Misc_Equal\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Misc_Remove != null : "fx:id=\"btn_Local_Misc_Remove\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Local_Misc_SaveLoad != null : "fx:id=\"btn_Local_Misc_SaveLoad\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Youtube_Search != null : "fx:id=\"btn_Youtube_Search\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert btn_Youtube_Watch != null : "fx:id=\"btn_Youtube_Watch\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert lbl_Local_Nowplaying != null : "fx:id=\"lbl_Local_Nowplaying\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert lbl_Local_Time != null : "fx:id=\"lbl_Local_Time\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert listview_Local != null : "fx:id=\"listview_Local\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert listview_Youtube != null : "fx:id=\"listview_Youtube\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert sourceGroup != null : "fx:id=\"sourceGroup\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tbLocal != null : "fx:id=\"tbLocal\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tbSpotify != null : "fx:id=\"tbSpotify\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tbStream != null : "fx:id=\"tbStream\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tbTwitch != null : "fx:id=\"tbTwitch\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tbYoutube != null : "fx:id=\"tbYoutube\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tb_Local_Misc_Loop != null : "fx:id=\"tb_Local_Misc_Loop\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tb_Local_Misc_Repeat != null : "fx:id=\"tb_Local_Misc_Repeat\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert tb_Local_Misc_Shuffle != null : "fx:id=\"tb_Local_Misc_Shuffle\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert textfield_Youtube != null : "fx:id=\"textfield_Youtube\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert videoPaneAnchor != null : "fx:id=\"videoPaneAnchor\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert videoPaneTitle != null : "fx:id=\"videoPaneTitle\" was not injected: check your FXML file 'FXML.fxml'.";
	        assert videoWebview != null : "fx:id=\"videoWebview\" was not injected: check your FXML file 'FXML.fxml'.";

	        xy = new XYoutube();
	        
	        view = new MediaView();
	    	videoPaneAnchor.getChildren().add(view);
	    }
    
	    MediaView view;
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void sourceAction(ActionEvent event, int i){
    	if(event.getSource() == tbLocal){
    		VBox_Youtube.visibleProperty().set(false);
    		VBox_Local.visibleProperty().set(true);
    	}else if(event.getSource() == tbYoutube){
    		VBox_Youtube.visibleProperty().set(true);
    		VBox_Local.visibleProperty().set(false);
    	}
    }
    
    
    
    
    
    
    
    
    /***YOUTUBE ----------------->***/
    private Map<String, String> youtubeLinks = new HashMap<String, String>();

    XYoutube xy;
    
    void YoutubeSearch(ActionEvent event, int i) {
    	String searchTerm = textfield_Youtube.getText();
    	try {
    		listview_Youtube.getItems().clear();
    		youtubeLinks = xy.SearchVideos(searchTerm);
    		for(Map.Entry<String, String> kp : youtubeLinks.entrySet()){
    			listview_Youtube.getItems().add(kp.getKey());
    		}
		} catch (IOException | ServiceException e) {
			e.printStackTrace();
		}
    }
    
    void YoutubeMouseClick(MouseEvent event, int i){
    	if(event.getClickCount() >= 2 && listview_Youtube.getSelectionModel().getSelectedItem() != "" && listview_Youtube.getSelectionModel().getSelectedItem() != null){
    		WebEngine engine = videoWebview.getEngine();    	
    		String id = youtubeLinks.get(listview_Youtube.getSelectionModel().getSelectedItem());
    		String link = "http://www.youtube.com/embed/" + id;  
    		String embed = "<div style=\"float: left; margin: -8px\">";
    		embed += "<iframe width=\"189\" height=\"181\" src=\"";
    		embed += link;
    		embed += "\" frameborder=\"0\" allowfullscreen></iframe></div>";
    		engine.loadContent(embed);
    	}
    }
    
    void YoutubeWatch(ActionEvent event, int i) {}
    /***<----------------- YOUTUBE***/
    
    /***LOCAL FILES ----------------->***/
    private static FileChooser.ExtensionFilter ef1 = new FileChooser.ExtensionFilter("Supported Files", "*.mp3", "*.wav", "*.mp4");
    private static FileChooser.ExtensionFilter ef2 = new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav");
    private static FileChooser.ExtensionFilter ef3 = new FileChooser.ExtensionFilter("MP3 Files", "*.mp3");
    private static FileChooser.ExtensionFilter ef4 = new FileChooser.ExtensionFilter("WAV Files", "*.wav");
    private static FileChooser.ExtensionFilter ef5 = new FileChooser.ExtensionFilter("Video Files", "*.mp4");
    private static FileChooser.ExtensionFilter ef6 = new FileChooser.ExtensionFilter("All Files", "*.*");
    private Map<String, String> SongMap = new HashMap<String, String>();
    private int CurrentSongIndex = 0;
    private List<MediaPlayer> Players = new ArrayList<MediaPlayer>();
    private MediaPlayer CurrentPlayer;
    private double Volume = 0.5;
    
    void LocalMouseClick(MouseEvent event, int i){
    	if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() >= 2)
    		PlaySong(false);
    }
    
    
    
    void btnLocalControls(ActionEvent event, int i) {
    	if(event.getSource() == btn_Local_Controls_First){
    		CurrentSongIndex = 0;
    		PlaySong(true);
    	}else if(event.getSource() == btn_Local_Controls_Previous){
    		CurrentSongIndex--;
    		if(CurrentSongIndex < 0)
    			CurrentSongIndex = Players.size() - 1;
    		PlaySong(true);
    	}else if(event.getSource() == btn_Local_Controls_Play){
    		if(CurrentPlayer != null && CurrentPlayer.getStatus() == MediaPlayer.Status.PAUSED)
    			CurrentPlayer.play();
    		else{
    		CurrentSongIndex = listview_Local.getSelectionModel().getSelectedIndex();
    		PlaySong(true);
    		}
    	}else if(event.getSource() == btn_Local_Controls_Pause)
    		PauseSong();
    	else if(event.getSource() == btn_Local_Controls_Stop)
    		StopSong();
    	else if(event.getSource() == btn_Local_Controls_Next){
    		CurrentSongIndex++;
    		if(CurrentSongIndex > Players.size() - 1)
    			CurrentSongIndex = 0;
    		PlaySong(true);
    	}else if(event.getSource() == btn_Local_Controls_Last){
    		CurrentSongIndex = Players.size() - 1;
    		PlaySong(true);
    	}
    }
    
    void btnLocalMisc(ActionEvent event, int i) {
    	if(event.getSource() == btn_Local_Misc_Add)
    		AddSongs(false);
    	if(event.getSource() == btn_Local_Misc_Remove)
    		RemoveSongs(false);
    }
    
    void btnLocalMiscCM(ActionEvent event, int i){
    	if(event.getSource() == btn_Local_Misc_Add_CM1)
    		AddSongs(false);
    	if(event.getSource() == btn_Local_Misc_Add_CM2)
    		AddSongs(true);
    	
    }
    
    void tbLocalMisc(ActionEvent event, int i){}

    
    private MediaPlayer SongMP(String path){
    	MediaPlayer mp = new MediaPlayer(new Media(new File(path).toURI().toASCIIString()));
    	mp.currentTimeProperty().addListener(new InvalidationListener(){
    		public void invalidated(Observable ov){
    			MPThread();
    		}
    	});
    	mp.setOnEndOfMedia(new Runnable(){
    		@Override
    		public void run(){
    			if(tb_Local_Misc_Repeat.isSelected()){
    				PlaySong(true);
    			}
    			if(tb_Local_Misc_Shuffle.isSelected() && !tb_Local_Misc_Repeat.isSelected()){
    				Random r = new Random();
    				CurrentSongIndex = r.nextInt(Players.size() - 1);
    				PlaySong(true);
    			}else if(!tb_Local_Misc_Repeat.isSelected()){
    			CurrentSongIndex++;
    			if(CurrentSongIndex > Players.size() - 1 && tb_Local_Misc_Loop.isSelected())
    				CurrentSongIndex = 0;
    			
    			if(CurrentSongIndex < Players.size())
    				PlaySong(true);
    			}
    		}
    	});
    	return mp;
    }
    
    public void AddSongs(boolean b){
    	if(!b){
    		FileChooser fc = new FileChooser();
    		fc.setTitle("Select file(s) to add");
    		fc.getExtensionFilters().addAll(ef1, ef2, ef3, ef4, ef5, ef6);
    		
    		List<File> files = fc.showOpenMultipleDialog(null);
    		
    		if(files != null){
    			for(File f : files){
    				SongMap.put(f.getName(), f.getAbsolutePath());
    				Players.add(SongMP(f.getAbsolutePath()));
    				listview_Local.getItems().add((f.getName()));
    			}
    		}
    	}else{
    		DirectoryChooser dc = new DirectoryChooser();
    		dc.setTitle("Choose folder");
    		File temp = dc.showDialog(null);
    		if(temp != null){
    			for(String s : temp.list(new FilenameFilter(){
    				@Override
    				public boolean accept(File dir, String name){
    					return name.endsWith(".mp3") || name.endsWith(".wav") || name.endsWith(".mp4");
    				}
    			})){
    				String absolute = temp + "\\" + s;
    				SongMap.put(s, absolute);
    				Players.add(SongMP(absolute));
    				listview_Local.getItems().add(s);
    			}
    		}
    	}
    }

    public void RemoveSongs(boolean clear){
    	if(!clear){
    		int index = listview_Local.getSelectionModel().getSelectedIndex();
    		Players.remove(index);
    		SongMap.remove(listview_Local.getItems().get(index).toString());
    		listview_Local.getItems().remove(index);
    	}else{
    		Players.clear();
    		SongMap.clear();
    		listview_Local.getItems().clear();
    	}
    }
    
    public void PlaySong(boolean MediaEnd){
    	if(!MediaEnd){
    		if(CurrentPlayer != null)
    			CurrentPlayer.stop();
    		
    		CurrentSongIndex = listview_Local.getSelectionModel().getSelectedIndex();
    		CurrentPlayer = Players.get(CurrentSongIndex);
    	}else{
    		if(CurrentPlayer != null)
    			CurrentPlayer.stop();
    		
    		CurrentPlayer = Players.get(CurrentSongIndex);
    		listview_Local.getSelectionModel().select(CurrentSongIndex);
    	}
    	
    	if(CurrentPlayer != null){
    		Slider_Local_Seek.setMax(CurrentPlayer.getTotalDuration().toSeconds());
    		CurrentPlayer.setVolume(Volume);
    		CurrentPlayer.play();
    		lbl_Local_Nowplaying.setText(listview_Local.getItems().get(CurrentSongIndex).toString());
    		if(CurrentPlayer.getMedia().getSource().endsWith(".mp4"))
    			PlayVideo();
    	}
    }
    
    private void PlayVideo(){
    	videoWebview.setVisible(false);
		view.setVisible(true);
		view.setMediaPlayer(CurrentPlayer);
		view.setFitHeight(videoPaneAnchor.getHeight());
		view.setFitWidth(videoPaneAnchor.getWidth());
		view.preserveRatioProperty().set(false);
    }
    
    private void PauseSong(){
    	if(CurrentPlayer != null)
    		CurrentPlayer.pause();
    }
    
    private void StopSong(){
    	if(CurrentPlayer != null)
    		CurrentPlayer.stop();
    }
    
    void MPThread(){
    	Platform.runLater(new Runnable(){
    		@Override
    		public void run(){
    			Long sec = Math.round(CurrentPlayer.getTotalDuration().toSeconds() - CurrentPlayer.getCurrentTime().toSeconds());
    			Long min = TimeUnit.SECONDS.toMinutes(sec);
    			Long seco = TimeUnit.SECONDS.toSeconds(sec) - (TimeUnit.SECONDS.toMinutes(sec) * 60);
    			final String sMinute = Long.toString(min);
    			final String sSecond = Long.toString(seco);
    			try{
    				if(sSecond.length() < 2)
    					lbl_Local_Time.setText(sMinute + ":0" + sSecond);
    				else
    					lbl_Local_Time.setText(sMinute + ":" + sSecond);
    				
    				Slider_Local_Seek.setValue(CurrentPlayer.getCurrentTime().toSeconds());
    				
    			}catch(Exception ee){}
    		}
    	});
    }
    
    
    private void Volume_Slider_MouseDrag(MouseEvent event, Integer i){
    	long vol = Math.round(Slider_Local_Volume.valueProperty().getValue().doubleValue());
    	lbl_Local_Nowplaying.setText("Volume: " + vol + "%");
    	Volume = vol;
    	Volume /= 100;
    	if(CurrentPlayer != null)
    		CurrentPlayer.setVolume(Volume);
    	
    	
    	//view.mediaPlayerProperty().set(CurrentPlayer);

    }
    
    private void Volume_Slider_MouseReleased(MouseEvent event, Integer i){
    	lbl_Local_Nowplaying.setText(listview_Local.getItems().get(CurrentSongIndex).toString());
    }
    
    private void Slider_Local_Seek_MouseDrag(MouseEvent event, Integer i){
    	//Seek(new Duration(SeekSlider.getValue() * 1000)); }});
    	if(CurrentPlayer != null)
    		CurrentPlayer.seek(new Duration(Slider_Local_Seek.getValue() * 1000));
    }
    
    /***<----------------- LOCAL FILES***/
    
}
    
    
