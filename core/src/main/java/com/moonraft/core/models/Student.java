package com.moonraft.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.*;

@Model(adaptables = Resource.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Student {
	
	@Inject
    private String studentname;
	
	@Inject
    private List<PhoneNumbersImpl> phone;
	
	public String getStudentName() {
		return studentname;
	}
	public List<PhoneNumbersImpl> getPhone(){
		return new ArrayList<>(phone);
	}
}
