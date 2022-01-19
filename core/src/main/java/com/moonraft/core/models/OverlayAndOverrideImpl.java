package com.moonraft.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,
        adapters=OverlayAndOverride.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OverlayAndOverrideImpl implements OverlayAndOverride{
   @Inject
   String title1;
   
   @Inject
   @Named("jcr:title")
   String title2;
   
   @Override
   public String getTitle1() {
	   return title1;
   }
   
   @Override
   public String getTitle2() {
	   return title2;
   }
   
}
