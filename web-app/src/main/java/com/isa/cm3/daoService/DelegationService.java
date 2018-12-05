package com.isa.cm3.daoService;

import com.isa.cm3.dao.DelegationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class DelegationService {

    private Logger LOG = LoggerFactory.getLogger(DelegationService .class);

    @Inject
    DelegationDao delegationDao = new DelegationDao();

}
