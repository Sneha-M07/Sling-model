package com.moonraft.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = HeroImage.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroImageImpl implements HeroImage{

	@Inject
	@Via("resource")
	private String title;
	
	@Inject
	@Via("resource")
	private String fileReference;
	
	@Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;
	
	@Override
    public String getTitle() {
		System.out.println(title);
        return title;
    }
	
	@Override
    public String getUrl() {
		System.out.println(fileReference);
        return fileReference;
    }
	
	@Override
    public String getLastModifiedBy(){
        return modifiedBy;
    }
	
}
