package com.cgi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dao.RegisterDao;
import com.cgi.model.Register;

@Service
public class RegisterService {
@Autowired
RegisterDao registerDAO;
public Register saveRegister(Register reg) {
   Register register = registerDAO.findByEmailId(reg.getEmailId());
   if(register==null) {
       registerDAO.save(reg);
       return reg;
   }
   return null;
   }
public boolean validateRegister(Register reg) {
   Register register = registerDAO.findByEmailIdAndPassword(reg.getEmailId(),reg.getPassword());
   if(register != null) {
   return true;
}
 return false;
}
}

