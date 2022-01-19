package com.moonraft.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.servlets.HttpConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        methods = HttpConstants.METHOD_GET,
        resourceTypes = "audi/components/page"
)
public class TestResourceTypesServlet extends SlingSafeMethodsServlet{
private static final Logger LOG = LoggerFactory.getLogger(TestSlingServlet.class);
	
	@Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
		final Resource resource = req.getResource();
		final ResourceResolver resourceResolver = req.getResourceResolver();
		Page page = resourceResolver.adaptTo(PageManager.class).getContainingPage(resource);
        int pageDepth = Integer.parseInt(req.getParameter("depth"));
        if(pageDepth>=0){
            JSONArray pagesArray = new JSONArray();
        try {
           JSONObject pageObject1 = new JSONObject();
    	   pageObject1.put("Parent Page Title",page.getTitle().toString());
    	   pageObject1.put("Parent Page Template Type",page.getTemplate().getProperties().get("cq:templateType", "Default template type"));
    	   pagesArray.put(pageObject1);
            Iterator<Page> childPages = page.listChildren(null, true);
            while (childPages.hasNext()) {
            	Page childPage = childPages.next();
                JSONObject pageObject = new JSONObject();
            	if(childPage.getDepth()<=page.getDepth()+pageDepth) {
                pageObject.put("Page Title",childPage.getTitle());
                pageObject.put("Template Type",childPage.getTemplate().getProperties().get("cq:templateType", "Default template type"));
                pagesArray.put(pageObject);
            	}
            }
            resp.setContentType("application/json");
            resp.getWriter().write(pagesArray.toString());
        } catch (Exception e) {
        	resp.setContentType("text/plain");
            resp.getWriter().write("Please give correct page path");
        	LOG.info("\n ERROR {} ", e.getMessage());
          }   
       }
        else {
        	resp.setContentType("text/plain");
            resp.getWriter().write("No page path is given");
        }
    }
}
