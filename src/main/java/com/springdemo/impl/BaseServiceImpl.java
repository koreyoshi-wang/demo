/**
 * 
 */
package com.springdemo.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.service.BaseService;

@Transactional
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
}
