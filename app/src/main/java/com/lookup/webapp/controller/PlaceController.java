/**
 * @author Rajashekar Dec 5, 2015
 */
package com.lookup.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lookup.webapp.model.Place;
import com.lookup.webapp.services.IPlaceService;


@RestController()
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private IPlaceService iPlaceService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public List<Place> getListOfPlaces() {
		return iPlaceService.getListOfPlace();
	}
	@RequestMapping(value="/count", method=RequestMethod.GET)
	@ResponseBody
	public Long getTotalCountOfPlaces() {
		return iPlaceService.getCount();
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	@ResponseBody
	public List<Place> search(
			@RequestParam(value="q") String searchString) {
		return iPlaceService.search(searchString);
	}
}
