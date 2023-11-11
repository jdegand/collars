# Collars

This is based off this article from [JPA Buddy](https://jpa-buddy.com/blog/the-ultimate-guide-on-composite-ids-in-jpa-entities/) and [Spring PetClinic](https://github.com/spring-projects/spring-petclinic).

## Thoughts

- For H2 Database: need to have a test.db file in your main directory
- The [article](https://jpa-buddy.com/blog/the-ultimate-guide-on-composite-ids-in-jpa-entities) doesn't provide a source code example.  A lot of shortcuts are taken in the article and you have to fill in the gaps.  The article devolved into another article showing the differences between EmbeddedId and IdClass.
- I had some issues (Could not determine recommended JdbcType for `com.example.collars.Pet` error) because I swapped between EmbeddedId and IdClass implementations.  It is best to follow to completion using only one implementation.           
- The JPA Buddy article prefers EmbeddedId over IdClass.  This [Baeldung article](https://www.baeldung.com/jpa-composite-primary-keys) makes a lot of good points for IdClass.  In most of my research of composite keys, EmbeddedId is preferred to IdClass but there are use cases for both.   
- IdClass requires code repetition but sql queries are simpler with IdClass.  With embeddedId, you have to use nested queries in the sql.  Getting values from the embedded class' fields may require chaining methods. 
- The JPA buddy article uses Pet (not pet.id) as part of the composite key.  Need to investiate more if this is a good idea or not.  It does allow you to query Pet fields.  Otherwise, you can use @MapsId to get the values duplicated in the Collar entity. 
- The PetClinic repo uses the Query annotation for its Repo methods. 
- It is probably best practice not to mix and match and use Query for some methods and use a service for others.
- With composite keys, the query method may actually be less complex than using a service and having to rely on url parameters.  
- I used EmbeddedId in this implementation.  
- I decided to remove a lot of the Pet Clinic implementation to just focus on the Composite key implementation.
- I dumbed down the Pet entity to not use a PetType.  Type now just takes a string.   
- Looking at the Spring PetClinic app, there is no id field in Pet entity itself as it is inherited from BaseEntity. 
- I have looked at many examples of Composite key implementations and I haven't really found any repos that have a  complete CRUD.  So my implementation here is not as complete as I would like since I haven't got much to compare and contrast.  I believe you would add both ids to the url and create a CollarId with both ids.  Then you could perform a getByCompositeKey method with the new CollarId you created.  Then you could update the returned object's fields and re-save the entity.  
- CRUD could dependent on some design choices i.e. how and where (frontend/backend) you transform the form data. 
- The JPA buddy article glossed over the OneToOne association and whether the relationship should go in the Pet or Collar entity.  This [article](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/) shows how performance can be affected by the wrong placement.
- To test the app, I thought about using CommandLineRunner on the main method or even using entityManager main method.  
- Ultimately, I added a DBInitializer since I have controller classes and then anyone could query the api to retrieve all seeded values. 
  
## Continued Development

- File Structure
- CORS
- Full CRUD / Frontend

## Useful Resources

- [Baeldung](https://www.baeldung.com/jpa-composite-primary-keys) - jpa composite primary keys
- [Hello Koding](https://hellokoding.com/jpa-hibernate-composite-primary-key-entity-mapping-example-with-mysql/) - jpa hibernate composite primary key entity mapping example with mysql
- [YouTube](https://www.youtube.com/watch?v=kRNuCOPjNU4) - Spring Boot JPA ManyToMany
- [Blog](https://attacomsian.com/blog/spring-data-jpa-composite-primary-key) - spring data jpa composite primary key
- [Amitph](https://www.amitph.com/spring-data-jpa-embeddedid/) - spring data jpa embeddedId
- [Java Code Geeks](https://examples.javacodegeeks.com/spring-boot-composite-key-example/) - spring boot composite key example
- [Spring Docs](https://docs.spring.io/spring-data/cassandra/docs/1.0.2.RELEASE/reference/htmlsingle/) - Spring Data Cassandra - Reference Documentation
- [YouTube](https://www.youtube.com/watch?v=8ygcEvd_xn8) - Complex Mapping - Composite Foreign Keys
- [CopyProgramming](https://copyprogramming.com/howto/how-to-map-composite-key-in-crud-functionality#how-to-map-composite-key-in-crud-functionality) - how to map composite key in crud functionality
- [Vlad Mihalcea](https://vladmihalcea.com/the-best-way-to-map-a-composite-primary-key-with-jpa-and-hibernate/) - best way to map a composite primary key with jpa and hibernate
- [YouTube](https://www.youtube.com/watch?v=wIrDf0PT1Dw&list=PLGTrAf5-F1YLNgq_0TXd9Xu245dJxqJMr&index=38) - Association Mapping - One-To-One Embeddable
- [Stack Overflow](https://stackoverflow.com/questions/9923643/can-someone-please-explain-me-mapsid-in-hibernate) - can someone please explain me mapsId in hibernate
- [Vlad Mihalcea](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/) - best way to map a OneToOne relationship with jpa and hibernate
- [YouTube](https://www.youtube.com/watch?v=gISfIcLMykE) - Hibernate Tip: Map a bidirectional one-to-one association with shared composite primary key
- [YouTube](https://www.youtube.com/watch?v=GRV69QNSdVg) - The best way to map a @OneToOne relationship with JPA and Hibernate
- [Tutorials Point](https://www.tutorialspoint.com/how-to-create-date-object-in-java) - how to create date object in java