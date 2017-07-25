/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeDaoImpl implements ArtistDao {

    @Autowired
    private EntityManager entityManager;
    
 	
    @Transactional
    public Artist getArtist(String artist) {
        try {
            Query query = entityManager
                    .createQuery("select a from Artist a where a.artist = ?");
            query.setParameter(1, artist);
            return (Artist) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Transactional
    public void createArtist(User artist) {
        entityManager.persist(artist);
    }
    
   
}