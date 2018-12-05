package com.isa.cm3.daoService;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.dao.DestinationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class DestinationService {

    private Logger LOG = LoggerFactory.getLogger(DestinationService .class);

    @Inject
    DestinationDao destonationDao = new DestinationDao();
}
