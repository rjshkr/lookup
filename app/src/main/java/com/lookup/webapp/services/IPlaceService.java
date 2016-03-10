/**
 * @author Rajashekar Dec 6, 2015
 */
package com.lookup.webapp.services;

import java.util.List;

import com.lookup.webapp.model.Place;

public interface IPlaceService {

	public List<Place> getListOfPlace();

	/**
	 * @return
	 */
	public Long getCount();

	/**
	 * @param searchString
	 * @return
	 */
	public List<Place> search(String searchString);

}
