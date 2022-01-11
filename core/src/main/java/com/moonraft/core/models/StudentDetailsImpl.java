package com.moonraft.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.*;

@Model(adaptables = Resource.class,
       adapters=StudentDetails.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class StudentDetailsImpl implements StudentDetails{
	
	 @Inject
	 Resource componentResource;
	 
	 @Inject
	 public List<Student> studentdetailswithmap;
	 
	 public List<Student> getStudentDetailsWithMap(){
		 
		return new ArrayList<Student>(studentdetailswithmap);
		
	 }
	 
}
