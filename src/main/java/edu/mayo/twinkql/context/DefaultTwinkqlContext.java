/*
 * Copyright: (c) 2004-2011 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
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
package edu.mayo.twinkql.context;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;

import edu.mayo.twinkql.model.SparqlMap;

/**
 * The Class DefaultTwinkqlContext.
 *
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public class DefaultTwinkqlContext implements TwinkqlContext {
	
	private Set<SparqlMap> sparqlMaps = new HashSet<SparqlMap>();
	
	private QueryExecutionProvider queryExecutionProvider ;
	
	/**
	 * Instantiates a new default twinkql context.
	 */
	public DefaultTwinkqlContext(){
		super();
	}
	
	/**
	 * Instantiates a new default twinkql context.
	 *
	 * @param queryExecutionProvider the query execution provider
	 * @param maps the maps
	 */
	public DefaultTwinkqlContext(QueryExecutionProvider queryExecutionProvider, SparqlMap...maps){
		this(queryExecutionProvider, new HashSet<SparqlMap>(Arrays.asList(maps)));
	}
	
	/**
	 * Instantiates a new default twinkql context.
	 *
	 * @param queryExecutionProvider the query execution provider
	 * @param maps the maps
	 */
	public DefaultTwinkqlContext(QueryExecutionProvider queryExecutionProvider, Set<SparqlMap> sparqlMaps){
		this.queryExecutionProvider = queryExecutionProvider;
		this.sparqlMaps = sparqlMaps;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.TwinkqlContext#getSparqlMap(java.lang.String, java.lang.String)
	 */
	public Set<SparqlMap> getSparqlMaps() {
		return this.sparqlMaps;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.context.TwinkqlContext#getQueryExecution(com.hp.hpl.jena.query.Query)
	 */
	public QueryExecution getQueryExecution(Query query) {
		return this.queryExecutionProvider.provideQueryExecution(query);
	}
}