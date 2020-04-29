
package statistics.matcher;


public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder all() {
        matcher = new And(matcher, new All());
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matcher = new Not(matcher);
        return this;
    }
    
    public QueryBuilder or(Matcher first, Matcher second) {
        matcher = new Or(first, second);
        return this;
    }
    
    public Matcher build() {
        Matcher queryResult = matcher;
        
        //Resetoidaan matcher uusia kyselyja varten
        matcher = new All();
        
        return queryResult;
    }
    
}
