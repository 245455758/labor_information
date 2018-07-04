package trouble.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import trouble.domain.JobOffers;
import trouble.utils.C3P0Util;

public class JobOffersDao {

	public List<JobOffers> findOffersByEnterId(String enter_id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (List<JobOffers>) qr.query("select * from job_offers where enterprise_id=?", new BeanListHandler<JobOffers>(JobOffers.class),enter_id);
	}

}
