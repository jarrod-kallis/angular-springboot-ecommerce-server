# E-Commerce Server

## API Endpoints Exposed
[http://localhost:8080/api](http://localhost:8080/api)

## Disable certain REST endpoints
Search for `RepositoryRestConfigurer` in the code

## Default records returned by Spring Data REST 
<span style="color:red"><b>NB!!!</b></span> By default Spring Data REST only returns the first 20 items </br>
<span style="color:blue">How to change:</span> http://localhost:8080/api/product?<b>size=100</b>

## Should you store images on your DB

https://altronbsi.udemy.com/course/full-stack-angular-spring-boot-tutorial/learn/lecture/17516518

## JPA Repository Query Magic
The JPARepository will construct queries based on the method name that you choose.</br>
eg. findBy, readyBy, queryBy, etc...</br>

`findByCategoryId(@RequestParam('id') Long id);`</br>
Generates this query: `SELECT * FROM product where category_id = ?`</br>

You can write your own queries if you don't like the idea of "MAGIC" queries:</br>
`@Query("select c from Course c where name like '%50%'")`</br>
`public List<Course> courseWithNameLike50();`</br></br>
[Query Method section in Spring Data Reference Manual](http://www.luv2code.com/spring-data-query-methods)

Spring Data REST automatically exposes endpoints for query methods: `/search/findByCategoryId`</br>

## Lombok is a bitch

1. Download Lombok JAR <br/>
[https://projectlombok.org/downloads/lombok.jar](https://projectlombok.org/downloads/lombok.jar)

2. Run `java -jar lombok.jar`

3. Select the Eclipse installation - nothing else to do

## Spring Data Rest provides support for Pagination out of the box
