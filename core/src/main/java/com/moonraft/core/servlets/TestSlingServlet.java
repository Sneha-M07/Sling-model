package com.moonraft.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/pages"}
)
public class TestSlingServlet extends SlingSafeMethodsServlet{

	
	@Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        final ResourceResolver resourceResolver = req.getResourceResolver();
        String callingPage = req.getParameter("callingPage");
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
                pageObject.put("Page Title",childPage.getTitle().toString());
               // pageObject.put("Template path",childPage.getTemplate().getPath().toString());
               // pageObject.put("Template",childPage.getTemplate().getProperties().get(JcrConstants.JCR_TITLE));
                pageObject.put("Template Type",childPage.getTemplate().getProperties().get("cq:templateType", "Default template type"));
                pagesArray.put(pageObject);
               
            }
        } catch (JSONException e) {
           
        }
        resp.setContentType("application/json");
        resp.getWriter().write(pagesArray.toString());
       
    }
}
