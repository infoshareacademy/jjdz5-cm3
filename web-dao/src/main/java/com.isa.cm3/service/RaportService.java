package com.isa.cm3.service;

import com.isa.cm3.model.RaportStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class RaportService {

    private Logger LOG = LoggerFactory.getLogger(RaportService.class);

    public RaportService() {

    }

    @Inject
    private RaportStore raportStore;
}
