package com.plantssoil.common.persistence;

import java.util.List;

/**
 * Entity Query, could retrieve entity via primary<br/>
 * could query entities which could match filters if exists<br/>
 * could set start position & max result to paginate the entities<br/>
 * 
 * @param <T> Entity Type
 * @author danialdy
 * @Date 31 Oct 2024 6:57:35 pm
 */
public interface IEntityQuery<T> {
    /**
     * Filter operator enumeration
     * 
     * @author danialdy
     * @Date 31 Oct 2024 7:00:09 pm
     */
    public enum FilterOperator {
        equals, like
    }

    /**
     * Add filter to the query
     * 
     * @param attributeName the attribute to filter
     * @param operator      filter operator type
     * @param filterValue   the value to match
     * @return the same query instance
     */
    public IEntityQuery<T> filter(String attributeName, FilterOperator operator, Object filterValue);

    /**
     * Set the position of the first result to retrieve.
     * 
     * @param startPosition position of the first result, default numbered from 0
     * @return the same query instance
     * @throws IllegalArgumentException if the argument is negative
     */
    public IEntityQuery<T> firstResult(int startPosition);

    /**
     * Set the maximum number of results to retrieve.
     * 
     * @param maxResult maximum number of results to retrieve, default numbered with
     *                  20
     * @return the same query instance
     * @throws IllegalArgumentException if the argument is negative
     */
    public IEntityQuery<T> maxResults(int maxResult);

    /**
     * Retrieve the entity from persistence with the specified primaryKey.<br/>
     * Filters will be ignored if added.<br/>
     * 
     * @param primaryKey the entity primary key to be retrieved
     * @return Entity object
     */
    public T singleResult(Object primaryKey);

    /**
     * Query the FIRST entity from persistence which matches the filters
     * 
     * @return Entity object
     */
    public T singleResult();

    /**
     * Query the entities from persistence which matches the filters.<br/>
     * will only return maxResult entities from startPosition if pagination
     * information provided.<br/>
     * 
     * @return Entity objects
     */
    public List<T> resultList();
}