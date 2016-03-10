/**
 * @author Rajashekar Dec 6, 2015
 */
package com.lookup.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lookup.webapp.dao.PlaceDAO;
import com.lookup.webapp.model.Place;

public class PlaceService implements IPlaceService {

	/* (non-Javadoc)
	 * @see com.lookup.webapp.services.IPlaceService#getListOfPlace()
	 */
	@Autowired
	private PlaceDAO placeDao;
	
	public List<Place> getListOfPlace() {

		return getPlaceDao().getList();
	}

	/* (non-Javadoc)
	 * @see com.lookup.webapp.services.IPlaceService#getCount()
	 */
	@Override
	public Long getCount() {
		return placeDao.getCount();
	}
	
	public PlaceDAO getPlaceDao() {
		return placeDao;
	}

	public void setPlaceDao(PlaceDAO placeDao) {
		this.placeDao = placeDao;
	}

	/* (non-Javadoc)
	 * @see com.lookup.webapp.services.IPlaceService#search(java.lang.String)
	 */
	@Override
	public List<Place> search(String searchString) {
		return placeDao.search("%"+searchString+"%");
	}

}
