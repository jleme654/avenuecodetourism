/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avenuecode.business;

import com.mycompany.avenuecode.dto.Continent;
import java.util.List;

/**
 *
 * @author Julio Leme
 */
public interface ContinetRemote {
    
    public Continent save(Continent c) throws Exception;
    public void remove(Long id);
    public Continent consultById(Long id);
    public List<Continent> getAllContinents();
}
