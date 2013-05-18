package com.xel.gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.util.ServiceException;

public class XYoutube {

  YouTubeService service;
	YouTubeQuery query;
	
	public XYoutube(){
		service = new YouTubeService("XMedia");
		try {
			query = new YouTubeQuery(new URL("http://gdata.youtube.com/feeds/api/videos"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		query.setOrderBy(YouTubeQuery.OrderBy.RELEVANCE);
		query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
	}
	
	public HashMap<String, String> SearchVideos(String searchTerm) throws IOException, ServiceException{
		HashMap<String, String> temp = new HashMap<String, String>();
		query.setFullTextQuery(searchTerm);
		VideoFeed feed = service.query(query, VideoFeed.class);
		for(VideoEntry v : feed.getEntries()){
			temp.put(v.getTitle().getPlainText(), v.getId().substring(v.getId().indexOf("video:") + 6));
		}
		return temp;
	}
	
}
