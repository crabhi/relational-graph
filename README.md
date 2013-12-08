# Relational Graph

SQL database treated as a graph.

Let's pretend the software is finished. You can take this document as a summary of the project's goals.

The parts which are not implemented yet are striked out.


~~Relational Graph is an implementation of [Blueprint API](https://github.com/tinkerpop/blueprints) aimed
at exposing the existing relational (SQL) databases as graph databases.~~


Many people currently use SQL databases for data which are viewed in a graph
oriented fashion. There is one central element and some related data to it.
An example to this may be a chemical structure. There can be quite a lot
of information related to a particular structure. This may be stock volume,
vendors offering it, measured phys-chem data, details about the experiments
and many more.

SQL is good for high volume data analysis, grouping and inferring aggregate
information. Current tools for working with SQL databases, like ORMs
often rely on code generation which suppose a schema known at compile time.
Therefore it's not trivial to create UIs which provide an easy view on main
and related data for any database.


~~The graph API allows you to treat your relational database as a graph one.
Every table is a vertex and every foreign key between them is an edge.
Moreover, every row in your table is a vertex and it is joined with the table
vertex. The row vertices are joined together with the corresponding row
vertices from other tables through edges which are created according to
the foreign key constraints. This approach allows you to easily traverse
the graph. The implementation will also strive to reduce the number of
SQL queries needed.~~

## Getting started

~~Include the maven dependency in your project.~~

~~Relational Graph doesn't require any import step. It can infer everything
from the underlying database. However, some data may be missing (foreign
keys) or can be costly to obtain, so the RG can optionally use some
meta-data storage.~~

~~To reduce the cost of parsing all the schema information and as a security
measure, you can specify a filter for the database artifacts. Maybe you
want only objects from one DB Schema or you don't want to show this column
to a particular set of users. If some of the filtered information is
already in the metadata store, it will be left untouched. However, only
info about the unfiltered artifacts will be added to the store.~~
```java
Graph graph = new SQLRGraph.Builder().connection(jdbcConn) // only mandatory thing
                                     .filter(filter) // you may exclude some DDL artifacts
                                     .mdStore(s) // optional
                                     .build();
```

~~This graph now contains all the information about the database.~~

## Mapping

All the properties which are added by Relational Graph and not coming
from the user data are surrounded by underscores. Those which are intended
to be consumed by the API user use single underscore. The double underscores
are reserved.

The row vertices will contain a property &#95;type&#95;, whose value is
the schema-qualified name of the table.

If there is a DB column named e. g. &#95;type&#95;, the row vertices will
have this property prefixed as &#95;col&#95;type&#95;.

## Limitations

Only tables which have a unique identifier for the rows ~~(may be composed
from multiple columns)~~ are supported.
