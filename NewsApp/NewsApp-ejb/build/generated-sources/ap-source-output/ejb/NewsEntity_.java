package ejb;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-10T00:48:44")
@StaticMetamodel(NewsEntity.class)
public class NewsEntity_ { 

    public static volatile SingularAttribute<NewsEntity, Long> id;
    public static volatile SingularAttribute<NewsEntity, String> body;
    public static volatile SingularAttribute<NewsEntity, String> title;

}