package org.example.adminrole.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.example.database_connection.DatabaseConnection;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Map;

@Component(immediate = true,name="database")
public class RestService {

    private Server server;

    /**
     * Used to activate.
     */
    @Activate
    public void activate(Map<String,String> properties) {
        DatabaseConnection.databaseConnection(properties);
        try {

            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/chat");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new ApiService());
            server = bean.create();
         } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Used to activate.
     * @throws Exception
     */
    @Deactivate
    public void deactivate() throws Exception {
        if (server != null) {
            server.destroy();
        }
    }
}
