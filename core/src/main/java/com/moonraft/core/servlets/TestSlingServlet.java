package com.moonraft.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/pages"}
)
public class TestSlingServlet extends SlingSafeMethodsServlet{
	private static final Logger LOG = LoggerFactory.getLogger(TestSlingServlet.class);
	
	@Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        final ResourceResolver resourceResolver = req.getResourceResolver();
        String callingPage = req.getParameter("callingPage");
        int pageDepth = Integer.parseInt(req.getParameter("depth"));
        if(callingPage!=null && pageDepth>=0){
        	Page page = resourceResolver.adaptTo(PageManager.class).getPage(callingPage);
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
               // pageObject.put("Parent Page",childPage.getParent().getPath());
                pageObject.put("Page Title",childPage.getTitle());
               // pageObject.put("Template path",childPage.getTemplate().getPath().toString());
               // pageObject.put("Template",childPage.getTemplate().getProperties().get(JcrConstants.JCR_TITLE));
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
