CREATE TABLE logs 
(
log_id serial PRIMARY KEY, 
user_name varchar(50), 
description text, 
log_ts timestamp with time zone NOT NULL DEFAULT current_timestamp
); 

CREATE INDEX idx_logs_log_ts ON logs USING btree (log_ts);

상속된 테이블

CREATE TABLE logs_2011 (PRIMARY KEY (log_id)) INHERITS (logs);
CREATE INDEX idx_logs_2011_log_ts ON logs_2011 USING btree(log_ts);
ALTER TABLE logs_2011
    ADD CONSTRAINT chk_y2011
    CHECK (
        log_ts >= '2011-1-1'::timestamptz AND log_ts < '2012-1-1'::timestamptz
    ); 

```
​ 	​CREATE​ ​TABLE​ countries (
​ 	  country_code ​char​(2) ​PRIMARY​ ​KEY​,
​ 	  country_name ​text​ ​UNIQUE​
​ 	);
```
```
  ​CREATE​ ​TABLE​ cities (
​ 	  ​name​ ​text​ ​NOT​ ​NULL​,
​ 	  postal_code ​varchar​(9) ​CHECK​ (postal_code <> ​''​),
​ 	  country_code ​char​(2) ​REFERENCES​ countries,
​ 	  ​PRIMARY​ ​KEY​ (country_code, postal_code)
​ 	);
```
```
  public static Multi<Fruit> findAll(PgPool client) {
        return client.query("SELECT id, name FROM fruits ORDER BY name ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set)) 
                .onItem().transform(Fruit::from); 
    }

    private static Fruit from(Row row) {
        return new Fruit(row.getLong("id"), row.getString("name"));
    }

```

```java
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

public class Country {
    private String countryCode;
    private String countryName;

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public static Multi<Country> findAllCountries(PgPool client) {
        return client.query("SELECT country_code, country_name FROM countries ORDER BY country_name ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(Country::from);
    }

    private static Country from(Row row) {
        return new Country(row.getString("country_code"), row.getString("country_name"));
    }
}

public class City {
    private String name;
    private String postalCode;
    private String countryCode;

    public City(String name, String postalCode, String countryCode) {
        this.name = name;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
    }

    public static Multi<City> findAllCities(PgPool client) {
        return client.query("SELECT name, postal_code, country_code FROM cities ORDER BY name ASC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(City::from);
    }

    private static City from(Row row) {
        return new City(row.getString("name"), row.getString("postal_code"), row.getString("country_code"));
    }
}
```



    
