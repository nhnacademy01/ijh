package com.nhnacademy.cookie;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = "/WEB-INF/classes/" + servletContext.getInitParameter("counterFileName");

        Integer counter = null;
        try(DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFileName))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }

        int count = Optional.ofNullable(counter).orElse(0);
        servletContext.setAttribute("counter", count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        int counter = (int) servletContext.getAttribute("counter");
        String counterFileName = servletContext.getInitParameter("counterFileName");

        try (OutputStream os = Files.newOutputStream(Paths.get(servletContext.getResource(counterFileName).toURI()));
             DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeInt(counter);
        } catch (IOException | URISyntaxException e) {
            log.error("", e);
        }
    }
}
