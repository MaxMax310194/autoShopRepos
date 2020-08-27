package daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import dao.daoAuto;
import model.Auto;
;



@Repository
@Transactional
public class DaoImplAuto implements daoAuto {

	Session session = null;
	Transaction transaction = null;
	List<Auto>autos = new ArrayList<>();
	
	SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}
	public DaoImplAuto(SessionFactory sf) {
		super();
		this.sf = sf;
	}



	@Override
	public List<Auto> getAllAuto() {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Auto>query=criteriaBuilder.createQuery(Auto.class);
		Root<Auto>root=query.from(Auto.class);
		query.select(root);
		Query<Auto>resQuery=session.createQuery(query);
		autos.clear();
		autos=resQuery.getResultList();
		transaction.commit();
		return autos;
	}

	@Override
	public void addAuto(Auto auto) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.save(auto);
		transaction.commit();
		session.close();

	}

	@Override
	public void delAuto(Auto auto) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.delete(auto);
		transaction.commit();
		session.close();

	}

	@Override
	public void updateAuto(Auto auto) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.update(auto);
		transaction.commit();
		session.close();

	}

	@Override
	public Auto getUserByName(String nameAuto) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Auto>query=criteriaBuilder.createQuery(Auto.class);
		Root<Auto>root=query.from(Auto.class);
		query.select(root).where(criteriaBuilder.equal(root.get("nameAuto"), nameAuto));
		Query<Auto>resQuery=session.createQuery(query);
		autos.clear();
		autos=resQuery.getResultList();
		transaction.commit();
		if (autos.size()!=0) {
			return autos.get(0);
		}else {
			return null;
		}
	}

	

}
