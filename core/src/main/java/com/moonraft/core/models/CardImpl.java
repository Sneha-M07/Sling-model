package com.moonraft.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,
        adapters=Card.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardImpl implements Card{
	
	@Inject
	private String cardtitle;
	
	@Inject
	private String cardheading;
	
   @Override
   public String getCardTitle(){
	   return cardtitle;
   }
   
   @Override
   public String getCardHeading(){
	   return cardheading;
   }
}
