/**
 * @author Rajashekar Dec 6, 2015
 */
package com.lookup.webapp.dao;

import java.util.List;

import com.lookup.webapp.model.Place;

public interface PlaceDAO {

	/**
	 * @return
	 */
	List<Place> getList();

	/**
	 * @return
	 */
	Long getCount();

	/**
	 * @param searchString 
	 * @return
	 */
	List<Place> search(String searchString);

}
