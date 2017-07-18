/**
 * 
 */
package com.springdemo.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.service.BaseService;

@Transactional
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
}
