package com.hardQuestion.arrayConcept.JPAEntityLazyLoading;/*
package concept.clear.prectise.JPAEntityLazyLoading;

import javax.persistence.*;
import java.util.List;
import java.util.LinkedHashMap;

*/
/**
 * https://vladmihalcea.com/the-best-way-to-lazy-load-entity-attributes-using-jpa-and-hibernate/
 * <li>You either use bytecode enhancement along with @Basic(fetch=FetchType.LAZY) on attributes that are to be loaded lazily:</li>
 * <br>
 * @implSpec
 * <plugin>
 *     <groupId>org.hibernate.orm.tooling</groupId>
 *     <artifactId>hibernate-enhance-maven-plugin</artifactId>
 *     <version>${hibernate.version}</version>
 *     <executions>
 *         <execution>
 *             <configuration>
 *                 <failOnError>true</failOnError>
 *                 <enableLazyInitialization>true</enableLazyInitialization>
 *             </configuration>
 *             <goals>
 *                 <goal>enhance</goal>
 *             </goals>
 *         </execution>
 *     </executions>
 * </plugin>
 *//*

@Entity
public class JPALazyLoading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
*/
