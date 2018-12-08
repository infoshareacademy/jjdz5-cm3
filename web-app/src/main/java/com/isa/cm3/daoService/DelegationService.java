package com.isa.cm3.daoService;

import com.isa.cm3.dao.DelegationDao;
import com.isa.cm3.delegations.Delegation;
import com.isa.cm3.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/")
public class DelegationService {

    private Logger LOG = LoggerFactory.getLogger(DelegationService .class);

    @Inject
    DelegationDao delegationDao = new DelegationDao();

    @GET
    @Path("/report")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReport() {

        List<Delegation> delegations = delegationDao.findAll();

        if (!delegations.isEmpty()) {
            LOG.info("Delegations: " + delegations);
            return Response.ok(delegations).build();
        }
        LOG.warn("List of delegations is empty");
        return Response.noContent().build();
    }
}
