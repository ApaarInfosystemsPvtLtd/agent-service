package com.pmli.lifeasia.translator.model;

import com.pmli.lifeasia.translator.initialize.MasterStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ModelInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    MasterStore masterStore;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        masterStore.initialize();
    }
}
