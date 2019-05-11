/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.charlie.tomcat.web;

import com.charlie.tomcat.entity.Role;
import com.charlie.tomcat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.charlie.tomcat.service.HelloWorldService;

@Controller
@RequestMapping("/hello")
public class SampleController {

	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private RoleService roleService;

	@RequestMapping("/world")
	@ResponseBody
	public String helloWorld() {
		return this.helloWorldService.getHelloMessage();
	}

	@RequestMapping("/addRole")
	@ResponseBody
	public void addRole() {
		Role role = new Role("test");
		roleService.addRole(role);
	}

	@RequestMapping("/findRole")
	@ResponseBody
	public Role findRole(Long id){
		return roleService.findRole(id);
	}
}
