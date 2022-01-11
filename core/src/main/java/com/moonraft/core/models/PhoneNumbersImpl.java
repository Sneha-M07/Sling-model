package com.moonraft.core.models;

import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

@Model( adaptables = Resource.class, 
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PhoneNumbersImpl{
	
	@Inject
    public String phonenumber;
}
