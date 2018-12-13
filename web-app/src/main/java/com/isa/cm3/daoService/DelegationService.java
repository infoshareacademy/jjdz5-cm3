package com.isa.cm3.daoService;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.delegations.Delegation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class DelegationService {

    private Logger LOG = LoggerFactory.getLogger(DelegationService .class);

    @Inject
    DelegationDao delegationDao = new DelegationDao();

    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Delegation> getReport() {

        List<Delegation> delegations = delegationDao.findAll();
            LOG.info("Delegations: " + delegations);
            return delegations;
    }
}
