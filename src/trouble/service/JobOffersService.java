package trouble.service;

import java.sql.SQLException;
import java.util.List;

import trouble.dao.JobOffersDao;
import trouble.domain.JobOffers;
import trouble.exception.JobOffersException;

public class JobOffersService {
	
	JobOffersDao jod = new JobOffersDao();

	public List<JobOffers> findOffersByEnterId(String enter_id) throws JobOffersException {
		
		try {
			return jod.findOffersByEnterId(enter_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JobOffersException("≤È’“’–∆∏–≈œ¢ ß∞‹");
		}
	}
	
	

}
